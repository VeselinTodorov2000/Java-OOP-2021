module registration {
    requires javafx.fxml;
    requires javafx.controls;
    requires validation;

    opens registration to javafx.fxml;
    exports registration to javafx.graphics;
}