package com.zzx.dao;

import com.zzx.entity.GoodsEntity;
import com.zzx.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr.John on 2018/9/17 16:27.
 **/

@Repository
public class UserDao {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public void save(UserEntity entity){
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
        session.update(entity);
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
    }
}
