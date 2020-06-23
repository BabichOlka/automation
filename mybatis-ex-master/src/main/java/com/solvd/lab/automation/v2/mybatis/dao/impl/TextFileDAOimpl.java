package com.solvd.lab.automation.v2.mybatis.dao.impl;

import com.solvd.lab.automation.v2.mybatis.config.SessionFactory;
import com.solvd.lab.automation.v2.mybatis.dao.TextFileDAO;
import com.solvd.lab.automation.v2.mybatis.model.TextFile;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TextFileDAOimpl implements TextFileDAO {
    private final static String namespace = "textFile_mapper";

    public void create(TextFile textFile) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", textFile);
        sqlSession.commit();
        sqlSession.close();
    }

    public TextFile  getById(int id) {
        SqlSession sqlSession = SessionFactory.getSession();
        TextFile textFile = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return textFile;
    }

    public List<TextFile> get() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<TextFile> textFiles = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return textFiles;
    }

    public void update(TextFile textFile) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", textFile);
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
