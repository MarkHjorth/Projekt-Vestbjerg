package ModelLayer;
import java.util.ArrayList;
import ModelLayer.*;

public class OrderContainer
{
    private static OrderContainer instance;
    private ArrayList<Order> orders;
    private Order o;
    /**
     * Constructor for OrderContainer.
     */
    private OrderContainer()
    {
        orders = new ArrayList<Order>();
    }
    
    public static OrderContainer getInstance() {
        if(instance == null) 
        {
            instance = new OrderContainer();
        }
        return instance;
    }
    
    /**
     * Find and returns Order
     */
    public Order findOrder(int number)
    {
        return orders.get(number);
    }
    
    public int getID(int number)
    {
        int ID = orders.indexOf(number);
        return ID; 
    }
    
    public ArrayList<Order> findOrderByName(String name)
    {
        ArrayList<Order> temp = new ArrayList<Order>();
        
            for (int i = 0; i < orders.size(); i++) 
            {
                    if(findOrder(i).getCustomerName() == name)
                    {
                        temp.add(orders.get(i));
                    }
                }
            return temp;
        }
    
    /**
     * Create Order with parameters: Customer, orderDate and salesMan
     */
    public Order createOrder(Customer c, String orderDate, String shopAssName)
    {
        addOrder(o = new Order(c, orderDate, shopAssName));
        return o;
    }
    
    public Order createOrder(String orderDate, String shopAssName)
    {
        addOrder(o = new Order(orderDate, shopAssName));
        return o;
    }
    
    /**
     * Add order to ArrayList
     */
    public void addOrder(Order o)
    {
        orders.add(o);
        o.setId(orders.indexOf(o));
    }
    
    public void deleteOrder(int number)
    {
        orders.get(number).cancleOrder();
    }
    
    public int getOrderPartOrderSize(int orderNumber)
    {
        return orders.get(orderNumber).getSize();
    }
    
    public double getProductPrice(int orderNumber, int partOrderNumber)
    {
        return orders.get(orderNumber).getProductPrice(partOrderNumber);
    }
    
    public double getSubTotalPrice(int orderNumber, int partOrderNumber)
    {
        return orders.get(orderNumber).getSubTotalPrice(partOrderNumber);
    }
    
    public double getTotalPrice(int orderNumber)
    {
        return orders.get(orderNumber).getTotalPrice();
    }
}
