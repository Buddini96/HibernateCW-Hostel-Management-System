package bo;

import bo.custom.ManageRoomsBO;
import bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType) {
            case DASHBOARD:
                return (T) new DashBoardBOImpl();
            case LOGIN:
                return (T) new LoginBOImpl();
            case MANAGEROOMS:
                return (T) new ManageRoomsBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
            case SIGNUP:
                return (T) new SignUpBOImpl();
            case STUDENTMANAGE:
                return (T) new StudentManageBOImpl();
            case USER:
                return (T) new UserBoImpl();
            default:
                return null;
        }
    }
}
