package ModelLayer;
import java.util.ArrayList;

/**
 * Write a description of class CustomerContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomerContainer
{
    private static CustomerContainer cCont;
    private ArrayList<Customer> customers;
    private Customer c;

    /**
     * Singleton Constructor for objects of class CustomerContainer
     */
    private CustomerContainer()
    {
        customers = new ArrayList<Customer>();
    }
    
    public static CustomerContainer getInstance()
    {
        if(cCont == null)
        {
            cCont = new CustomerContainer();
        }
        return cCont;
    }
    
    /**
     * Find and return Customer by searchin through the arraylist of customers.
     * returns null if no one is found.
     */
    public Customer findCustomer(String name)
    {
        Customer temp = null;
        for(Customer cc : customers)
        {
            if(cc.getName().equals(name))
            {
                temp = cc;
            }
        }
        return temp;
    }
    
    public void createCustomer(String name)
    {
        addCustomer(c = new Customer(name));
    }
    
    public void addCustomer(Customer c)
    {
        customers.add(c);
    }
    
    public Customer getCustomer(int number)
    {
        return customers.get(number);
    }
}
