package com.atguigu.springnoot.service;

import com.atguigu.springnoot.entities.Active;
import com.atguigu.springnoot.mapper.ActiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ActiveService {
    @Autowired
    private ActiveMapper activeMapper;//这个报错是可以忽略的，能正常使用

    @Transactional
    public void save(Active active) {

        this.activeMapper.insertSelective(active);

    }


    public Collection<Active> getAll() {

        return this.activeMapper.selectAll();
    }
}
