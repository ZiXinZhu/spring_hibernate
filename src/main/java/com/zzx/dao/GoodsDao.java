package com.zzx.dao;

import com.zzx.entity.GoodsEntity;
import com.zzx.entity.UserEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/17 16:27.
 **/

@Repository
public class GoodsDao {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public void save(GoodsEntity entity){
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
        session.save(entity);
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
    }

    public List<UserEntity> all(){
        Configuration configuration=new Configuration().configure();
        sessionFactory=configuration.buildSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        String sql="select * from user";
        SQLQuery sqlQuery=session.createSQLQuery(sql);
        List<UserEntity> list=sqlQuery.list();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return list;
    }
}
