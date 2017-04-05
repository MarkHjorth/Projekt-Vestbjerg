package ModelLayer;
import java.util.ArrayList;

public class Order
{
    private int id;
    private ArrayList<PartOrder> partOrderList;
    private Customer customer;
    private String orderDate;
    private String shopAssName;
    private PartOrder partOrder;
    private double price;
    private int discount;
    private String status;
    
    public Order(Customer customer, String orderDate, String shopAssName)
    {
        this.customer = customer;
        this.orderDate = orderDate;
        this.shopAssName = shopAssName;
        this.partOrderList = new ArrayList<PartOrder>();
        status = "active";
    }
    
    public Order(String orderDate, String shopAssName)
    {
        this.customer = null;
        this.orderDate = orderDate;
        this.shopAssName = shopAssName;
        this.partOrderList = new ArrayList<PartOrder>();
        status = "active";
    }
    
    public void addPartOrder(PartOrder po)
    {
        partOrderList.add(po);
    }
    
    public ArrayList<PartOrder> getPartOrder()
    {
        return partOrderList;
    }
    
    public void createPartOrder(Product product, int amount)
    {
        addPartOrder(partOrder = new PartOrder(amount, product));
    }
    
    public void cancleOrder()
    {
        status = "canceled";
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public String getInfo()
    {
        String info = "No info about this order";
        
        info = 
                (
                "Order date: " + orderDate + "\n" + 
                "Salesman: " + shopAssName + "\n"
                );
        
        try
        {
            info = info +("Ordered by: " + customer.getName() + "\n"    );
        }
        catch (NullPointerException e)
        {
            System.err.println("NullPointerException: " + e.getMessage());
        }
        
        info = info + "Order status: " + getStatus();
        return info;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getCustomerName()
    {
        return customer.getName();
    }
    
    public void deletePartOrder(PartOrder po)
    {
        partOrderList.remove(po);
    }
    
    public int getSize()
    {
        return partOrderList.size();
    }
    
    public double getProductPrice(int partOrderNumber)
    {
        return partOrderList.get(partOrderNumber).getProduct().getPrice();
    }
    
    public double getSubTotalPrice(int partOrderNumber)
    {
        return partOrderList.get(partOrderNumber).getPrice();
    }
    
    public double getTotalPrice()
    {
        price = 0;
        for (PartOrder po : partOrderList)
        {
            price = price + po.getPrice();
        }
        return price;
    }
    
    public Product getProduct(int partOrderNumber)
    {
        return partOrderList.get(partOrderNumber).getProduct();
    }
    
    public PartOrder getPartOrder(int partOrderNumber)
    {
        return partOrderList.get(partOrderNumber);
    }
}
