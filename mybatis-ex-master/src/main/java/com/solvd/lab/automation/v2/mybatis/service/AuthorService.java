package com.solvd.lab.automation.v2.mybatis.service;

import java.util.List;

public class AuthorService {
    AuthorDAO authorDAO = new AuthorDAOImpl();

    public Author getAuthorById(long id) {
        return authorDAO.getById(id);
    }

    public List<Author> getAllAuthors() {
        return authorDAO.get();
    }

    public void createAuthor(Author author) {
        authorDAO.create(author);
    }

    public void deleteAuthorById(long id) {
        authorDAO.delete(id);
    }

    public void updateAuthor(Author author) {
        authorDAO.update(author);
    }

    public static void main(String[] args) {
        AuthorDAO authorDAO1 = new AuthorDAOImpl();
        Author a = new Author("mike");
        authorDAO1.create(a);
        System.out.println(authorDAO1.getById(2).getName());

    }

}