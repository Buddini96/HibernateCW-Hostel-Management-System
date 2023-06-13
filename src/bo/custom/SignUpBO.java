package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

public interface SignUpBO extends SuperBO {
    boolean save (UserDTO userDTO) throws Exception;
}
