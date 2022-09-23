package com.example.birdeggsolution;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField enterPasswordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Label loginMessageLabel;

    public void loginButtonOnAction(ActionEvent event){
        if (userNameTextField.getText().isEmpty() == false && enterPasswordTextField.getText().isEmpty() == false){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Please username and password");
        }
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void validateLogin(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDb = connection.getConnection();
        String verifyLogin = "SELECT COUNT(1) FROM user_account WHERE username = '" + userNameTextField.getText() + "' AND password =  '" + enterPasswordTextField.getText()+"'";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Congratulations!");
                }else{
                    loginMessageLabel.setText("Invalid Login");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
