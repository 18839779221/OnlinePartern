package com.partern.mapper;

import com.partern.bean.Concern;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcernMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Concern record);

    int insertSelective(Concern record);

    Concern selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Concern record);

    int updateByPrimaryKey(Concern record);
}