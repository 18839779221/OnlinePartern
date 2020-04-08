package com.partern.service;

import com.partern.bean.Concern;
import com.partern.bean.User;
import com.partern.mapper.ConcernMapper;
import com.partern.responsebo.*;
import com.partern.mapper.UserMapper;
import com.partern.responsebo.responseenitiy.Body;
import com.partern.responsebo.responseenitiy.Header;
import com.partern.responsebo.responseenitiy.ResponseEntity;
import com.partern.utils.MyMD5;
import com.partern.utils.RedisUtils;
import com.partern.utils.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Autowired
    ConcernMapper concernMapper;
    @Autowired
    RedisUtils redisUtils;

    @Value("${head_img.file_prefix}")
    String headImgPrefix;
    @Value("${head_img.path}")
    String headImgPath;


    @Override
    public ResponseEntity login(String uId, String uPassword) {
        ResponseEnum resType = ResponseEnum.ACCOUNT_NOT_EXIST;
        ResponseEntity response = new ResponseEntity();
        User user = userMapper.getUserByuId(uId);
        //验证分为账号不存在，密码不匹配，正确 三种情况
        if(user!=null){
            if(validPassword(uPassword,user.getU_password())){
                resType = ResponseEnum.USER_LOGIN_SUCCESS;
                response.setBody(new Body(new ResponseUser(user,getConcernCount(uId),getFansCount(uId))));
            }else{
                resType = ResponseEnum.USER_LOGIN_FAILED;
            }
        }
        Header header = new Header();
        header.setType(resType);
        response.setHeader(header);
        return response;
    }

    @Override
    public ResponseEntity getUsers() {
        List<User> users = userMapper.findUsers();
        User.noPassword(users);     //不传密码到前端
        return ResponseEntity.getPublicQueryResponse(users);
    }

    @Override
    public ResponseEntity register(User user) {
        user.setU_password(encodePassword(user.getU_password()));
        int result = userMapper.insert(user);
        return ResponseEntity.getPublicUpdateResponse(result);
    }

    @Override
    public ResponseEntity getUserById(String phone) {
//        User user = (User) redisUtils.get(phone+"uid");
//        if(user==null){
//            user = userMapper.getUserByuId(phone);
//            redisUtils.set(phone+"uid",user);
//        }
        User user = userMapper.getUserByuId(phone);
        User.noPassword(user);
        int fansCount = concernMapper.getFansCount(phone);
        int concernCount = concernMapper.getConcernCount(phone);
        return ResponseEntity.getPublicQueryResponse(new ResponseUser(user,concernCount,fansCount));
    }

    @Override
    public ResponseEntity getFansListById(String uId) {
        List<Concern> fans = concernMapper.getFansList(uId);
        return ResponseEntity.getPublicQueryResponse(fans);
    }

    @Override
    public ResponseEntity getConcernListById(String uId) {
        List<Concern> concerns = concernMapper.getConcernList(uId);
        return ResponseEntity.getPublicQueryResponse(concerns);
    }

    @Override
    public ResponseEntity getFansAndConcernListById(String uId) {
        List<Concern> concerns =  concernMapper.getConcernList(uId);
        List<Concern> fans = concernMapper.getFansList(uId);
        //构建关注状态，主要找出相互关注的用户
        HashMap<String, ResponseConcern> map = new HashMap<>();
        fans.forEach(fan->{
            String fid = fan.getU_id1();
            String fanNick = userMapper.getNickByuId(fid);
            map.put(fid,new ResponseConcern(fid,fanNick, ResponseConcern.CONCERN_STATE_FANS));
        });
        concerns.forEach(concern->{
            String cid = concern.getU_id2();
            if(map.containsKey(cid)){
                map.get(cid).setState(ResponseConcern.CONCERN_STATE_CONCERNEACH);
            }else{
                String concernNick = userMapper.getNickByuId(cid);
                map.put(cid,new ResponseConcern(cid,concernNick, ResponseConcern.CONCERN_STATE_CONCERN));
            }
        });
        System.out.println(map.values());
        return ResponseEntity.getPublicQueryResponse(map.values());
    }

    @Override
    public ResponseEntity getRecommmendUser(int limit) {

        List<User> users = userMapper.getLimitUsers(limit);
        List<ResponseUser> responseUsers = new ArrayList<>();
        users.forEach(user->{
            int fansCount = concernMapper.getFansCount(user.getU_id());
            int concernCount = concernMapper.getConcernCount(user.getU_id());
            responseUsers.add(new ResponseUser(user,concernCount,fansCount));
        });
        return ResponseEntity.getPublicQueryResponse(responseUsers);
    }

    @Override
    public ResponseEntity searchUserByIdOrNick(String searchText) {
        List<User> searchByIdUsers = userMapper.getLikeUsersById(searchText);
        List<User> searchByNickUsers = userMapper.getLikeUsersByNick(searchText);
        //删除重复元素
        for (User uById:searchByIdUsers){
            for(User uByNick:searchByNickUsers){
                if(uById.equals(uByNick)){
                    searchByNickUsers.remove(uByNick);
                }
            }
        }
        searchByIdUsers.addAll(searchByNickUsers);
        return ResponseEntity.getPublicQueryResponse(searchByIdUsers);
    }

    @Override
    public ResponseEntity updateLike(String phone,int like) {
        int result = userMapper.updateLike(phone,like);
        if(result==0){
            return ResponseEntity.getPublicFailResponse(null);
        }else{
            return ResponseEntity.getPublicSuccessResponse(null);
        }
    }


    /**
     * 获取粉丝数
     */
    private int getFansCount(String phone){
        return concernMapper.getFansCount(phone);
    }

    /*
    * 获取关注数
    */
    private int getConcernCount(String phone){
        return concernMapper.getConcernCount(phone);
    }


    /**
     * 密码加密
     */
    private String encodePassword(String password){
        return MyMD5.MD5WithSalt(password);
    }

    /**
     * 密码校验,将数据库的密文hash和明文password校验
     */
    private boolean validPassword(String password,String hash){
        return MyMD5.validMD5WithSalt(password,hash);
    }
}
