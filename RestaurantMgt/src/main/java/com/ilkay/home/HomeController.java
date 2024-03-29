package com.ilkay.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    @FXML
    private VBox pnlItems;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node[] nodes = new Node[10];

        for (int i = 0;i< nodes.length;i++){
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnlItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
