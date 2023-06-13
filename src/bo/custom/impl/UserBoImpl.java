package bo.custom.impl;

import bo.custom.UserBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.UserDAOImpl;
import dto.UserDTO;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBO {
    private final UserDAOImpl userDAO= DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return userDAO.update(new User(userDTO.getUserName(),userDTO.getPassword()));
    }

    @Override
    public List<UserDTO> search(String id) throws IOException {
        List<User> search = userDAO.search(id);
        List<UserDTO> userDto = new ArrayList<>();
        for (User user : search) {
            userDto.add(new UserDTO(user.getUserName(), user.getPassword()));
        }
        return userDto;
    }

    @Override
    public boolean save(UserDTO userDTO) throws Exception {
        return userDAO.save(new User(userDTO.getUserName(),userDTO.getPassword()));
    }

    @Override
    public boolean delete(String code) throws Exception {
        return userDAO.delete(code);
    }
}
