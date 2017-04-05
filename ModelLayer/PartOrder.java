package ModelLayer;

public class PartOrder
{
    private int amount;
    private Product product;
    private double price;
    
    /**
     * Constructor for PartOrder.
     */
    public PartOrder(int amount, Product product)
    {
        this.amount = amount;
        this.product = product;
    }
    
    public Product getProduct()
    {
        return product;
    }
    
    /**
     * Sets the amount to the specified number.
     */
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public double getPrice()
    {
        price = product.getPrice() * amount;
        return price;
    }
}
