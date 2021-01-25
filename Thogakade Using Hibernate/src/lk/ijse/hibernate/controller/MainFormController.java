package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MainFormController {
    public AnchorPane MainAnch;


    public void ItemFormLogin(MouseEvent mouseEvent)  {
        this.MainAnch.getChildren().clear();
        try {
            this.MainAnch.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ItemFrom.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CustomerFormLogin(MouseEvent mouseEvent) {
        this.MainAnch.getChildren().clear();
        try {
            this.MainAnch.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/CustomerForm.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Back(ActionEvent actionEvent)  {
        System.exit(0);
    }

}
