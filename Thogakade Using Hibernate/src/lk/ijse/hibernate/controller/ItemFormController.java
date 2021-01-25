package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.business.BOFactory;
import lk.ijse.hibernate.business.BOType;
import lk.ijse.hibernate.business.custom.ItemBO;
import lk.ijse.hibernate.business.custom.impl.ItemBOImpl;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.view.tm.ItemTM;

import java.util.List;
import java.util.Optional;

public class ItemFormController {
    public TextField txtItemCode;
    public TextField txtDescription;
    public TextField txtQty;
    public TextField txtPrice;
    public TableColumn colCode;
    public TableColumn colDes;
    public TableColumn colQTY;
    public TableColumn colPrice;
    public TableColumn colOperate;
    public TableView<ItemTM> tbItem;
    public JFXTextField txtSearch;


    ItemBOImpl itemBO = BOFactory.getInstance().getBO(BOType.ITEM);

    public void initialize() throws Exception {

    }

    private void setData(ItemTM tm) {
        txtItemCode.setText(tm.getCode());
        txtDescription.setText(tm.getDescription());
        txtQty.setText(tm.getQty());
        txtPrice.setText(String.valueOf(tm.getPrice()));
    }


    private void loadAllitems() throws Exception {
        ObservableList<ItemTM> tmList = FXCollections.observableArrayList();
        List<ItemDTO> allItems = itemBO.findAll();
        for (ItemDTO dto : allItems) {
            Button btn = new Button("Delete");
            ItemTM tm = new ItemTM(dto.getCode(), dto.getDescription(),
                    dto.getQty(), dto.getPrice(), btn);
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {
                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (itemBO.deleteItem(tm.getCode())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllitems();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tbItem.setItems(tmList);
    }


    public void SaveOnAction(ActionEvent actionEvent) throws Exception {

        boolean added = itemBO.addItem(new ItemDTO(txtItemCode.getText(),
                    txtDescription.getText(), txtQty.getText(),
                    Double.parseDouble(txtPrice.getText())));

        if(added){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Added Success...");
            alert.showAndWait();
        }
        txtItemCode.setText("");
        txtDescription.setText("");
        txtQty.setText("");
        txtPrice.setText("");

        txtItemCode.clear();
        txtDescription.clear();

        txtQty.clear();
        txtPrice.clear();

    }




    public void BackOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) throws Exception {
        itemBO.updateItem(new ItemDTO(txtItemCode.getText(), txtDescription.getText(), txtQty.getText(), Double.parseDouble(txtPrice.getText())));
    }

    public void SearchOnAction(ActionEvent actionEvent) throws Exception {
        ItemDTO item = itemBO.findItem(txtSearch.getText());
        if (item != null) {
            txtItemCode.setText(item.getCode());
            txtDescription.setText(item.getDescription());
            txtQty.setText(String.valueOf(item.getQty()));
            txtPrice.setText(String.valueOf(item.getPrice()));
        }
    }
}