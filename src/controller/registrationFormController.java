package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.RegistrationBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.ReserveDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Room;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class registrationFormController {
    public JFXTextField txtRegId;
    public JFXDatePicker cmbDateR;
    public JFXComboBox <String>cmbStudentIds;
    public JFXComboBox<String> cmbRoomTypeIds;
    public Label lblAvailabnility;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtStudentName;

   private final RegistrationBOImpl registrationBO = BOFactory.getInstance().getBO(BOType.REGISTRATION);
    public JFXTextField txtAddress;
    public JFXTextField txtType;
    public JFXTextField txtContact;
    public JFXTextField txtDob;
    public JFXTextField txtQty;
    public JFXTextField txtGender;
    public JFXButton btnReg;

    public void initialize (){
        cmbStudentIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    List<StudentDTO> search = registrationBO.searchStu(newValue);
                    for (StudentDTO dto : search) {
                        txtStudentName.setText(dto.getName());
                        txtAddress.setText(dto.getAddress());
                        txtContact.setText(dto.getContact());
                        txtDob.setText(dto.getDob());
                        txtGender.setText(dto.getGender());
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        cmbRoomTypeIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    List<RoomDTO> search = registrationBO.searchROOM(newValue);
                    for (RoomDTO dto : search) {
                        txtType.setText(dto.getType());
                        txtKeyMoney.setText(dto.getRent());
                        txtQty.setText(String.valueOf(dto.getQty()));
                    }

                    String co = registrationBO.count(newValue);
                    int count = Integer.parseInt(co);
                    int qty = Integer.parseInt(txtQty.getText());
                    if (count >= qty) {
                       btnReg.setDisable(true);
                        lblAvailabnility.setText("NOT Available");
                    } else {
                        lblAvailabnility.setText("Available");
                       btnReg.setDisable(false);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        loadAllStudentId ();
        loadAllRoomId ();
        generateNewId();



    }
    public void loadAllStudentId (){
        try {

            List<String> allStudentId = registrationBO.StudentId();

            for (String siDs : allStudentId
                 ) {
                cmbStudentIds.getItems().add(siDs);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAllRoomId (){
        try {
            List<String> allRoomIds =  registrationBO.roomId();

            for (String riDs: allRoomIds
                 ) {
                cmbRoomTypeIds.getItems().add(riDs);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {

        if (!txtStudentName.getText().isEmpty() && !txtType.getText().isEmpty()) {
            try {
                registrationBO.Save(new ReserveDTO(txtRegId.getText(), String.valueOf(cmbDateR.getValue()),new Student(cmbStudentIds.getValue()), new Room(cmbRoomTypeIds.getValue()), lblAvailabnility.getText()));
                new Alert(Alert.AlertType.CONFIRMATION, "Register").show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        generateNewId();
        loadAllStudentId ();


    }

    private void generateNewId() {
        try {
            String nId =  registrationBO.generateNewID();
            txtRegId.setText(nId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

        txtRegId.clear();
        lblAvailabnility.setText("");
        cmbStudentIds.getItems().clear();
        cmbRoomTypeIds.setValue("");
        txtStudentName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtDob.clear();
        txtGender.clear();
        txtType.clear();
        txtKeyMoney.clear();
        txtQty.clear();
        cmbDateR.getEditor().clear();

        generateNewId();
        loadAllStudentId();
    }
}
