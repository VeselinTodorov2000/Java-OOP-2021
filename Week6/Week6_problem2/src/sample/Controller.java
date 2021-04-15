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
    private TextField txtArray;

    @FXML
    private TextField txtPermutations;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnQuit;

    private void generatePermutations(int num1, int num2)
    @FXML
    void btnComputeOnAction(ActionEvent event) {
        char[] digits = txtArray.getText().toCharArray();
        int num1 = (int)(digits[1] - '0');
        int num2 = (int)(digits[4] - '0');
        int num3 = (int)(digits[7] - '0');
        int num4 = (int)(digits[10] - '0');

        System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert txtArray != null : "fx:id=\"txtArray\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtPermutations != null : "fx:id=\"txtPermutations\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCompute != null : "fx:id=\"btnCompute\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
