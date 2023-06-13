package bo.custom;

import bo.SuperBO;

import java.io.IOException;
import java.util.List;

public interface DashBoardBO extends SuperBO {
    List<Object[]> details() throws IOException;
}
