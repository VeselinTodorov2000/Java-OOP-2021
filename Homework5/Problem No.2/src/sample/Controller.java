package sample;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private enum Operation {Addition, Subtraction, Multiplication, Division};
    @FXML
    private TextField txtContent;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnZeroZero;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCC;

    @FXML
    private Button btnOff;

    private double memory;
    private Operation oper;

    @FXML
    void btnCCOnAction(ActionEvent event) {
        txtContent.setText("");
        memory = 0;
    }

    @FXML
    void btnCOnAction(ActionEvent event) {
        txtContent.setText("");
    }

    @FXML
    void btnDivideOnAction(ActionEvent event) {
        if(memory == 0) {
            memory = Double.parseDouble(txtContent.getText());
        }
        txtContent.setText("");
        oper = Operation.Division;
    }

    @FXML
    void btnDotOnAction(ActionEvent event) {
        String content = txtContent.getText();
        if(content.matches("[0-9]+"))
        {
            txtContent.setText(String.format("%s.", content));
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Double dots");
            alert.setContentText("You can't enter more than 1 dot");
            alert.showAndWait();
        }
    }

    @FXML
    void btnEightOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s8", content));
    }

    @FXML
    void btnEqualOnAction(ActionEvent event) {
        double displayed = Double.parseDouble(txtContent.getText());
        switch(oper)
        {
            case Addition:
                memory += displayed;
                txtContent.setText(String.format("%.2f", memory));
                break;
            case Subtraction:
                memory -= displayed;
                txtContent.setText(String.format("%.2f", memory));
                break;
            case Multiplication:
                memory *= displayed;
                txtContent.setText(String.format("%.2f", memory));
                break;
            case Division:
                if(displayed == 0)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Division");
                    alert.setContentText("You can't divide by zero");
                    alert.showAndWait();
                    return;
                }
                else
                {
                    memory /= displayed;
                }
                txtContent.setText(String.format("%.2f", memory));
                break;
        }
    }

    @FXML
    void btnFiveOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s5", content));
    }

    @FXML
    void btnFourOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s4", content));
    }

    @FXML
    void btnMinusOnAction(ActionEvent event) {
        if(memory == 0) {
            memory = Double.parseDouble(txtContent.getText());
        }
        oper = Operation.Subtraction;
        txtContent.setText("");
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event) {
        if(memory == 0) {
            memory = Double.parseDouble(txtContent.getText());
        }
        oper = Operation.Multiplication;
        txtContent.setText("");
    }

    @FXML
    void btnNineOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s9", content));
    }

    @FXML
    void btnOffOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnOneOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s1", content));
    }

    @FXML
    void btnPlusOnAction(ActionEvent event) {
        if(memory == 0) {
            memory = Double.parseDouble(txtContent.getText());
        }
        oper = Operation.Addition;
        txtContent.setText("");
    }

    @FXML
    void btnSevenOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s7", content));
    }

    @FXML
    void btnSixOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s6", content));
    }

    @FXML
    void btnThreeOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s3", content));
    }

    @FXML
    void btnTwoOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s2", content));
    }

    @FXML
    void btnZeroOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s0", content));
    }

    @FXML
    void btnZeroZeroOnAction(ActionEvent event) {
        String content = txtContent.getText();
        txtContent.setText(String.format("%s00", content));
    }

    @FXML
    void initialize() {
        assert txtContent != null : "fx:id=\"txtContent\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnZeroZero != null : "fx:id=\"btnZeroZero\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDot != null : "fx:id=\"btnDot\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEqual != null : "fx:id=\"btnEqual\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnC != null : "fx:id=\"btnC\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCC != null : "fx:id=\"btnCC\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
