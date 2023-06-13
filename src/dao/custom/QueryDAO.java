package dao.custom;

import dao.SuperDAO;

import java.io.IOException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<String> StudentId() throws IOException;

    List<Object[]> details() throws IOException;

}
