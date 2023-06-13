package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

import java.io.IOException;

public interface LoginBO extends SuperBO {
    boolean login(String username,String password)throws IOException;

}
