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
    private TextField txtField;

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
    private Button btnSIx;

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
    private Button btnMinus;

    @FXML
    private Button btnDivision;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnOff;

    private double memory;
    private String txtBox;
    private char operation;
    private static boolean memoryClear = true;

    private double evaluate()
    {
        if(memoryClear == true)
        {
            return 0;
        }
        double current = Double.parseDouble(txtBox);
        switch(operation)
        {
            case '+': return memory + current;
            case '-': return memory - current;
            case '*': return memory * current;
            case '/': return current != 0 ? memory / current : 0;
            default: return memory;
        }
    }

    @FXML
    void btnClearAllOnAction(ActionEvent event) {
        txtBox = "";
        txtField.setText(txtBox);
        memoryClear = true;
        operation = ' ';
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtBox = "";
        txtField.setText(txtBox);
    }

    @FXML
    void btnDivisionOnAction(ActionEvent event) {

        memory = Double.parseDouble(txtBox);
        txtBox = "";
        txtField.setText(txtBox);
        operation = '/';
    }

    @FXML
    void btnDotOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s.", txtField.getText());
        txtField.setText(txtBox);
    }
    @FXML
    void btnEightOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s8", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnEqualOnAction(ActionEvent event) {
        memory = evaluate();
        memoryClear = false;
        txtBox = String.format("%f", memory);
        txtField.setText(txtBox);
        operation = ' ';
        }

    @FXML
    void btnFiveOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s5", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnFourOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s4", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnMinusOnAction(ActionEvent event) {
        operation = '-';
        memory = Double.parseDouble(txtBox);
        txtBox = "";
        txtField.setText(txtBox);
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event) {
        operation = '*';
        memory = Double.parseDouble(txtBox);
        txtBox = "";
        txtField.setText(txtBox);
    }

    @FXML
    void btnNineOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s9", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnOffOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnOneOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s1", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnPlusOnAction(ActionEvent event) {
        if(txtBox != " " && memoryClear != false)
        {

        }
        operation = '+';
        memory = Double.parseDouble(txtBox);
        txtBox = "";
        txtField.setText(txtBox);
    }

    @FXML
    void btnSevenOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s7", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnSixOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s6", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnThreeOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s3", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnTwoOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s2", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnZeroOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s0", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void btnZeroZeroOnAction(ActionEvent event) {
        memoryClear = false;
        txtBox = String.format("%s00", txtField.getText());
        txtField.setText(txtBox);
    }

    @FXML
    void initialize() {
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSIx != null : "fx:id=\"btnSIx\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnZeroZero != null : "fx:id=\"btnZeroZero\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDivision != null : "fx:id=\"btnDivision\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDot != null : "fx:id=\"btnDot\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEqual != null : "fx:id=\"btnEqual\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
