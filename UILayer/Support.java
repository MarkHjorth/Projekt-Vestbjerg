package UILayer;


/**
 * Write a description of class SupportFunctions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Support
{
    private String input;
    private InputHolder command;
    private boolean exit;
    private boolean quit;

    /**
     * Constructor for objects of class SupportFunctions
     */
    public Support()
    {
        command = new InputHolder();
    }

    public void goodBye()
    {
        System.out.println("Thank you for your visit");
        System.out.println("Hope to see you soon");
        System.out.println("//Terminate program");
    }

    public String getInput()
    {
        input = command.getInput();
        checkIfExit();
        checkIfQuit();
        return input;
    }

    public void clearWindow()
    {
        System.out.print("\f");
    }

    public boolean checkIfExit()
    {
        if(input.equals("exit"))
        {
            exit = true;
        }
        return exit;
    }

    public void checkIfQuit()
    {
        if(input.equals("quit"))
        {
            exit = true;
            quit = true;
        }
    }
}
