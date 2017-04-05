package ModelLayer;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductContainter
{
    private static ProductContainter instance;
    private ArrayList<Product> products;
    private Product p;
    
    /**
     * Constructor for ProductContainer.
     */
    private ProductContainter()
    {
        products = new ArrayList<Product>();
    }
 
    public static ProductContainter getInstance()
    {
        if (instance == null)
        {
            instance = new ProductContainter();
        }
        return instance;
    }
    
    /**
     * 
     */
    public Product findProduct(String name)
    {
        for (Product p : products)
        {
            if(p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }
    
    public Product getProduct(int number)
    {
        return products.get(number);
    }
    
    public void createProduct(int number, String name, double price)
    {
        addProduct(p = new Product(number, name, price));
    }
    
    public void addProduct(Product p)
    {
        products.add(p);
    }
}