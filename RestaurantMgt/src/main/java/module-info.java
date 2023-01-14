module com.ilkay.restaurantmgt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ilkay.home to javafx.fxml;
    exports com.ilkay.home;
}