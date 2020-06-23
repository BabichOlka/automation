package com.solvd.automation.lab.sql.dao.impl;


import com.solvd.automation.lab.model.Wheels;
import com.solvd.automation.lab.sql.SessionFactory;
import com.solvd.automation.lab.sql.dao.WheelsDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WheelsDAOimp implements WheelsDAO {

    final static String namespace = "wheels_mapper";

    @Override
    public void create(Wheels wheels) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", wheels);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Wheels wheels) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", wheels);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Wheels wheels) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".delete", wheels);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Wheels getById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Wheels wheels = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return wheels;
    }
    @Override
    public List<Wheels> getAll() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Wheels> wheels = sqlSession.selectList(namespace + ".getAll");
        sqlSession.close();
        return wheels;
    }

}
