package UILayer;
import java.util.Scanner;

/**
 * This class is a support class, which takes, and prepares the user input for the translator clases
 * 
 * @author (David M. Kolind) 
 * @version (v.1.0, 09-11-2014)
 * 
 */
public class InputHolder
{
    private Scanner scanner;
    private String input;

    /**
     * Constructor for objects of class InputHolder
     */
    public InputHolder()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Makes sure the input is fittet to the program standard, to minimize failure
     */
    public String getInput()
    {
        input = scanner.nextLine();
        input = input.toLowerCase();
        input = input.trim();
        return input;
    }
}
