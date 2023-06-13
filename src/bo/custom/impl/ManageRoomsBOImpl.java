package bo.custom.impl;

import bo.custom.ManageRoomsBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.RoomDAO;
import dao.custom.impl.RoomDAOImpl;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Room;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ManageRoomsBOImpl implements ManageRoomsBO {
    private final RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);
    @Override
    public boolean save(RoomDTO roomDTO) throws Exception {
        return roomDAO.save(new Room(roomDTO.getRoomId(), roomDTO.getType(), roomDTO.getRent(), roomDTO.getQty()));
    }

    @Override
    public List<RoomDTO> getAll() throws Exception {
        List<Room> daoAll = roomDAO.getAll();
        List rList = new ArrayList();

        for (Room st: daoAll
        ) {

            rList.add(new RoomDTO(st.getRoomId(),st.getType(),st.getRent(),st.getQty()));

        }
        return rList;
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {

        return roomDAO.update(new Room(roomDTO.getRoomId(), roomDTO.getType(), roomDTO.getRent(), roomDTO.getQty()));

    }

    @Override
    public boolean delete(String id) throws Exception {
        return roomDAO.delete(id);
    }
}
