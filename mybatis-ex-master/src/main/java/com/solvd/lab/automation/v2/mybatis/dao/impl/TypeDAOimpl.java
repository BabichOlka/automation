package com.solvd.lab.automation.v2.mybatis.dao.impl;

import com.solvd.lab.automation.v2.mybatis.config.SessionFactory;
import com.solvd.lab.automation.v2.mybatis.model.Type;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TypeDAOimpl {
    private final static String namespace = "type_mapper";


    public void create(Type type) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", type);
        sqlSession.commit();
        sqlSession.close();
    }

    public Type getById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Type a = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return a;
    }


    public List<Type> get() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Type> as = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return as;
    }

    public void update(Type version) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", version);
        sqlSession.commit();
        sqlSession.close();
    }


    public void delete(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".deleteById", id);
        sqlSession.commit();
        sqlSession.close();
    }


}
