package com.partern.mapper;

import com.partern.bean.Concern;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConcernMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Concern record);

    int insertSelective(Concern record);

    Concern selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Concern record);

    int updateByPrimaryKey(Concern record);

    int getConcernCount(String uId);

    int getFansCount(String uId);

    List<Concern> getFansList(String uId);

    List<Concern> getConcernList(String uId);
}