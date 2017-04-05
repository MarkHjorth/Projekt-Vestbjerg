package UILayer;

/**
 * The MainUI vlass.
 * This class handles the user input, and sends the requests to the sub UI's where they will be handeled
 * 
 * @author David M. Kolind
 * @version 1.0 - 10-12-2014
 */
public class MainUI
{
    private String mInput;           //The input when saved as a string
    private boolean quit;           //True when user wants to quit the application
    private boolean exit;           //True when user wants to quit the current code type

    private InputHolder command;    //Handles the user input, and returns an all lowercase String value. The value is also trimmed
    private OrderUI orderUI;        //The UI for orders
    private Support support;        //Holds support methods, used in all UI classes

    /**
     * Constructor
     */
    public MainUI()
    {
        command = new InputHolder();
        orderUI = new OrderUI();
        support = new Support();
        quit = false;
        exit = false;
    }

    /**
     * Main menu
     * Is handeling the input and forwarding the requests
     */
    public void menu()
    {
        support.clearWindow();

        while(!quit)
        {
            exit = false;
            welcomeMenu();
            mInput = support.getInput();

            switch(mInput)
            {
                case "order":
                {
                    orderUI.orderMenu();
                    break;
                }
                case "quit":
                {
                    quit = true;
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
        support.goodBye();
    }

    private void welcomeMenu()
    {
        System.out.println("---------------------------");
        System.out.println("Welcome to the Vestbjerg Menu");
        System.out.println("What would you like to do?");
        System.out.println("To get to the Order interface type ORDER");
        System.out.println("At this time we have no other options ^_^");
        System.out.println("Type Exit, to exit the curent code type");
        System.out.println("Type Quit to exit the program");
        System.out.print(">");
    }
}
