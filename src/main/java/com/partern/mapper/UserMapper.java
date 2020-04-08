package com.partern.mapper;

import com.partern.bean.MyResult;
import com.partern.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(@Param("u_id") String uId, @Param("u_password") String uPassword);

    User getUserByuId(String uId);

    List<User> findUsers();

    String getNickByuId(String u_id);

    List<User> getLimitUsers(int limit);

    List<User> getLikeUsersById(String id);

    List<User> getLikeUsersByNick(String nick);

    int updateLike(@Param("u_id")String u_id,@Param("u_like")int u_like);

}