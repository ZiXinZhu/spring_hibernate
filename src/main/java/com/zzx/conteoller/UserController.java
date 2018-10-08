package com.zzx.conteoller;

import com.zzx.entity.GoodsEntity;
import com.zzx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mr.John on 2018/9/17 16:02.
 **/
@Controller
public class UserController {

    @Autowired
    GoodsService service;

    @RequestMapping("/hello")
    public String hello(){
        return "index.jsp";
    }

    @RequestMapping("/save")
    public void save(GoodsEntity entity){
        service.save(entity);
    }
}