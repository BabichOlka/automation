package com.solvd.lab.automation.v2.mybatis.service;

import java.util.List;

public class ItemService {
    ItemDAO itemDAO = new ItemDAOImpl();

    public Item getItemById(long id) {
        return itemDAO.getById(id);
    }

    public List<Item> getAllItems() {
        return itemDAO.get();
    }

    public void createItem(Item item) {
        itemDAO.create(item);
    }

    public void deleteItemById(long id) {
        itemDAO.delete(id);
    }

    public void updateItem(Item item) {
        itemDAO.update(item);
    }
}