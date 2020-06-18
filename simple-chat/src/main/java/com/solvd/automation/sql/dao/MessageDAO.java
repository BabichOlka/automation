package com.solvd.automation.sql.dao;


import com.solvd.automation.classes.c15.Message;

import java.util.List;

public interface MessageDAO  {
    void create(Message message);
    void update(Message message);
    void delete(Message message);

    Message getById(String id);
    List<Message> getAll();
    List<Message> getHistory();
}