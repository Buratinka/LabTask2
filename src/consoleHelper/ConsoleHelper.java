package consoleHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static void writeErrorMessage(String errorMessage){System.err.println(errorMessage);}

    public static String readString()
    {

        while (true)
        {
            try
            {
                return reader.readLine();
            }
            catch (IOException e) {
                System.out.println("An error occurred while trying to enter text. Try again.");}
        }
    }

    public static int readInt()
    {

        while (true)
        {
            try
            {
                return Integer.parseInt(readString());

            }
            catch (NumberFormatException e) {
                System.out.println("An error occurred while trying to enter number. Try again.");}
        }
    }



}
