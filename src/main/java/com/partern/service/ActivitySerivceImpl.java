package com.partern.service;

import com.partern.bean.Active;
import com.partern.mapper.ActiveMapper;
import com.partern.responsebo.responseenitiy.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitySerivceImpl implements ActivityService{

    @Autowired
    ActiveMapper activeMapper;

    @Override
    public ResponseEntity getActivities(int limit) {
        List<Active> actives = activeMapper.getLimitActives(limit);
        return ResponseEntity.getPublicQueryResponse(actives);
    }
}
