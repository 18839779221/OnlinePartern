package com.partern.mapper;

import com.partern.bean.Active;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActiveMapper {

    List<Active> getLimitActives(int limit);
}