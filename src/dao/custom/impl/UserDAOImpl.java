package dao.custom.impl;

import dao.custom.UserDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(User.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query student = session.createQuery("FROM User  WHERE userName = :id");
        student.setParameter("id", id);
        List list = student.list();
        transaction.commit();
        session.close();
        return list;    }

    @Override
    public boolean login(String username, String password) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT password FROM User WHERE userName LIKE :username");
        query.setParameter("username", "%" + username + "%");
        List<String> list = query.list();
        transaction.commit();
        session.close();
        if (list.isEmpty()) {
            return false;
        }
        for (String user : list) {
            if (password.equals(user)) {
                return true;
            } else
                return false;
        }
        return false;
    }
}
