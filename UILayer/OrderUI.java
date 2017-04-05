package UILayer;
import CtrlLayer.*;
import ModelLayer.*;
import java.util.ArrayList;

/**
 * Write a description of class OrderUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrderUI
{
    private OrderCTRL oCtrl;
    private Support support;
    private String oInput;
    private InputHolder command;
    private boolean exit;
    private Order o;
    private String fcName;
    private ArrayList<Order> tempOrders;

    /**
     * Constructor for objects of class OrderUI
     */
    public OrderUI()
    {
        oCtrl = new OrderCTRL();
        support = new Support();
        command = new InputHolder();
        ArrayList tempOrders = new ArrayList<Order>();
    }

    public void orderInterface()
    {
        System.out.println("What do you want to do?");
        System.out.println("CREATE order");
        System.out.println("FIND order");
        System.out.println("DELETE order");
        System.out.println("EXIT the order menu");
    }

    public boolean orderMenu()
    {
        exit = false;
        while(!exit)
        {
            orderInterface();
            oInput = support.getInput();

            switch(oInput)
            {
                case "create":
                {
                    System.out.println("Input the order date:");
                    System.out.print(">");
                    String orderDate = support.getInput();
                    System.out.println("Input the name of the Shop Assistant:");
                    System.out.print(">");
                    String shopAssName = support.getInput();
                    System.out.println("Input the name of the customer:");
                    System.out.print(">");
                    String cName = support.getInput();
                    o = (createOrder(orderDate, shopAssName, cName));
                    String fcName = null;

                    boolean done = false;
                    while(!done)
                    {
                        System.out.println("Input the name of the product (Or done for no more products):");
                        System.out.print(">");
                        String pName = support.getInput();
                        if(pName.equals("done"))
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.println("Input the amount of the product:");
                            System.out.print(">");
                            int amount = numberInput();
                            addProduct(pName, amount, o);
                        }
                    }
                    
                    System.out.println("Print order? (Y/N)");
                    System.out.print(">");
                    String printThis = support.getInput();
                    if(printThis.toLowerCase().equals("y") || printThis.toLowerCase().equals("yes"))
                    {
                        printOrder(o);
                    }
                    
                    break;
                }
                case "find":
                {
                    System.out.println("Select how to find your order: ");
                    System.out.println("NUMBER"); 
                    System.out.println("NAME");
                    System.out.print(">");
                    String input = support.getInput();
                    
                        if(input.toLowerCase().equals("number"))
                        {
                          System.out.println("Input number for order:");
                          System.out.print(">");
                          int number = numberInput();
                          printOrderByNumber(number);
                        }  
                        
                        else if(input.toLowerCase().equals("name"))
                        {
                            System.out.println("Please input Customer name:"); 
                            System.out.print(">");
                            fcName = support.getInput();
                            printOrderByName(fcName);/*
                            int number = numberInput();
                            printOrderFromTempOrders(number, tempOrders);*/
                        }
                    break;
                }
                case "delete":
                {
                    System.out.println("Please input the number of the order you wish to delete");
                    int number = numberInput();
                    oCtrl.deleteOrder(number);
                    break;
                }
                case "exit":
                {
                    exit = true;
                    support.clearWindow();
                    break;
                }
                default:
                {
                    System.out.println("This application does not support that input");
                    System.out.println("Try again");
                    break;
                }
            }
        }
        return exit;
    }

    /**
     * Gets a number input, without exception 
     */
    private int numberInput()
    {
        int number;
        System.out.print(">");
        try
        {
            number = Integer.parseInt(support.getInput());;
        }
        catch (NumberFormatException e)
        {
            System.err.println("NumberFormatException: " + e.getMessage());
            number = -1;
            numberInput();
        }
        return number;
    }

    public Order createOrder(String orderDate, String shopAssName, String cName)
    {
        boolean done = false;
        if(oCtrl.findCustomer(cName) != null)
        {
            try
            {
                o = oCtrl.createOrder(oCtrl.findCustomer(cName), orderDate, shopAssName);
            }
            catch (NullPointerException e)
            {
                System.err.println("NullPointerException: " + e.getMessage());
            }
        }
        else
        {
            o = oCtrl.createOrder(orderDate, shopAssName);
        }
        return o;
    }

    public void addProduct(String name, int amount, Order o)
    {
        Product p = oCtrl.findProduct(name);
        if(p != null)
        {
            try
            {
                oCtrl.addProduct(p, amount, o);
            }
            catch (NullPointerException e)
            {
                System.err.println("NullPointerException: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
    

    public Order printOrderFromTempArray(int number)
    {
        
        return null;
    }
    
    public Order printOrderByNumber(int number)
    {
        System.out.println("Order #" + number+1);
        Order temp = oCtrl.findOrderByNumber(number);
        printOrder(temp);
        return temp;
    }
    
    public ArrayList<Order> printOrderByName(String name)
    {
        Customer tempCustomer = oCtrl.findOrderByName(name);
        try
        {
            System.out.println("Orders from " + tempCustomer.getName());
        }
        catch(NullPointerException e)
        {
            System.err.println("NullPointerException: " + e.getMessage());
        }

        try
        {
            for(int i = 0; i < tempCustomer.getOrders().size(); i++)
            {
                tempOrders = oCtrl.findOrderByName(name).getOrders();
            }  
        }       
        catch (NullPointerException e)
        {
            System.err.println("NullPointerException: " + e.getMessage());
        }    
        return tempOrders;
    }
    
    public Order printOrder(Order temp)
    {
        if (temp != null)
        {
            System.out.println(temp.getInfo());            
           
            if (temp.getSize() > 0)
            {
                System.out.println("Barcode:\tAmount:\tProduct:\tPrice:\tSub total:\n");
                for(int i = 0; temp.getSize() > i; i++)
                {
                    System.out.println(temp.getProduct(i).getNumber() + "\t\t" + temp.getPartOrder(i).getAmount() + "\t" + temp.getProduct(i).getName() + "\t" + temp.getProductPrice(i) + "\t" + temp.getSubTotalPrice(i));
                }
                System.out.println("\n  Total: Kr. " + temp.getTotalPrice());
            }
        }
        return temp;
    }

    public void deleteOrder(int number)
    {
        oCtrl.deleteOrder(number);
    }
}
