package com.atguigu.springnoot.controller;

import com.atguigu.springnoot.dao.ActiveDao;
import com.atguigu.springnoot.entities.Active;
import com.atguigu.springnoot.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class ActiveController {
    @Autowired
    ActiveDao activeDao;

    @Autowired
    ActiveService activeService;
    //查询所有活动返回列表页面  先尝试复用
    @RequestMapping("/actives")
    public String list(Model model){
//        Collection<Active> actives = activeDao.getAll();
        Collection<Active> actives = activeService.getAll();
        model.addAttribute("actives",actives);
        //复用之前的代码了
        return "active/list";
    }

    //来到活动管理页面
    @GetMapping("/active")
    public String toAddPage(Model model){
        Collection<Active> actives = activeDao.getAll();
        model.addAttribute("actives",actives);
        //复用之前的代码了
        return "active/add";
    }

    //添加活动
    @PostMapping("/active")
    public String addActive(Active active){
//        activeDao.save(active);
        activeService.save(active);
        //复用之前的代码了
        return "redirect:/actives";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/active/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Active active = activeDao.get(id);
        model.addAttribute("active",active);

        //要有信息回显
        Collection<Active> actives = activeDao.getAll();
        model.addAttribute("actives",actives);
        //回到修改页面
        return "active/add";
    }

}













