package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.LoginBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class loginFormController {
    public AnchorPane loginContext;
    public JFXPasswordField pwdPassword;
    public JFXTextField txtUserName;

    private final LoginBOImpl loginBO = BOFactory.getInstance().getBO(BOType.LOGIN);
    public JFXTextField txtPasswordFiled;
    public JFXButton btnHide;
    public JFXButton btnShow;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {


        String userName = txtUserName.getText();
        String password = pwdPassword.getText();
        userFormController.username(userName);

        if (!userName.isEmpty() && !password.isEmpty()) {
            boolean login = loginBO.login(userName, password);
            if (login) {
                util.navigation.navigate(loginContext, "dashBoard");
            } else
                new Alert(Alert.AlertType.ERROR, "Invalid").show();
        } else
            new Alert(Alert.AlertType.ERROR, "Invalid").show();


    }

    public void btnSignInOnAction(ActionEvent actionEvent) throws IOException {

        util.navigation.navigate(loginContext, "signUp");

    }

    public void passwordShowOnAction(ActionEvent actionEvent) {
        txtPasswordFiled.setVisible(true);
        pwdPassword.setVisible(false);
        txtPasswordFiled.requestFocus();

        btnShow.setVisible(false);
        btnHide.setVisible(true);

        txtPasswordFiled.setText(pwdPassword.getText());
    }

    public void passwordHideOnAction(ActionEvent actionEvent) {
        txtPasswordFiled.setVisible(false);
        pwdPassword.setVisible(true);
        pwdPassword.requestFocus();

        btnShow.setVisible(true);
        btnHide.setVisible(false);

        pwdPassword.setText(txtPasswordFiled.getText());
    }
}
