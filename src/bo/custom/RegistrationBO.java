package bo.custom;

import bo.SuperBO;
import dto.ReserveDTO;
import dto.RoomDTO;
import dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface RegistrationBO extends SuperBO {
    String generateNewID() throws IOException;
    String count(String id) throws IOException;

    List<String> StudentId() throws IOException;

    List<String> roomId() throws IOException;

    List<RoomDTO> searchROOM(String id) throws IOException;

    List<StudentDTO> searchStu(String id) throws IOException;
    boolean Save(ReserveDTO reserveDTO) throws Exception;

    List<ReserveDTO> getAll() throws Exception;









}
