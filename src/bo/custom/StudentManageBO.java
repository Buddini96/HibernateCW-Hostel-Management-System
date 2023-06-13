package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.List;

public interface StudentManageBO extends SuperBO  {
    boolean save (StudentDTO studentDTO) throws Exception;
    List<StudentDTO> getAll() throws Exception;

    boolean update(StudentDTO studentDTO) throws Exception;

    boolean delete(String id) throws Exception;

}
