package org.example.ex5.utils;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.example.ex5.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.example.ex5.utils.LogUtil.logException;
import static org.example.ex5.utils.LogUtil.logInfo;

public class AuthorHelper {

    private static final String CLASSNAME = AuthorHelper.class.getName();
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void addAuthor(Author author) {
        logInfo("Adding " + author.getLastName(), CLASSNAME);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(author);
            session.getTransaction().commit();
            logInfo(author.getLastName() + " added", CLASSNAME);
        } catch (Exception e) {
            logException(e, CLASSNAME);
        }
    }
}
