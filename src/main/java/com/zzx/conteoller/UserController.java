package com.zzx.conteoller;

import com.zzx.dao.GoodsDao;
import com.zzx.dao.UserDao;
import com.zzx.entity.GoodsEntity;
import com.zzx.entity.UserEntity;
import com.zzx.listenerfilterintercept.inter.Permission;
import com.zzx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/17 16:02.
 **/
@Controller
public class UserController {

    @Autowired
    GoodsService service;
    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("/hello")
    public String hello(){
        return "404";
    }

    @RequestMapping("/save")
    @Permission(isPath = true)
    public ModelAndView save(GoodsEntity entity){
        service.save(entity);
        return new ModelAndView( "index");
    }
    @ResponseBody
    @RequestMapping("/all")
    public List<UserEntity> all(){
        System.out.println(goodsDao.all());
        return goodsDao.all();
    }
}
