package com.solvd.automation.sql.dao;

import com.solvd.automation.classes.c15.UserInfo;

import java.util.List;

public interface UserDAO {
    void create(UserInfo userInfo);
    void update(UserInfo userInfo);
    void deleteUser(UserInfo userInfo);

    UserInfo getById(String id);
    List<UserInfo> getAll();
}
