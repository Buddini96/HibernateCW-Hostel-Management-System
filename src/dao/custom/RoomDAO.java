package dao.custom;

import dao.CrudDAO;
import entity.Room;

import java.io.IOException;
import java.util.List;


public interface RoomDAO extends CrudDAO<Room,String> {
    List<String> roomId() throws IOException;

    List<Room> search(String id) throws IOException;



}
