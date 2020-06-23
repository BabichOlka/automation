package com.solvd.automation.lab.sql.dao.impl;
import com.solvd.automation.lab.model.Engine;
import com.solvd.automation.lab.sql.SessionFactory;
import com.solvd.automation.lab.sql.dao.EngineDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EngineDAOimp implements EngineDAO {

    final static String namespace = "engine_mapper";

    @Override
    public void create(Engine engine) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", engine);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Engine engine) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", engine);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Engine engine) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".delete", engine);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Engine getById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Engine engine = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return engine;
    }
    @Override
    public List<Engine> getAll() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Engine> engine = sqlSession.selectList(namespace + ".getAll");
        sqlSession.close();
        return engine;
    }
}