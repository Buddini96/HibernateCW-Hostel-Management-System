package view.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailTm {
    private Object name;
    private Object address;
    private Object content;
    private Object gender;
    private Object roomId;
    private Object date;
    private Object status;
}
