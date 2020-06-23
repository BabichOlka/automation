package com.solvd.automation.sql.dao.impl;


import com.solvd.automation.classes.c15.UserInfo;
import com.solvd.automation.sql.SessionFactory;
import com.solvd.automation.sql.dao.UserDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAOimp implements UserDAO {

    final static String namespace = "client_mapper";
    @Override
    public void create(UserInfo userInfo) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(UserInfo userInfo) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
           public void deleteUser(UserInfo userInfo) {
            SqlSession sqlSession = SessionFactory.getSession();
            sqlSession.delete(namespace + ".deleteById", userInfo);
            sqlSession.commit();
            sqlSession.close();
        }

        @Override
        public UserInfo getById(String id) {
            SqlSession sqlSession = SessionFactory.getSession();
            UserInfo userInfo = sqlSession.selectOne(namespace + ".getById", id);
            sqlSession.close();
            return userInfo;
        }
        @Override
        public List<UserInfo> getAll() {
            SqlSession sqlSession = SessionFactory.getSession();
            List<UserInfo> userInfo = sqlSession.selectList(namespace + ".getAll");
            sqlSession.close();
            return userInfo;
        }
    }