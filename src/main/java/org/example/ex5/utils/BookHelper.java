package org.example.ex5.utils;

import jakarta.persistence.criteria.*;
import org.example.ex5.entity.Author;
import org.example.ex5.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

import static org.example.ex5.utils.LogUtil.logException;
import static org.example.ex5.utils.LogUtil.logInfo;


public class BookHelper {
    private SessionFactory sessionFactory;
    private static final String CLASSNAME = BookHelper.class.getName();

    public BookHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void addBook(Book book) {
        logInfo("Adding " + book.getTitle(), CLASSNAME);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
            logInfo(book.getTitle() + " added", CLASSNAME);
        } catch (Exception e) {
            logException(e, CLASSNAME);
        }
    }
}
