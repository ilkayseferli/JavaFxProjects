module com.example.birdeggsolution {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.birdeggsolution to javafx.fxml;
    exports com.example.birdeggsolution;
}