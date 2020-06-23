package sql.dao.impl;

import org.apache.ibatis.session.SqlSession;
import sql.SessionFactory;
import sql.dao.AttributeDAO;
import sql.model.Attribute;

import java.util.List;

public class AttributeDAOimpl implements AttributeDAO {
    final static String namespace = "attribute_mapper";

    @Override
    public void create(Attribute attribute) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", attribute);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Attribute attribute) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", attribute);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Attribute attribute) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".delete", attribute);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Attribute getById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Attribute attribute = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return attribute;
    }
    @Override
    public List<Attribute> getAll() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Attribute> attributes = sqlSession.selectList(namespace + ".getAll");
        sqlSession.close();
        return attributes;
    }

}
