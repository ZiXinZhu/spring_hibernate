package com.zzx.service;

import com.zzx.dao.GoodsDao;
import com.zzx.entity.GoodsEntity;
import com.zzx.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/17 16:28.
 **/
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public void save(GoodsEntity entity){
        goodsDao.save(entity);
    }

    @Cacheable(value = "myCache", key = "'abc'")
    public List<UserEntity> all(){
        System.out.println("从数据库获取数据");
        return goodsDao.all();
    }
}
