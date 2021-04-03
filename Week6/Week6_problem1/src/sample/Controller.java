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
    private Button btnCompute;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtGCD;

    @FXML
    void btnComputeOnAction(ActionEvent event) {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());

        int gcd = gcd(a, b);
        txtGCD.setText(String.format("%d", gcd));
    }

    private int gcd(int a, int b)
    {
        if(b != 0)
        {
            return gcd(b, a%b);
        }
        else
        {
            return Math.abs(a);
        }
    }

    private double sum(int i, double sum, int end)
    {
        if(i > end)
        {
            return sum;
        }
        else
        {
            sum += (double) i / (2 * i + 1);
            i++;
            return sum(i, sum, end);
        }
    }
    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        System.out.println(sum(1, 0, 10));
        assert btnCompute != null : "fx:id=\"btnCompute\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtGCD != null : "fx:id=\"txtGCD\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
