module com.ilkay.googledriverfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ilkay.googledriverfx to javafx.fxml;
    exports com.ilkay.googledriverfx;
}