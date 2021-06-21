package gui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import model.Department;
import model.Manager;
import model.Staff;

import static javafx.collections.FXCollections.observableArrayList;

public class GUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Staff> cboSelectStaff;

    @FXML
    private Label lblWorksAt;

    @FXML
    private Label lblIncrease;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblSalary;

    @FXML
    private Slider sliderIncreasePercent;

    @FXML
    private Label lblName;

    @FXML
    void cboSelectStaffAction(ActionEvent event) {

    }

    @FXML
    void sliderIncreasePercentOnDragDone(DragEvent event) {

    }

    @FXML
    void initialize() {
        assert cboSelectStaff != null : "fx:id=\"cboSelectStaff\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lblWorksAt != null : "fx:id=\"lblWorksAt\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lblIncrease != null : "fx:id=\"lblIncrease\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lblHiredAt != null : "fx:id=\"lblHiredAt\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lblSalary != null : "fx:id=\"lblSalary\" was not injected: check your FXML file 'GUI.fxml'.";
        assert sliderIncreasePercent != null : "fx:id=\"sliderIncreasePercent\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lblName != null : "fx:id=\"lblName\" was not injected: check your FXML file 'GUI.fxml'.";

        //create staff, manager and department
        Staff[] staff = new Staff[6];
        staff[0] = new Staff("Ivan Petrov", 0, null, null);
        staff[1] = new Staff("Marin Ivanov", 0, null, null);
        staff[2] = new Staff("Petar Nikolov", 0, null, null);
        staff[3] = new Staff("Stanislav Todorov", 0, null, null);
        staff[4] = new Staff("Milen Marinov", 0, null, null);
        staff[5] = new Staff("Ivailo Dachev", 0, null, null);

        Manager manager = new Manager("Stoyan Stefanov", 0, null);
        Department dept = new Department(manager, "Dept");
        manager.setAppointRule(dept.appointmentHandler);

        Random rand = new Random();
        for(int i = 0; i < staff.length; i++)
        {
            dept.appointmentHandler.accept(staff[i], Math.abs(rand.nextDouble() % 1000) + 1000);
        }
    }
}
