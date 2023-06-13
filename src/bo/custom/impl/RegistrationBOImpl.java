package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.RoomDAO;
import dao.custom.StudentDAO;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.ReserveDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.ReserveDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Reserve;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
  private final  ReserveDAOImpl reserveDAO = DAOFactory.getInstance().getDAO(DAOType.RESERVE);
  private final QueryDAOImpl queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
    private final RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);
 private final   StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public String generateNewID() throws IOException {

       return reserveDAO.generateNewID();
    }

    @Override
    public String count(String id) throws IOException {
       return reserveDAO.count(id);
    }

    @Override
    public List<String> StudentId() throws IOException {

        return queryDAO.StudentId();
    }

    @Override
    public List<String> roomId() throws IOException {

        return roomDAO.roomId();
    }

    @Override
    public List<RoomDTO> searchROOM(String id) throws IOException {
        List<Room> list = roomDAO.search(id);
        List<RoomDTO> roomDTO = new ArrayList<>();
        for (Room room:list) {
            roomDTO.add(new RoomDTO(room.getRoomId(), room.getType(), room.getRent(), room.getQty()));
        }
        return roomDTO;

    }

    @Override
    public List<StudentDTO> searchStu(String id) throws IOException {
        List<Student> list = studentDAO.search(id);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student:list) {
            studentDTOS.add(new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender()));
        }
        return studentDTOS;
    }

    @Override
    public boolean Save(ReserveDTO reserveDTO) throws Exception {
        return reserveDAO.save(new Reserve(reserveDTO.getResId(), reserveDTO.getDate(),reserveDTO.getStudent(),reserveDTO.getRoom(), reserveDTO.getStatus()));

    }

    @Override
    public List<ReserveDTO> getAll() throws Exception {
        List<Reserve> list = reserveDAO.getAll();
        List<ReserveDTO> ReserveDTOS = new ArrayList<>();
        for (Reserve sR:list) {
            ReserveDTOS .add(new ReserveDTO(sR.getResId(),sR.getDate(),sR.getStudent(), sR.getRoom(),sR.getStatus()));
        }
        return ReserveDTOS;
    }

}
