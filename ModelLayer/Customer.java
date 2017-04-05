package ModelLayer;
import java.util.ArrayList;

/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    private String name;
    private ArrayList<Order> orders;

    /**
     * Constructor for objects of class Customer.
     */
    public Customer(String name)
    {
        this.name = name;
        orders = new ArrayList<Order>();
    }
    
    /**
     * Sets the name of the customer to the specified text.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Returns the name of the customer.
     */
    public String getName()
    {
        return name;
    }
    
    public void addOrder(Order o)
    {
        orders.add(o);
    }
    
    public ArrayList getOrders()
    {
        return orders;
    }
}
