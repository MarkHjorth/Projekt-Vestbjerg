package ModelLayer;

public class Product
{
    private int number;
    private String name;
    private double price;
    
    /**
     * Constructor for Product.
     */
    public Product(int number, String name, double price)
    {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the number of the order.
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * Returns the name of the order.
     */
    public String getName()
    {
        return name;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        if (price >= 0)
        {
            this.price = price;
        }
    }
}
