package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnSend;

    @FXML
    private TextField txtTo;

    @FXML
    private TextField txtCC;

    @FXML
    private TextField txtBcc;

    @FXML
    private TextField txtSubject;

    @FXML
    private TextArea txtMessage;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnSendOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message send");
        alert.setHeaderText(String.format("To: %s\nCC: %s\nBCC: %s\nSubject: %s", txtTo.getText(), txtCC.getText(), txtBcc.getText(), txtSubject.getText()));
        alert.setContentText(String.format("Message: \n%s", txtMessage.getText()));
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSend != null : "fx:id=\"btnSend\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtTo != null : "fx:id=\"txtTo\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtCC != null : "fx:id=\"txtCC\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtBcc != null : "fx:id=\"txtBcc\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtSubject != null : "fx:id=\"txtSubject\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
