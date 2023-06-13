package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.UserDAOImpl;
import dto.UserDTO;

import java.io.IOException;

public class LoginBOImpl implements LoginBO {
   private final UserDAOImpl userDAO=DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public boolean login(String username, String password) throws IOException {
        return userDAO.login(username,password);
    }
}
