package CtrlLayer;
import ModelLayer.*;
import java.util.ArrayList;

public class OrderCTRL
{
    private CustomerCTRL cCTRL;
    private ProductCTRL pCTRL;
    private OrderContainer oCont;
    private Order temp;
    private ArrayList<Order> tempArray;
    private Customer tempCustomer;
    
    public OrderCTRL()
    {
        oCont = OrderContainer.getInstance();
        pCTRL = new ProductCTRL();
        cCTRL = new CustomerCTRL();
    }
    
    public Order findOrderByNumber(int number)
    {
        try
        {
            temp = oCont.findOrder(number);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
            temp = null;
        }
        return temp;
    }
    
    public Customer findOrderByName(String name)
    {
        Customer tempCustomer = null;
        try
        {
            tempCustomer = cCTRL.findCustomer(name);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        return tempCustomer;
    }
    
    public Customer findCustomer(String name)
    {
        return cCTRL.findCustomer(name);
    }
    
    /**
     * Creates an order by input: customer, orderDate and shopAssName and,
     * then adds the order to the orderContainer and adds it to the specific customers Orders
     */
    public Order createOrder(Customer c, String orderDate, String shopAssName)
    {
        Order o = oCont.createOrder(c, orderDate, shopAssName);
        c.addOrder(o);
        return o;
    }
    
    public Order createOrder(String orderDate, String shopAssName)
    {
        Order o = oCont.createOrder(orderDate, shopAssName);
        return o;
    }
    
    public Product findProduct(String name)
    {
        return pCTRL.findProduct(name);
    }
    
    public void addProduct(Product p, int amount, Order o)
    {
        o.createPartOrder(p, amount);
    }
    
    public int getID(int number)
    {
        return oCont.getID(number);
    }
    
    /**
     * This method adds a part order with a given product by a given amount.
     */
    public void addProductByNumber(int productNumber, int amount, int number)
    {
        if(amount > 1)
        {
            //The function goes into to container and finds the order by the variable number
            //It then creates a partOrder with the product that it looks up by findProduct(productNumber)
            //oCont.findOrder(number).createPartOrder(pCTRL.findProduct(addProductByNumber()), amount);
        }
        else System.out.println("Product amount must be above 0!");
    }
    
    public void deleteOrder(int number)
    {
        oCont.deleteOrder(number);
    }
    
    public int getOrderPartOrderSize(int orderNumber)
    {
        return oCont.getOrderPartOrderSize(orderNumber);
    }
    
    public double getProductPrice(int orderNumber, int partOrderNumber)
    {
        return oCont.getProductPrice(orderNumber, partOrderNumber);
    }
    
    public double getSubTotalPrice(int orderNumber, int partOrderNumber)
    {
        return oCont.getSubTotalPrice(orderNumber, partOrderNumber);
    }
    
    public double getTotalPrice(int orderNumber)
    {
        return oCont.getTotalPrice(orderNumber);
    }
}

