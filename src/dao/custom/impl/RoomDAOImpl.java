package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public List<Room> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Room> roomList = null;
        Query sessionQuery = session.createQuery("from Room");
        roomList = sessionQuery.list();
        transaction.commit();
        session.close();
        return roomList;


    }

    @Override
    public boolean save(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws Exception {
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
        session.delete(session.get(Room.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<String> roomId() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query studentId = session.createQuery("SELECT roomId FROM Room");
        List<String> list = studentId.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<Room> search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query room = session.createQuery("FROM Room  WHERE roomId = :id");
        room.setParameter("id", id);
        List<Room> list = room.list();
        transaction.commit();
        session.close();
        return list;
    }
}
