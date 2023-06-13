package dao;

import entity.SuperEntity;

import java.util.ArrayList;
import java.util.List;

public interface CrudDAO <T extends SuperEntity, ID> extends SuperDAO {
   List<T> getAll() throws Exception;

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID id) throws Exception;
}
