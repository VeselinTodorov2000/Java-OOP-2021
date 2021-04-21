package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLoanAmount;

    @FXML
    private TextField txtNumberOfYears;

    @FXML
    private Button btnShowTable;

    @FXML
    private TextArea txtContent;

    @FXML
    void btnShowTableOnAction(ActionEvent event) {
        txtContent.setText(String.format("Interest rate\tMonthlyPayment\tTotal payment"));
        double monthlyInterestRate = 5.0;
        while(monthlyInterestRate <= 8.0)
        {
            LoanComponent lc = new LoanComponent(monthlyInterestRate, Integer.parseInt(txtNumberOfYears.getText()),Double.parseDouble(txtLoanAmount.getText()));
            double monthlyPayment = lc.getLoanAmount() * (monthlyInterestRate / 100);
            String converted = String.format("%.3f\t       %.2f         %.2f", monthlyInterestRate, lc.computeMonthly(), lc.computeTotal());
            txtContent.setText(String.format("%s\n%s", txtContent.getText(), converted));
            monthlyInterestRate+=(1.0 / 8);
        }

    }

    @FXML
    void initialize() {
        assert txtLoanAmount != null : "fx:id=\"txtLoanAmount\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtNumberOfYears != null : "fx:id=\"txtNumberOfYears\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnShowTable != null : "fx:id=\"btnShowTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtContent != null : "fx:id=\"txtContent\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
