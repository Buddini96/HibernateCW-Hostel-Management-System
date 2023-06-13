package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.DashBoardBOImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class resFormController {
    public AnchorPane dashBoardContext;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane dashBoard2Context;


    public PieChart piechrtD;
    public TableView<DetailTm> tblRegistration;

    private  final DashBoardBOImpl boardBO= BOFactory.getInstance().getBO(BOType.DASHBOARD);


    public void initialize() {
//        loadDateAndTime();
        loadAllReserve();

        tblRegistration.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblRegistration.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblRegistration.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("content"));
        tblRegistration.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblRegistration.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblRegistration.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblRegistration.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));



    }

    public void loadAllReserve(){

        tblRegistration.getItems().clear();
        try {
            List<Object[]> detailsR = boardBO.details();
            for (Object[] rD:detailsR
            ) {
                tblRegistration.getItems().add(new DetailTm(rD[0],rD[1],rD[2],rD[3],rD[4],rD[5],rD[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

//    private void loadDateAndTime() {
//        /*set Date*/
//        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        /*set Time*/
//        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
//            LocalTime currentTime = LocalTime.now();
//            lblTime.setText(currentTime.getHour() + ":" +
//                    currentTime.getMinute() + ":" +
//                    currentTime.getSecond());
//        }),
//                new KeyFrame(Duration.seconds(1))
//        );
//        clock.setCycleCount(Animation.INDEFINITE);
//        clock.play();
//    }


}
