package lk.ijse.hibernate.view.tm;

import java.awt.*;

public class ItemTM {
    private String code;
    private String description;
    private String qty;
    private double price;
    private Button btn;

    public ItemTM(String code, String description, String qty, double price, javafx.scene.control.Button btn) {
    }

    public ItemTM(String code, String description, String qty, double price, Button btn) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.price = price;
        this.btn = btn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "ItemTM{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qty='" + qty + '\'' +
                ", price=" + price +
                ", btn=" + btn +
                '}';
    }
}
