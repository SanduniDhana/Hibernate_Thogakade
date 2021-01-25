package lk.ijse.hibernate.business.custom;

import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public boolean addItem(ItemDTO itemDTO) throws Exception;
    public ArrayList<ItemDTO>findAll()throws Exception;
    public boolean deleteItem(String id) throws Exception;
    public boolean updateItem(ItemDTO itemDTO)throws Exception;
    public ItemDTO findItem (String id) throws Exception;

}
