package CtrlLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestCustomer.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestCustomer
{
    /**
     * Default constructor for test class TestCustomer
     */
    public TestCustomer()
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
    public void testCustomer()
    {
        CtrlLayer.CustomerCTRL customer1 = new CtrlLayer.CustomerCTRL();
        assertNull(customer1.findCustomer("customer1"));
        customer1.createCustomer("customer1");
        assertEquals(customer1.getCustomerContainer().getCustomer(0), customer1.findCustomer("customer1"));
        customer1.createCustomer("customer2");
        assertEquals(customer1.getCustomerContainer().getCustomer(1), customer1.findCustomer("customer2"));
    }
}

