package dao.custom;

import dao.CrudDAO;
import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    List<User> search(String id) throws IOException;

    boolean login(String username,String password)throws IOException;
}
