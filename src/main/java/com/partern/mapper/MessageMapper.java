package com.partern.mapper;

import com.partern.bean.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}