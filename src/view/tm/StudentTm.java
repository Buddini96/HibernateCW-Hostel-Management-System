package view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentTm {
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private String dob;
    private String gender;
}
