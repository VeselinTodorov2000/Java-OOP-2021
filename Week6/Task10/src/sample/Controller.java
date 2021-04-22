package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtDecimalNumber;

    @FXML
    private TextField txtOnesComplement;

    @FXML
    private TextField txtTwosComplement;

    @FXML
    private TextField txtSum;

    @FXML
    void btnCalculateOnAction(ActionEvent event) {
        byte entered = Byte.parseByte(txtDecimalNumber.getText());
        byte onesComplement = (byte)(entered ^ 1);
        byte twosComplement = (byte)(onesComplement + 1);
        txtOnesComplement.setText(String.format("%d", onesComplement));
        txtTwosComplement.setText(String.format("%d", twosComplement));
        txtSum.setText(String.format("%d", onesComplement + twosComplement));
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtDecimalNumber != null : "fx:id=\"txtDecimalNumber\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtOnesComplement != null : "fx:id=\"txtOnesComplement\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtTwosComplement != null : "fx:id=\"txtTwosComplement\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtSum != null : "fx:id=\"txtSum\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
