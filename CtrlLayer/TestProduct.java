package CtrlLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestProduct.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestProduct
{
    /**
     * Default constructor for test class TestProduct
     */
    public TestProduct()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    /**
     * test method for the ProductCtrl and the whole product part.
     */
    public void testProduct()
    {
        CtrlLayer.ProductCTRL productC2 = new CtrlLayer.ProductCTRL(); //Creates instance of the ProductCTRL class
        assertNull(productC2.findProduct("testname")); //looks for a product with the name "testname" which it shouldnt find
        productC2.createProduct(1, "product1", 12); //creates a product with the name "product1"
        assertEquals(productC2.getProductContainer().getProduct(0), productC2.findProduct("product1")); //searches for product1 and finds it
        productC2.createProduct(2, "product2", 12.5); //creates a product with the name "product2"
        assertEquals(productC2.getProductContainer().getProduct(1), productC2.findProduct("product2")); //looks for product 2 and finds it.
    }
}

