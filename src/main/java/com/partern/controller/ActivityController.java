package com.partern.controller;

import com.partern.responsebo.responseenitiy.ResponseEntity;
import com.partern.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
@CacheConfig(cacheNames = "activityCache")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @RequestMapping("/getActivities")
    @Cacheable()
    public ResponseEntity getActivities(){
        return activityService.getActivities(6);
    }

}
