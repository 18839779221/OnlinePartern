package com.partern.mapper;

import com.partern.bean.Activity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);
}