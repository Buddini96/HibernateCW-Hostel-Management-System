package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room implements SuperEntity {

    @Id
    private String roomId;
    private String type;
    private String rent;
    private int qty;

    @OneToMany(mappedBy = "room")
    private List<Reserve> list = new ArrayList();

    public Room(String roomId, String type, String rent, int qty) {
        this.roomId = roomId;
        this.type = type;
        this.rent = rent;
        this.qty = qty; }


    public Room(String id) {
        this.roomId = id;
    }
}
