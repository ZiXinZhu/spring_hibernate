package com.zzx.service;

import com.zzx.dao.GoodsDao;
import com.zzx.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
