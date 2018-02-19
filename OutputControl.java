/**********************************************************
 * Class Name     : OutputControl
 * Author         : William Golembieski
 * Date           : February 18, 2018
 * Course/Section :
 *
 * Method Description: This class will allow you to clear the screen and move the cursor
 *    to the top left of the screen if supported. If it isn't supported it will a set amount
 *    of lines to get the last output off the screen. You will also be able to choose to pause
 *    your program and wait for a user to press enter to continue.
 *
 *
 * Tested on platforms: Linux, Mac OS X, Windows
 *
 * -- METHODS --
 * clearScreen()   - This will clear the screen based on your OS name value
 * pause()         - This will pause the program until the user hits enter
 *
 * -- REFERENCE --
 * System.getProperty("os.name") possible values:
 * - Windows NT
 * - Windows Me
 * - Windows XP
 * - Windows 98
 * - Windows 2000
 * - Windows 2003
 * - Mac OS X
 * - Linux
 * - SunOS
 * - FreeBSD
 *
 * ANSI Escape codes-
 * https://en.wikipedia.org/wiki/ANSI_escape_code
 *
 *********************************/

import java.io.IOException;
import java.util.Scanner;

public class OutputControl {
    
    // Local variables
    
    // Local constants
    public int screenWidth = 80;   // Users screen width (DEFAULT: 80). Public for easy manipulation
    
    /******************************************************
     * Method Name    : clearScreen
     * Author         : William Golembieski
     * Date           : February 18, 2018
     * Course/Section :
     * Program Description: This method will find your OS and perform a clear screen based on
     *    your platform's specific clear screen command. If it's not supported, it will print a
     *    bunch of new lines to get the output off your screen.
     *
     * BEGIN clearScreen
     *    TRY
     *       IF ( os == Windows )
     *          Build process and pipe command "cls" to current cmd window
     *       ELSE IF ( os == Mac || os == Linux )
     *          Print ANSI escape character sequence to clear screen
     *       ELSE
     *          Print a bunch of new lines
     *       END IF
     *    CATCH
     *       Print a bunch of new lines
     *    END TRY
     * END clearScreen
     *
     ******************************************************/
    
    public void clearScreen()
    {
        // Local constants
        final int EMPTY_LINES_TO_PRINT = 50;
        
        // Local variables
        String notSupportedString = "";   // Output string for OS not supported
        
        /************ Start clearScreen method **************/
        
        try
        {
            // If OS is Windows (cmd)
            if (System.getProperty("os.name").contains("Windows"))
            {
                // Build process and pipe command "cls" to current cmd window
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            
            // If Linux based (terminal with ANSI support)
            else if (System.getProperty("os.name").contains("Mac") ||
                     System.getProperty("os.name").contains("Linux"))
            {
                // Print ANSI escape sequence to clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            
            // If not windows, mac, or linux... *facepalm*
            else
            {
                // create a string with a bunch of newlines
                for(int i = 0; i < EMPTY_LINES_TO_PRINT; i++)
                {
                    notSupportedString += "\n";
                    
                }// END FOR
                
                // Print a bunch of new lines to get output off the screen
                System.out.print(notSupportedString);
                
            }// END IF
            
            // Print a bunch of new lines to get output off the screen
            System.out.print(notSupportedString);
        }
        
        catch (IOException | InterruptedException ex)
        {
            // If all else fails, create a string with a bunch of newlines
            for(int i = 0; i < EMPTY_LINES_TO_PRINT; i++)
            {
                notSupportedString += "\n";
                
            }// END FOR
            
            // Print a bunch of new lines to get output off the screen
            System.out.print(notSupportedString);
        
        }// END TRY
        
    }// END clearScreen()

    /******************************************************
     * Method Name    : pause
     * Author         : William Golembieski
     * Date           : February 18, 2018
     * Course/Section :
     * Program Description: This method will print "Press enter to continue" centered in
     *    the middle of the screen based on public class variable "screenWidth". It
     *    will then wait for user input by using the Scanner object created to wait for a string
     *    input.
     *
     * BEGIN pause
     *    Add spaces to output string to center it
     *    Add message to end of spaces
     *    Display message and wait for user input
     * END pause
     *
     ******************************************************/

    public void pause()
    {
        // Local constants
        final String PRESS_ENTER = "Press enter to continue... ";
        
        // Local variables
        Scanner reader = new Scanner(System.in);  // New reader object to wait for user input
        String fmtPressEnter = "";                // Formatted string to prompt for pressing enter
        
        /************ Start pause method **************/
        
        // Add spaces to center message on the screen
        for(int i = 0; i < ((screenWidth - PRESS_ENTER.length())/ 2); i++)
        {
            fmtPressEnter += " ";
            
        }// END FOR
        
        // Add message to the end of pre-padding
        fmtPressEnter = fmtPressEnter + PRESS_ENTER;
        
        // Display message and wait for user input
        System.out.print(fmtPressEnter);
        reader.nextLine();
        
    }// END pause()
    
}// END OutputControl

