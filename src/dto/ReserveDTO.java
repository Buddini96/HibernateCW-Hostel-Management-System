package dto;

import entity.Room;
import entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDTO {

    private String resId;
    private String date;
    private Student student;
    private Room room;
    private String status;
}
