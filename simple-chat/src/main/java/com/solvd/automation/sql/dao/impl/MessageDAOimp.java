package com.solvd.automation.sql.dao.impl;

import com.solvd.automation.classes.c15.Message;
import com.solvd.automation.sql.SessionFactory;
import com.solvd.automation.sql.dao.MessageDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class MessageDAOimp implements MessageDAO {

    final static String namespace = "message_mapper";

    @Override
    public void create(Message message) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", message);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Message message) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", message);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Message message) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".delete", message);
        sqlSession.commit();
        sqlSession.close();
    }

        @Override
        public Message getById(String id) {
            SqlSession sqlSession = SessionFactory.getSession();
            Message message = sqlSession.selectOne(namespace + ".getById", id);
            sqlSession.close();
            return message;
        }
        @Override
        public List<Message> getAll() {
            SqlSession sqlSession = SessionFactory.getSession();
            List<Message> messages = sqlSession.selectList(namespace + ".getAll");
            sqlSession.close();
            return messages;
        }
    @Override
    public List<Message> getHistory() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Message> history = sqlSession.selectList(namespace + ".getHistory");
        sqlSession.close();
        return history;
    }
}