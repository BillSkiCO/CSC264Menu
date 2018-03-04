
/**********************************************************
 * Class Name     : MenuItem
 * Author         : William Golembieski
 * Date           : March 9, 2018
 * Course/Section : CSC264 - 803
 * Class Description: Store a single line item fo the menu. Will include name, discription, and
 *    price of the item. Formatting of strings will occur in driver.
 *
 * Methods:
 * -------
 * MenuItem - This will serve as a constructor for the MenuItem object
 * toString - Returns string representation of Menu Item. Output will be formatted here.
 **********************************************************/

public class MenuItem
{
    // Local constants
    private final int SCREEN_WIDTH = 80;

    // Local variables
    public double price;         // Price of the item
    public String name;          // Name of the item
    public String description;   // Detailed description of item


    /**********************************************************
     * Method Name    : MenuItem
     * Author         : William Golembieski, Nate Gillette
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: This will serve as the constructor for our menu item.
     *
     * BEGIN MenuItem
     *    Set name
     *    Set price
     *    Set description
     * END MenuItem
     **********************************************************/

    public MenuItem(String inName, double inPrice, String inDescription)
    {
        //local constants

        //local variables

        /********************   Start main method  *****************/

        // Set name
        name = inName;

        // Set price
        price = inPrice;

        // Set description
        description = inDescription;

    }// END MenuItem method

    /**********************************************************
     * Method Name    : toString
     * Author         : William Golembieski, Nate Gillette
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: This will format and print the menu item
     *
     * Format:            The York Burger / $15
     *              1/2 lb. Tri-Blend Beef, French Fried
     *              Onion Straws, White Cheddar, Slab Bacon,
     *              Iceberg Lettuce, Tomato, House Sauce,
     *              Toasted Brioche Roll, Fries
     *
     * BEGIN toString
     *    Print item name and price
     *    Print discription
     * END toString
     **********************************************************/

   public String toString()
   {
      // Local constants
      final int MAX_ITEM_NAME_SIZE = 41;
      final int MAX_LINE_SIZE      = 50;
      final String PRICE_SEPERATOR = "/";
      final String CURRENCY        = "$";
      final int PADDING            = 15;

      // Local variables
      String outputString = "";                    // Holds the output string
      int nameStepper     = 0;                     // Stepper for displaying the name
      String itemTitleWithPrice = "";              // Title of the menu item and it's price

      /*************   Start toString method  **************/

      // Build top line
      itemTitleWithPrice = name + " " + PRICE_SEPERATOR + " " + CURRENCY + " " + price;

      // Add spaces to the left of the string.
      outputString = Util.setLeft(PADDING + (MAX_LINE_SIZE -
                                  itemTitleWithPrice.length())/ 2, outputString);

	  // Add name to outputString
	  outputString += name;

	  // Name and seperator seperating spaces
	  outputString += " ";

	  // Price seperator
	  outputString += PRICE_SEPERATOR;

	  // Seperator and price seperating spaces
	  outputString += " ";

	  // CURRENCY
	  outputString += CURRENCY;

	  // CURRENCY and price seperating spaces
	  outputString += " ";

	  // Price
	  outputString += price + "\n";

      // Add wrapped description to the output string
      outputString += Util.wrap(description, 50);

      // Return the built and formatted string for display
      return outputString;

   }// END toString

} //End MenuItem class
