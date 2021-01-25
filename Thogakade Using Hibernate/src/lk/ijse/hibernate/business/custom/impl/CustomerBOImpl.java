package lk.ijse.hibernate.business.custom.impl;

import lk.ijse.hibernate.business.custom.CustomerBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.dao.custom.CustomerDAO;
import lk.ijse.hibernate.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;
import lk.ijse.hibernate.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl  implements CustomerBO {

    CustomerDAOImpl customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {

        return customerDAO.add(new Customer(customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(new Customer(customerDTO.getId(),
                customerDTO.getName(),customerDTO.getAddress()));
    }

    @Override
    public CustomerDTO findCustomer(String id) throws Exception {
        Customer customer= customerDAO.find(id);
        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public ArrayList<CustomerDTO> findAllCustomers() throws Exception {
        List<Customer> cList=customerDAO.findAll();
        ArrayList<CustomerDTO> dtoList=new ArrayList();
        for (Customer customer: cList){
            dtoList.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress()
            ));
        }

        return dtoList;
    }

}