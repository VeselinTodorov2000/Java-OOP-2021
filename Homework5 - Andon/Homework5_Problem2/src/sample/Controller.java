package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller extends AnchorPane {

    private enum Operation {PLUS, MINUS, MULTIPLY, DIVIDE};

    public Controller() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/sample.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtField;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn0;

    @FXML
    private Button btn00;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnPoint;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCA;

    @FXML
    private Button btnOFF;

    @FXML
    private Button btnM;

    @FXML
    private Button btnMPlus;

    @FXML
    private Button btnMMinus;

    @FXML
    private Button btnMCMinus;

    private double result;
    private Operation operation;
    private boolean isLastOperationEquals;  // is the last pressed button is '='
    private double memory;  // used for M, M-, M+, MC- operations

    private void clearResultMemory() {
        result = 0;
        operation = null;
    }

    private void calculateCurrentResultAndClearTxtField() {
        switch (operation) {
            case PLUS: {
                result += Double.parseDouble(txtField.getText());
                txtField.clear();
                break;
            }
            case MINUS: {
                result -= Double.parseDouble(txtField.getText());
                txtField.clear();
                break;
            }
            case MULTIPLY: {
                result *= Double.parseDouble(txtField.getText());
                txtField.clear();
                break;
            }
            case DIVIDE: {
                result /= Double.parseDouble(txtField.getText());
                txtField.clear();
                break;
            }
        }
    }

    public double getResult() {
        return result;
    }

    public void setInput(double number) {
        txtField.clear();
        isLastOperationEquals = false;
        txtField.setText(Double.toString(number));
    }

    public void setInput(int number) {
        txtField.clear();
        isLastOperationEquals = false;
        txtField.setText(Integer.toString(number));
    }

    @FXML
    public void btn00OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "00");
    }

    @FXML
    public void btn0OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "0");
    }

    @FXML
    public void btn1OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "1");
    }

    @FXML
    public void btn2OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "2");
    }

    @FXML
    public void btn3OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "3");
    }

    @FXML
    public void btn4OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "4");
    }

    @FXML
    public void btn5OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "5");
    }

    @FXML
    public void btn6OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "6");
    }

    @FXML
    public void btn7OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "7");
    }

    @FXML
    public void btn8OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "8");
    }

    @FXML
    public void btn9OnAction(ActionEvent event) {
        if (isLastOperationEquals) {
            txtField.clear();    // if last button is '=', clear the text field
            isLastOperationEquals = false;
        }

        String text = txtField.getText();
        txtField.setText(text + "9");
    }

    @FXML
    public void btnCAOnAction(ActionEvent event) {
        char[] text = txtField.getText().toCharArray();
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < text.length - 1; i++) {
            newText.append(text[i]);
        }

        txtField.clear();
        txtField.setText(newText.toString());
    }

    @FXML
    public void btnCOnAction(ActionEvent event) {
        txtField.clear();
        clearResultMemory();
    }

    @FXML
    public void btnDivideOnAction(ActionEvent event) {
        if (operation == null) {
            result = Double.parseDouble(txtField.getText());
            operation = Operation.DIVIDE;
            txtField.clear();
        } else {
            calculateCurrentResultAndClearTxtField();
            operation = Operation.DIVIDE;
        }
    }

    @FXML
    public void btnEqualOnAction(ActionEvent event) {
        calculateCurrentResultAndClearTxtField();
        txtField.setText(Double.toString(result));
        clearResultMemory();
        isLastOperationEquals = true;
    }

    @FXML
    public void btnMCMinusOnAction(ActionEvent event) {
        memory = 0;
    }

    @FXML
    public void btnMMinusOnAction(ActionEvent event) {
        clearResultMemory();
        memory -= Double.parseDouble(txtField.getText());
        txtField.clear();
        txtField.setText(Double.toString(memory));
    }

    @FXML
    public void btnMOnAction(ActionEvent event) {
        memory = Double.parseDouble(txtField.getText());
    }

    @FXML
    public void btnMPlusOnAction(ActionEvent event) {
        clearResultMemory();
        memory += Double.parseDouble(txtField.getText());
        txtField.clear();
        txtField.setText(Double.toString(memory));
    }

    @FXML
    public void btnMinusOnAction(ActionEvent event) {
        if (operation == null) {
            result = Double.parseDouble(txtField.getText());
            operation = Operation.MINUS;
            txtField.clear();
        } else {
            calculateCurrentResultAndClearTxtField();
            operation = Operation.MINUS;
        }
    }

    @FXML
    public void btnMultiplyOnAction(ActionEvent event) {
        if (operation == null) {
            result = Double.parseDouble(txtField.getText());
            operation = Operation.MULTIPLY;
            txtField.clear();
        } else {
            calculateCurrentResultAndClearTxtField();
            operation = Operation.MULTIPLY;
        }
    }

    @FXML
    public void btnOFFOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void btnPlusOnAction(ActionEvent event) {
        if (operation == null) {
            result = Double.parseDouble(txtField.getText());
            operation = Operation.PLUS;
            txtField.clear();
        } else {
            calculateCurrentResultAndClearTxtField();
            System.out.println(result);
            operation = Operation.PLUS;
        }
    }

    @FXML
    public void btnPointOnAction(ActionEvent event) {
        String text = txtField.getText();
        txtField.setText(text + ".");
    }

    @FXML
    void initialize() {
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn00 != null : "fx:id=\"btn00\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEqual != null : "fx:id=\"btnEqual\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPoint != null : "fx:id=\"btnPoint\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnC != null : "fx:id=\"btnC\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCA != null : "fx:id=\"btnCA\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOFF != null : "fx:id=\"btnOFF\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnM != null : "fx:id=\"btnM\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMPlus != null : "fx:id=\"btnMPlus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMMinus != null : "fx:id=\"btnMMinus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMCMinus != null : "fx:id=\"btnMCMinus\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
