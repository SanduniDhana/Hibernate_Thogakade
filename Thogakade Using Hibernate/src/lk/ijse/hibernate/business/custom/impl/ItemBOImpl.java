package lk.ijse.hibernate.business.custom.impl;

import lk.ijse.hibernate.business.custom.ItemBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.custom.impl.ItemDAOImpl;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
  ItemDAOImpl itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);
    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.add(new Item(itemDTO.getCode(),
                itemDTO.getDescription(),itemDTO.getQty(),itemDTO.getPrice()));

    }

    @Override
    public ArrayList<ItemDTO> findAll() throws Exception {
//
        return null;
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return itemDAO.delete(id);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.update(new Item(itemDTO.getCode(),itemDTO.getDescription(),
                itemDTO.getQty(),itemDTO.getPrice()));
    }

    @Override
    public ItemDTO findItem(String id) throws Exception {
        Item item=itemDAO.find(id);
        return new ItemDTO(item.getCode(),item.getDescription(),item.getQty(),item.getPrice());

    }
}
