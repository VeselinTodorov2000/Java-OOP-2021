package com.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.providers.*;

public class GeneratorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    private Button btnRandomLetters;

    @FXML
    private Button btnRandomSubset;

    @FXML
    private Button btnQuit;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnRandomLettersOnAction(ActionEvent event) {
        if(!checkEmptyFields(txtSize.getText(), txtSeed.getText())){
            return;
        }
        int size = Integer.parseInt(txtSize.getText());
        int seed = Integer.parseInt(txtSeed.getText());
        Wrapper wrapper = new Wrapper(size);
        com.providers.Result result =  CipherGenerator.countDistinct(wrapper.makeFixedRandom(), seed);
        messageBox("Random subsequence of letters A - Z", "Count distinct characters out of " + size, result.toString());
    }

    @FXML
    void btnRandomSubsetOnAction(ActionEvent event) {
        if(!checkEmptyFields(txtSize.getText(), txtSeed.getText())){
            return;
        }
        int size = Integer.parseInt(txtSize.getText());
        int seed = Integer.parseInt(txtSeed.getText());
        Wrapper wrapper = new Wrapper(size);
        Result result =  CipherGenerator.countDistinct(wrapper.makeFixedSelection(), seed);
        messageBox("Generate random subset A - Z", "Count distinct characters out of " + size, result.toString());
    }

    private void messageBox(String title, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private boolean checkEmptyFields(String field1, String field2){
        if(field1.equals("") || field2.equals("")){
            messageBox("User info", "Invalid input!", "Fields cannot be empty");
            return false;
        }
        return true;
    }

    @FXML
    void initialize() {
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'Generator.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'Generator.fxml'.";
        assert btnRandomLetters != null : "fx:id=\"btnRandomLetters\" was not injected: check your FXML file 'Generator.fxml'.";
        assert btnRandomSubset != null : "fx:id=\"btnRandomSubset\" was not injected: check your FXML file 'Generator.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'Generator.fxml'.";

    }
}
