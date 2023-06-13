package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.UserBO;
import bo.custom.impl.UserBoImpl;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class userFormController {
    static String userName;

    private final UserBoImpl userBo = BOFactory.getInstance().getBO(BOType.USER);
    public TextField txtPassword;
    public TextField txtUserName;

    public void initialize() {
        loadData();


    }

    public void loadData() {
        try {
            List<UserDTO> UserList = userBo.search(userName);
            for (UserDTO uL: UserList
                 ) {

                txtUserName.setText(uL.getUserName());
                txtPassword.setText(uL.getPassword());



            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void btnUpdateUserOnAction(ActionEvent actionEvent) {
        if (!txtUserName.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            try {
                userBo.delete(userName);
                userBo.save(new UserDTO(txtUserName.getText(), txtPassword.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void username(String id) {
        userName = id;
    }
}
