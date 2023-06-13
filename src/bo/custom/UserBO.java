package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserBO extends SuperBO {
    boolean update(UserDTO userDTO) throws Exception;
    List<UserDTO> search(String id) throws IOException;
    boolean save (UserDTO userDTO) throws Exception;
    boolean delete(String code) throws Exception;

}
