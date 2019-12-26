package com.partern.service;

import com.partern.bean.Concern;
import com.partern.bean.User;
import com.partern.mapper.ConcernMapper;
import com.partern.responsebo.Body;
import com.partern.responsebo.Header;
import com.partern.responsebo.ResponseEntity;
import com.partern.mapper.UserMapper;
import com.partern.responsebo.ResponseUser;
import com.partern.utils.MyMD5;
import com.partern.utils.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Autowired
    ConcernMapper concernMapper;

    @Override
    public ResponseEntity login(String uId, String uPassword) {
        ResponseEnum resType = ResponseEnum.ACCOUNT_NOT_EXIST;
        ResponseEntity response = new ResponseEntity();
        User user = userMapper.getUserByuId(uId);
        //验证分为账号不存在，密码不匹配，正确 三种情况
        if(user!=null){
            if(validPassword(uPassword,user.getU_password())){
                resType = ResponseEnum.USER_LOGIN_SUCCESS;
            }else{
                resType = ResponseEnum.USER_LOGIN_FAILED;
                user = null;
            }
        }
        response.setBody(new Body(new ResponseUser(user,getConcernCount(uId),getFansCount(uId))));
        Header header = new Header();
        header.setType(resType);
        header.setTimestamp(new Date().getTime()+"");
        response.setHeader(header);
        return response;
    }

    @Override
    public ResponseEntity getUsers() {
        List<User> users = userMapper.findUsers();
        User.noPassword(users);     //不传密码到前端
        ResponseEntity response = new ResponseEntity();
        response.setBody(new Body(users));
        Header header = new Header();
        ResponseEnum resType = null;
        resType = users==null?ResponseEnum.FAILURE:ResponseEnum.SUCCESS;
        header.setType(resType);
        header.setTimestamp(new Date().getTime()+"");
        response.setHeader(header);
        return response;
    }

    @Override
    public ResponseEntity register(User user) {
        user.setU_password(encodePassword(user.getU_password()));
        int result = userMapper.insert(user);
        ResponseEntity response = new ResponseEntity();
        response.setBody(new Body(result));
        Header header = new Header();
        ResponseEnum resType = null;
        resType = result==0?ResponseEnum.FAILURE:ResponseEnum.SUCCESS;
        header.setType(resType);
        header.setTimestamp(new Date().getTime()+"");
        response.setHeader(header);
        return response;
    }

    @Override
    public ResponseEntity getUserById(String phone) {
        User user = userMapper.getUserByuId(phone);
        ResponseEntity response = new ResponseEntity();
        response.setBody(new Body(new ResponseUser(user,getConcernCount(phone),getFansCount(phone))));
        Header header = new Header();
        ResponseEnum resType = user==null?ResponseEnum.FAILURE:ResponseEnum.SUCCESS;
        header.setType(resType);
        header.setTimestamp(new Date().getTime()+"");
        response.setHeader(header);
        return response;
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
