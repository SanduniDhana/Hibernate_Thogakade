package lk.ijse.hibernate.business;

import lk.ijse.hibernate.business.custom.CustomerBO;
import lk.ijse.hibernate.business.custom.impl.CustomerBOImpl;
import lk.ijse.hibernate.business.custom.impl.ItemBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            default:
                return null;
        }
    }
}
