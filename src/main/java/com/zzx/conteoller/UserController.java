package com.zzx.conteoller;

import com.zzx.entity.GoodsEntity;
import com.zzx.listenerfilterintercept.inter.Permission;
import com.zzx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mr.John on 2018/9/17 16:02.
 **/
@Controller
public class UserController {

    @Autowired
    GoodsService service;

    @RequestMapping("/hello")
    public String hello(){
        return "index";
    }

    @RequestMapping("/save")
    @Permission(isPath = true)
    public ModelAndView save(GoodsEntity entity){
        service.save(entity);
        return new ModelAndView( "index");
    }
}
