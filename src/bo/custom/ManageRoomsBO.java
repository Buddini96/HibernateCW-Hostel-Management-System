package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;
import dto.StudentDTO;

import java.util.List;

public interface ManageRoomsBO extends SuperBO {
    boolean save (RoomDTO roomDTO) throws Exception;
    List<RoomDTO> getAll() throws Exception;

    boolean update(RoomDTO rooDTO) throws Exception;

    boolean delete(String id) throws Exception;
}
