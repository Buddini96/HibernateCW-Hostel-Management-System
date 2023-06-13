package util;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
public class navigation {
    public static void navigate(AnchorPane anchorPane, String location) throws IOException {
        anchorPane.getChildren().clear();
        Parent parent = FXMLLoader.load(navigation.class.getResource("../view/" + location + "form.fxml"));
        anchorPane.getChildren().add(parent);
    }
    public static void popup(String location) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(navigation.class.getResource("../view/"+location+".fxml"))));
        stage.show();
    }

}
