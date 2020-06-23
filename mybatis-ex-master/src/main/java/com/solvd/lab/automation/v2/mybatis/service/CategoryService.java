package com.solvd.lab.automation.v2.mybatis.service;

import java.util.List;

public class CategoryService {
    CategoryDAO categoryDAO = new CategoryDAOImpl();

    public Category getCategoryById(long id) {
        return categoryDAO.getById(id);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.get();
    }

    public void createCategory(Category category) {
        categoryDAO.create(category);
    }

    public void deleteCategoryById(long id) {
        categoryDAO.delete(id);
    }

    public void updateCategory(Category category) {
        categoryDAO.update(category);
    }
}
