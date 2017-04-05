package CtrlLayer;
import ModelLayer.*;

public class ProductCTRL
{
    
    ProductContainter pCont;
    
    public ProductCTRL()
    {
        pCont = ProductContainter.getInstance();
    }

    public Product findProduct(String name)
    {
        return pCont.findProduct(name);
    }
    
    public void createProduct(int number, String name, double price)
    {
        pCont.createProduct(number, name, price);
    }
    
    public ProductContainter getProductContainer()
    {
        return pCont;
    }
}
