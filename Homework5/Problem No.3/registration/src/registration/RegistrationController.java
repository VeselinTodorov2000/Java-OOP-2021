package registration;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import validation.Validator;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSignup;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtConfirm;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnSignupOnAction(ActionEvent event) {
        if(validateInput()){
            messageBox("Success", "Successful registration!"); // показване на Alert message box при успешна регистрация
        }
    }

    private boolean validateInput(){ // проверка на въведените данни чрез методите на класа Validator в модула validation

        if(Validator.validateEmpty(txtName.getText(), txtPhone.getText(), txtEmail.getText(), txtPassword.getText(), txtConfirm.getText())){
            messageBox("Invalid","Fields cannot be empty!");
            return false;
        }

        boolean isValidUsername = Validator.validateUsername(txtName.getText());
        boolean isValidPhone = Validator.validatePhone(txtPhone.getText());
        boolean isValidEmail = Validator.validateEmail(txtEmail.getText());
        boolean isValidPassword = Validator.validatePassword(txtPassword.getText());
        boolean isValidConfirmPassword = Validator.validateConfirmPassword(txtPassword.getText(), txtConfirm.getText());

        // извеждане на съответните съобщения за грешка
        if(!isValidUsername){
            messageBox("Wrong username","Username should contains at least 2 letters - upper or lower case.");
        }
        if(!isValidPhone){
            messageBox("Wrong phone","Phone should contains two groups of digits surrounded by parenthesis.");
        }
        if(!isValidEmail){
            messageBox("Wrong email","Email should contains only lowercase letters, no duplicate @, dots and spaces inside.");
        }
        if(!isValidPassword){
            messageBox("Wrong password","Password should be at least 5 symbols, one lower and upper case, digit and symbol.");
        }
        if(!isValidConfirmPassword){
            messageBox("Confirm password","Confirm password should be identical to password.");
        }

        return isValidUsername && isValidPhone && isValidEmail && isValidPassword && isValidConfirmPassword;
    }

    private void messageBox(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    @FXML
    void initialize() {
        assert btnSignup != null : "fx:id=\"btnSignup\" was not injected: check your FXML file 'Registration.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'Registration.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Registration.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'Registration.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Registration.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Registration.fxml'.";
        assert txtConfirm != null : "fx:id=\"txtConfirm\" was not injected: check your FXML file 'Registration.fxml'.";

    }
}
