package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.ManageRoomsBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.RoomTm;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class manageRoomsFormController {

    public AnchorPane roomContext;
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtKeyMoney;
    public JFXButton btnSaveRoom;
    public JFXTextField txtqty;
    public TableView <RoomTm> tblRoomDetails;

    private final ManageRoomsBO roomBO = BOFactory.getInstance().getBO(BOType.MANAGEROOMS);
    public JFXComboBox <String>cmbType;

    public void initialize (){
        cmbType.getItems().add("AC");
        cmbType.getItems().add("AC/Food ");
        cmbType.getItems().add("Non-AC");
        cmbType.getItems().add("Non-AC/Food");
        tblRoomDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblRoomDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblRoomDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("rent"));
        tblRoomDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblRoomDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSaveRoom.setText(newValue != null ? "Update" : "Save Room");
            if (newValue != null) {
                txtRoomTypeId.setText(newValue.getRoomId());
                cmbType.setValue(newValue.getType());
                txtKeyMoney.setText(newValue.getRent());
                txtqty.setText(String.valueOf(newValue.getQty()));
            }
        });

        loadAllRoom();





    }
    private void loadAllRoom() {
        tblRoomDetails.getItems().clear();

        try {
            List<RoomDTO> all = roomBO.getAll();

            for (RoomDTO rAll : all
                 ) {
                tblRoomDetails.getItems().add(new RoomTm(rAll.getRoomId(),rAll.getType(),rAll.getRent(),rAll.getQty()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void btnSaveRoomOnAction(ActionEvent actionEvent) {
        if (btnSaveRoom.getText().equalsIgnoreCase("Save Room")) {
            try {
                roomBO.save(new RoomDTO(txtRoomTypeId.getText(), cmbType.getValue(), txtKeyMoney.getText(),parseInt(txtqty.getText())));
                new Alert(Alert.AlertType.CONFIRMATION, "Saved room").show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                roomBO.update(new RoomDTO(txtRoomTypeId.getText(), cmbType.getValue(), txtKeyMoney.getText(), parseInt(txtqty.getText())));
                new Alert(Alert.AlertType.CONFIRMATION, "updated room").show();
                RoomTm selectedRoom = tblRoomDetails.getSelectionModel().getSelectedItem();
                selectedRoom.setRoomId(txtRoomTypeId.getText());
                selectedRoom.setType(cmbType.getValue());
                selectedRoom.setRent(txtKeyMoney.getText());
                selectedRoom.setQty(parseInt(txtqty.getText()));
                tblRoomDetails.refresh();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        loadAllRoom();


    }




    public void btnDeleteRoomOnAction(ActionEvent actionEvent) {
        if (!txtKeyMoney.getText().isEmpty() && !txtqty.getText().isEmpty() && !cmbType.getValue().isEmpty()) {
            String code = txtRoomTypeId.getText();
            try {
                roomBO.delete(code);
                new Alert(Alert.AlertType.CONFIRMATION, "delete room").show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            tblRoomDetails.getItems().remove(tblRoomDetails.getSelectionModel().getSelectedItem());
            tblRoomDetails.getSelectionModel().clearSelection();
        }



    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        txtRoomTypeId.clear();
        txtKeyMoney.clear();
        txtqty.clear();
        cmbType.setValue("Type");
        btnSaveRoom.setText("Save Room");
        txtRoomTypeId.requestFocus();
        tblRoomDetails.getSelectionModel().clearSelection();

    }
}
