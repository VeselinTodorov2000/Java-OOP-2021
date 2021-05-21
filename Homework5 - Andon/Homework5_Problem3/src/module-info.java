module Registration {
    requires javafx.fxml;
    requires javafx.controls;
    opens registration to javafx.fxml;
    exports registration to javafx.graphics;
}