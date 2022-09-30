module com.example.adobe1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ilkayseferli.adobe1 to javafx.fxml;
    exports com.ilkayseferli.adobe1;
}