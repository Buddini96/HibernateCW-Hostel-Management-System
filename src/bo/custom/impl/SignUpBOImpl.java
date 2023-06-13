package bo.custom.impl;

import bo.custom.SignUpBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.UserDAOImpl;
import dto.UserDTO;
import entity.User;

public class SignUpBOImpl implements SignUpBO {
    private final UserDAOImpl userDAO = DAOFactory.getInstance().getDAO(DAOType.USER);
    @Override
    public boolean save(UserDTO userDTO) throws Exception {

        return userDAO.save(new User(userDTO.getUserName(),userDTO.getPassword()));
    }
}
