package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.DashBoardBOImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import view.tm.DetailTm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class dashBoardFormController {
    public AnchorPane dashBoardContext;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane dashBoard2Context;
    public AnchorPane dashBoardContext1;
    public AnchorPane dashBoard2Context2;

    public PieChart piechrtD;
    public TableView<DetailTm> tblRegistration;

    private  final DashBoardBOImpl boardBO= BOFactory.getInstance().getBO(BOType.DASHBOARD);


    public void initialize() {
        loadDateAndTime();



    }



    private void loadDateAndTime() {
        /*set Date*/
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        /*set Time*/
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> { //jj
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnManageStudentsOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(dashBoard2Context, "studentManage");

    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(dashBoard2Context, "manageRooms");
    }

    public void btnMakeRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(dashBoard2Context, "registration");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(dashBoardContext, "login");

    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(dashBoard2Context, "user");

    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(dashBoardContext, "dashBoard");
    }

    public void btnReservationDetailsOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(dashBoard2Context, "res");
    }
}
