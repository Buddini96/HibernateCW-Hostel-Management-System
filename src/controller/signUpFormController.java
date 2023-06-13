package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.SignUpBOImpl;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class signUpFormController {
    public AnchorPane signUpContext;

    private final SignUpBOImpl signUpBO = BOFactory.getInstance().getBO(BOType.SIGNUP);
    public JFXTextField txtName;
    public JFXPasswordField pwdPassword;
    public JFXPasswordField pwdPassword1;

    public void btnSignUpOnAction(ActionEvent actionEvent) {
        if (!txtName.getText().isEmpty() && !pwdPassword.getText().isEmpty()) {
            if (pwdPassword.getText().equals(pwdPassword1.getText())) {
                try {
                    signUpBO.save(new UserDTO(txtName.getText(), pwdPassword.getText()));
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, "Invalid user name").show();
                    throw new RuntimeException(e);
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid Data").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid Data").show();
        }


    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(signUpContext, "login");
    }
}
