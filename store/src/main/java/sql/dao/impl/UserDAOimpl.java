package sql.dao.impl;

import org.apache.ibatis.session.SqlSession;
import sql.SessionFactory;

import sql.dao.UserDAO;
import sql.model.User;

import java.util.List;

public class UserDAOimpl implements UserDAO {
    final static String namespace = "user_mapper";


    public void create(User user) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", user);
        sqlSession.commit();
        sqlSession.close();
    }


    public void update(User user) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", user);
        sqlSession.commit();
        sqlSession.close();
    }


    public void delete(User user) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".delete", user);
        sqlSession.commit();
        sqlSession.close();
    }


    public User getById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        User user = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return user;
    }

    public List<User> getAll() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<User> users = sqlSession.selectList(namespace + ".getAll");
        sqlSession.close();
        return users;
    }
}
