package com.partern.mapper;

import com.partern.bean.SelfUserDetails;
import com.partern.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(@Param("uId") String uId, @Param("uPassword") String uPassword);

    User getUserByuId(String uId);
}