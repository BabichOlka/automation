package com.solvd.automation.lab.sql.dao.impl;

import com.solvd.automation.lab.model.Point;
import com.solvd.automation.lab.sql.SessionFactory;
import com.solvd.automation.lab.sql.dao.PointDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PointDAOimp implements PointDAO {

    final static String namespace = "point_mapper";
    @Override
    public void create(Point point) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", point);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Point point) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", point);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".deleteById", id);
        sqlSession.commit();
        sqlSession.close();
    }


    @Override
    public Point getById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Point point = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return point;
    }
    @Override
    public List<Point> getAll() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Point> point = sqlSession.selectList(namespace + ".getAll");
        sqlSession.close();
        return point;
    }
}