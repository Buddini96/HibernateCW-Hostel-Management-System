package bo.custom.impl;

import bo.custom.StudentManageBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManageBOImpl implements StudentManageBO {
    private final StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    


    @Override
    public boolean save(StudentDTO studentDTO) throws Exception {

        studentDAO.save(new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact(),studentDTO.getDob(),studentDTO.getGender()));

        return true;
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        List<Student> daoAll = studentDAO.getAll();
        List sList = new ArrayList();

        for (Student st: daoAll
             ) {

            sList.add(new StudentDTO(st.getStudentId(),st.getName(),st.getAddress(),st.getContact(),st.getDob(),st.getGender()));
            
        }
        return sList;
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        studentDAO.update(new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact(),studentDTO.getDob(),studentDTO.getGender()));


        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {

        return studentDAO.delete(id);
    }
}
