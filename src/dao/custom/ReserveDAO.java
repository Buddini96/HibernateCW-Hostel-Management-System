package dao.custom;

import dao.CrudDAO;
import entity.Reserve;

import java.io.IOException;
import java.util.List;

public interface ReserveDAO extends CrudDAO<Reserve,String> {
    String generateNewID() throws IOException;

    String count(String id) throws IOException;

    List<String> StudentId() throws IOException;


}
