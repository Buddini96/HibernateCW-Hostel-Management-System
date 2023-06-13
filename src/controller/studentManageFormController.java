package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.StudentManageBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTm;

import java.time.LocalDate;
import java.util.List;

public class studentManageFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStContact;
    public ComboBox <String> cmbStuGender;
    public JFXDatePicker txtDate;
    public TableView <StudentTm> tblStudentDetails;
    public JFXTextField txtStudentName;
    public JFXButton btnSaveStudent;
    private final StudentManageBOImpl studentManageBO =BOFactory.getInstance().getBO(BOType.STUDENTMANAGE);

    public void initialize (){
        cmbStuGender.getItems().add("Male");
        cmbStuGender.getItems().add("Female");
        loadAll();

        tblStudentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStudentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudentDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblStudentDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStudentDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));


        tblStudentDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSaveStudent.setText(newValue != null ? "Update" : "Save Student");
            if (newValue != null) {
                txtStudentId.setText(newValue.getStudentId());
                txtStudentName.setText(newValue.getName());
                txtStudentAddress.setText(newValue.getAddress());
                txtStContact.setText(newValue.getContact());
                txtDate.setValue(LocalDate.parse(newValue.getDob()));
                cmbStuGender.setValue(newValue.getGender());

            }
        });

    }

    public void btnSaveStudent(ActionEvent actionEvent) {


       if(btnSaveStudent.getText().equals("Save Student")) {
           try {

               studentManageBO.save(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStContact.getText(), String.valueOf(txtDate.getValue()), cmbStuGender.getValue()));
           } catch (Exception e) {
               e.printStackTrace();

           }


       }
       else {
           try {
               studentManageBO.update(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStContact.getText(), String.valueOf(txtDate.getValue()), cmbStuGender.getValue()));
               new Alert(Alert.AlertType.CONFIRMATION, "update student").show();
               StudentTm selectedStudent = tblStudentDetails.getSelectionModel().getSelectedItem();
               selectedStudent.setStudentId(txtStudentId.getText());
               selectedStudent.setName(txtStudentName.getText());
               selectedStudent.setAddress(txtStudentAddress.getText());
               selectedStudent.setContact(txtStContact.getText());
               selectedStudent.setDob(String.valueOf(txtDate.getValue()));
               selectedStudent.setGender(cmbStuGender.getValue());
               tblStudentDetails.refresh();
           } catch (Exception e) {
               throw new RuntimeException(e); }
       }
           loadAll();
    }


    public void btnDelete(ActionEvent actionEvent) {
        try {
            studentManageBO.delete(txtStudentId.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadAll();
    }

    public void btnAddNewStudent(ActionEvent actionEvent) {
        btnSaveStudent.setText("Save Student");
        txtStudentId.clear();
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtStContact.clear();
        cmbStuGender.setValue(" ");
        txtDate.getEditor().clear();
        txtStudentId.requestFocus();


    }
    public void loadAll(){
        tblStudentDetails.getItems().clear();
        try {
            
            List<StudentDTO> studentDTOList = studentManageBO.getAll();
            for (StudentDTO student :studentDTOList) {
                tblStudentDetails.getItems().add(new StudentTm(student.getStudentId(), student.getName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnUpdateStudent(ActionEvent actionEvent) {
    }
}
