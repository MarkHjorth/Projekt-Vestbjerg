package CtrlLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Tester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    private CtrlLayer.ProductCTRL productC1;
    private CtrlLayer.CustomerCTRL customer1;

    /**
     * Default constructor for test class Tester
     */
    public Tester()
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
        productC1 = new CtrlLayer.ProductCTRL();
        productC1.createProduct(1, "product1", 123);
        customer1 = new CtrlLayer.CustomerCTRL();
        customer1.createCustomer("mark");
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
}
