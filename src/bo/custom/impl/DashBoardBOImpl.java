package bo.custom.impl;

import bo.custom.DashBoardBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.QueryDAOImpl;

import java.io.IOException;
import java.util.List;

public class DashBoardBOImpl implements DashBoardBO {
    private final QueryDAOImpl queryDAO =DAOFactory.getInstance().getDAO(DAOType.QUERY);
    @Override
    public List<Object[]> details() throws IOException {

        return queryDAO.details();
    }
}
