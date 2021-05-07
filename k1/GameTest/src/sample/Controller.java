package sample;

import java.net.URL;
import java.util.ResourceBundle;

import cards.BeziqueCards;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    private BeziqueCards deck;

    public Controller() {
        deck = new BeziqueCards();
        deck.shuffleCards();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDrawHand;

    @FXML
    private Button btnHasFives;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnPairKingQueen;

    @FXML
    private TextArea txtCards;

    @FXML
    private TextArea txtDoubleOrAce;

    @FXML
    void btnDrawHandOnAction(ActionEvent event) {
        if(deck.dealHand() == false)
        {
            btnDrawHand.disabledProperty();
        }
        else
        {
            txtCards.setText(deck.printCards());
        }
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnHasFivesOnAction(ActionEvent event) {
        if(deck.hasAKQJ10())
        {
            String old = txtDoubleOrAce.getText();
            txtDoubleOrAce.setText(String.format("%s\nВ изтеглената ръка има Ace-King-Queen-Jack-Ten от цвят Коз: %s", old, deck.getTrump().toString()));
        }
        else
        {
            String old = txtDoubleOrAce.getText();
            txtDoubleOrAce.setText(String.format("%s\nВ изтеглената ръка няма Ace-King-Queen-Jack-Ten от цвят Коз: %s", old, deck.getTrump().toString()));
        }

    }

    @FXML
    void btnPairKingQueenOnAction(ActionEvent event) {
        if(deck.hasMarriage())
        {
            String old = txtDoubleOrAce.getText();
            txtDoubleOrAce.setText(String.format("%s\nВ изтеглената ръка има двойка King-Queen от цвят Коз: %s", old, deck.getTrump().toString()));
        }
        else
        {
            String old = txtDoubleOrAce.getText();
            txtDoubleOrAce.setText(String.format("%s\nВ изтеглената ръка няма двойка King-Queen от цвят Коз: %s", old, deck.getTrump().toString()));
        }
    }

    @FXML
    void initialize() {
        assert btnDrawHand != null : "fx:id=\"btnDrawHand\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnHasFives != null : "fx:id=\"btnHasFives\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPairKingQueen != null : "fx:id=\"btnPairKingQueen\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtCards != null : "fx:id=\"txtCards\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtDoubleOrAce != null : "fx:id=\"txtDoubleOrAce\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
