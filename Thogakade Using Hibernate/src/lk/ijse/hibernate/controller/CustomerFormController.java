package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import lk.ijse.hibernate.business.BOFactory;
import lk.ijse.hibernate.business.BOType;
import lk.ijse.hibernate.business.custom.impl.CustomerBOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;

import java.io.IOException;

public class CustomerFormController {
    public JFXTextField txtAddress;
    public JFXTextField txtName;
    public JFXTextField txtId;
    public JFXTextField txtSearch;

    CustomerBOImpl customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);


    public void SaveOnAction(ActionEvent actionEvent) throws Exception {
        boolean added = customerBO.addCustomer(new CustomerDTO(txtId.getText(),
                txtName.getText(), txtAddress.getText()));

        if (added) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText(" Added Success...");
            alert.showAndWait();

        }
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");


        txtId.clear();
        txtName.clear();

        txtAddress.clear();
//

    }
        public void DeleteOnAction (ActionEvent actionEvent){

        }

        public void UpdateOnAction (ActionEvent actionEvent) throws Exception {
            customerBO.updateCustomer(new CustomerDTO(
                    txtId.getText(),txtName.getText(),txtAddress.getText())
            );
        }

    public void SearchOnAction(ActionEvent actionEvent) throws Exception {
        CustomerDTO customer=customerBO.findCustomer(txtSearch.getText());
        if(customer != null){
            txtId.setText(customer.getId());
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
    }
}}