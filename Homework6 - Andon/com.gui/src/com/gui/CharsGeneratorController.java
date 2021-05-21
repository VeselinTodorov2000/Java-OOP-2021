package com.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.providers.CipherGenerator;
import com.providers.Result;
import com.providers.Wrapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CharsGeneratorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnGenerateRandom;

    @FXML
    private Button btnRandomSubset;

    @FXML
    void btnGenerateRandomOnAction(ActionEvent event) {
        int seed = Integer.parseInt(txtSeed.getText());
        int size = Integer.parseInt(txtSize.getText());
        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedRandom(), seed);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Generate random subset A-Z");
        alert.setHeaderText("Count distinct characters out of " + Integer.toString(size));
        alert.setContentText(result.toString());
        alert.showAndWait();
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnRandomSubsetOnAction(ActionEvent event) {
        int seed = Integer.parseInt(txtSeed.getText());
        int size = Integer.parseInt(txtSize.getText());
        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedSelection(), seed);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Random subsequence of letters A-Z");
        alert.setHeaderText("Count distinct characters out of " + Integer.toString(size));
        alert.setContentText(result.toString());
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'CharsGenerator.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'CharsGenerator.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'CharsGenerator.fxml'.";
        assert btnGenerateRandom != null : "fx:id=\"btnGenerateRandom\" was not injected: check your FXML file 'CharsGenerator.fxml'.";
        assert btnRandomSubset != null : "fx:id=\"btnRandomSubset\" was not injected: check your FXML file 'CharsGenerator.fxml'.";

    }
}
