package CtrlLayer;
import ModelLayer.*;
import java.util.ArrayList;

public class CustomerCTRL
{
    private CustomerContainer cCont;
    /*
     * Constuctor for CustomerCTRL.
     */
    public CustomerCTRL()
    {
        cCont = CustomerContainer.getInstance();
    }
    
    
    /*
     * Find and return Customer object by searching by name.
     */
    public Customer findCustomer(String name)
    {
        return cCont.findCustomer(name);
    }
    
   /* public ArrayList<Order> findCustomerByNumber(int number)
    {
        return cCont.findCustomerByNumber(number);
    }
    */
    public void createCustomer(String name)
    {
        cCont.createCustomer(name);
    }
    
    public CustomerContainer getCustomerContainer()
    {
        return cCont;
    }
}
