package gui;

import java.net.URL;
import java.util.*;

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

public class StaffSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Staff> cboSelector;

    @FXML
    private Label lblName;

    @FXML
    private Label lblWorksAt;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblIncrease;

    @FXML
    private Label lblSalary;

    @FXML
    private Slider sldPercent;

    @FXML
    void cboSelectorOnAction(ActionEvent event) {

    }

    @FXML
    void sldPercentOnDragDone(DragEvent event) {

    }

    @FXML
    void initialize() {
        assert cboSelector != null : "fx:id=\"cboSelector\" was not injected: check your FXML file 'StaffScene.fxml'.";
        assert lblName != null : "fx:id=\"lblName\" was not injected: check your FXML file 'StaffScene.fxml'.";
        assert lblWorksAt != null : "fx:id=\"lblWorksAt\" was not injected: check your FXML file 'StaffScene.fxml'.";
        assert lblHiredAt != null : "fx:id=\"lblHiredAt\" was not injected: check your FXML file 'StaffScene.fxml'.";
        assert lblIncrease != null : "fx:id=\"lblIncrease\" was not injected: check your FXML file 'StaffScene.fxml'.";
        assert lblSalary != null : "fx:id=\"lblSalary\" was not injected: check your FXML file 'StaffScene.fxml'.";
        assert sldPercent != null : "fx:id=\"sldPercent\" was not injected: check your FXML file 'StaffScene.fxml'.";

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

        ObservableList<Staff> appointed = observableArrayList();
        appointed.addAll(dept.getStaff());
        cboSelector = new ComboBox<Staff>(appointed);
    }
}
