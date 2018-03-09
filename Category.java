
/**********************************************************
 * Class Name     : Category
 * Author         : William Golembieski
 * Date           : March 9, 2018
 * Course/Section : CSC264 - 803
 * Class Description: Store a menu name and a list of categories
 *
 * Methods:
 * -------
 * Menu               - Constructor for the Category object
 * editCategoryName   - Edits the Category name
 * getNumItems        - Returns the number of MenuItems
 * getMenuItem        - Returns the string representation of a MenuItem
 * addMenuItem        - Adds a MenuItem
 * delMenuItem        - Deleted a MenuItem
 * getIndexItemByName - Gets the index of a MenuItem by name
 * swapMenuItemSpots  - Swaps two MenuItem places
 * toString           - Returns string representation of Category. Output will be formatted here.
 **********************************************************/

public class Category
{
    // Local constants
    private final int SCREEN_WIDTH = 80;

    // Local variables
    private String categoryName;
    private MenuItem[] menuItemList;
    private int numMenuItems;

    /**********************************************************
     * Method Name    : Category
     * Author         : William Golembieski
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: This will serve as the constructor for our Category.
     *
     * BEGIN Category
     *    Set name
     *    Create new category list of set size
     *    Set number of Menu Items to 0
     * END Category
     **********************************************************/

    public Category(String name, int maxMenuItems)
    {
        // Local constants

        // Local variables

        /******************** Start Category method  *****************/

        // Set name
        categoryName = Util.toTitleCase(name);

        // Create new category list of set size
        menuItemList = new MenuItem[maxMenuItems];

        // Set number of Menu Items to 0
        numMenuItems = 0;

    }// END Category method

    /**********************************************************
     * Method Name    : editCategoryName
     * Author         : William Golembieski
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: Edits the name of the category.
     *
     * BEGIN editCategoryName
     *    Set name
     *    Return success
     * END editCategoryName
     **********************************************************/

    public boolean editCategoryName(String newName)
    {
        // Local constants

        // Local variables

        /******************** Start editCategoryName method  *****************/

        // Set name
        categoryName = newName;

        // Return success
        return true;

    }// END editCategoryName method

    /**********************************************************
     * Method Name    : getNumItems
     * Author         : William Golembieski
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: Returns the number of menu items in the category
     *
     * BEGIN getNumItems
     *    Return number of menu items
     * END getNumItems
     **********************************************************/

    public int getNumItems()
    {
        // Local constants

        // Local variables

        /******************** Start getNumItems method  *****************/

        // Return number of menu items
        return numMenuItems;

    }// END getNumItems method

    /**********************************************************
     * Method Name    : getMenuItem
     * Author         : William Golembieski
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: Returns the string value of an item. Search by name.
     *
     * BEGIN getMenuItem
     *    FOR(every item in MenuItem[])
     *       IF(menu item name is query)
     *          Call and return the toString method of the item
     *          Set loop control variable to quit
     *       END IF
     *    END FOR
     *    Return the string for the item
     * END getMenuItem
     **********************************************************/

    public String getMenuItem(String nameToSearch)
    {
        // Local constants
      final String ITEM_NOT_FOUND   = "MENU ITEM NOT FOUND\n";
      final String FMT_INF_ERR      = Util.setLeft((SCREEN_WIDTH - ITEM_NOT_FOUND.length())/ 2,
                                      ITEM_NOT_FOUND);

        // Local variables
        String returnString = FMT_INF_ERR;   // query result

        /******************** Start getMenuItem method  *****************/

        // FOR(every item in MenuItem[])
        for(int i = 0; i < numMenuItems; i++)
        {
			// IF(menu item name is query)
			if((menuItemList[i].name).equalsIgnoreCase(nameToSearch))
			{
				// Call and return the toString method of the item
				returnString = menuItemList[i].toString();

				// Set loop control variable to quit
				i = numMenuItems;

			}//END IF

		}//END FOR

	   // Return the string for the item
	   return returnString;

    }// END getMenuItem method

    /**********************************************************
     * Method Name    : addMenuItem
     * Author         : William Golembieski
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: This will serve as the constructor for our Category.
     *
     * BEGIN addMenuItem
     *   IF( there is room to add an item )
     *      Add menu item to array
     *      Increment number of items
     *      Return success
     *   ELSE
     *      Return false no more room
     *   ENDIF
     * END addMenuItem
     **********************************************************/

    public boolean addMenuItem(MenuItem menuItem)
    {
        // Local constants

        // Local variables

        /******************** Start addMenuItem method  *****************/

        // IF there is room to add an item
        if(numMenuItems != menuItemList.length)
        {
			// Add menu item to array
			menuItemList[numMenuItems] = menuItem;

			// Increment number of items
			numMenuItems++;

			// Return success
			return true;
	    }

	    // If there is no more room in the menu item list
	    else
	    {
		   // Return false no more room
		   return false;

		}//END IF

    }// END addMenuItem method

   /**********************************************************
    * Method Name    : delMenuItem
    * Author         : William Golembieski
	* Date           : March 9, 2018
	* Course/Section : CSC264 - 801
	* Method Description: This method will check to see if there are
	*    MenuItems to delete. If not, it will return an error. If there
	*    are MenuItems to delete, it will find that MenuItem, delete it
	*    then shift all other MenuItems down in the Category.
    *
	* Return values:  -2 : No more MenuItems to delete
	*                 -1 : MenuItem not found
	*                  1 : MenuItem successfully deleted
	*
	* BEGIN delMenuItem
	*    IF( there are MenuItems to delete )
	*       Get index of MenuItem to delete
	*       IF( MenuItem is found )
	*          FOR( every MenuItem after deleted MenuItem )
	*             Move the MenuItem down one index
	*          END FOR
	*       Set last MenuItem to null
	*       Decrement number of MenuItems on roster
    *       Set return value that a MenuItem was sucessfully deleted
    *       ELSE
    *          Set return to -1 MenuItem not found
    *       END IF
    *    ELSE
    *       Set return value ot -2. No more MenuItems to delete
    *    END IF
    *    Return if there are MenuItems to delete and if the MenuItem was deleted
	* END delMenuItem
	*
    **********************************************************/

    public int delMenuItem(String searchName)
    {
      // Local constants

      // Local variables
      int returnVal       = 0;     // Holds if the MenuItem was sucessfully deleted
      int indexOfMenuItem;         // Index of MenuItem to delete
      int indexStepper;            // Stepper to traverse through MenuItem list

      /*************   Start delPlayer method  **************/

      // IF( there are MenuItems to delete )
      if(numMenuItems != 0)
      {
		 // Get index of MenuItem to delete
		 indexOfMenuItem = getIndexItemByName(searchName);

		 // If( MenuItem is found )
		 if( indexOfMenuItem != -1 )
		 {
	        // For( every MenuItem after deleted MenuItem )
	        for(; indexOfMenuItem < (numMenuItems - 1); indexOfMenuItem++ )
	        {
			   // If there is more than 1 MenuItem in array
			   if( menuItemList.length > 1)
			   {
			      // Move the MenuItem one index
			      menuItemList[indexOfMenuItem] = menuItemList[indexOfMenuItem + 1];

		       }//END IF

		    }// END FOR

		    // Set last MenuItem to null
		    menuItemList[numMenuItems - 1] = null;

		    // Decrement number of MenuItem in category
		    numMenuItems--;

		    // Set return value that a MenuItem was sucessfully deleted
		    returnVal = 1;
	     }

	     // If MenuItem is not found
	     else
	     {
			// Set return to -1
	        returnVal = -1;

	     }// END IF
      }

      // If there are no more MenuItems to delete
      else
      {
		 // Set return value to -2
         returnVal = -2;

      }//END IF

      // Return if there are MenuItems to delete and if the MenuItem was deleted
	  return returnVal;

    }// END delMenuItem method

   /**********************************************************
    * Method Name    : getIndexItemByName
    * Author         : William Golembieski
	* Date           : February 11, 2018
	* Course/Section : CSC264 - 801
	* Method Description: This method will search through the player list given
	*    a specified player's number, find the index of that player, and return
	*    which index the player is at
	*
	* BEGIN getIndexItemByName
	*    Set return value to not found
	*    FOR( all MenuItems in menuItemList )
    *       IF( name equals menuItemList[i].name )
    *          Set menuItemIndex
    *          Set quit
    *       END IF
	*	 END FOR
	*    Return index MenuItem is at
	* END getIndexItemByName
	*
	**********************************************************/

    public int getIndexItemByName(String searchName)
    {
	  // Local constants
	  int MENU_ITEM_NOT_FOUND = -1;

	  // Local variables
	  int menuItemIndex;     // Index the player we want is stored

      /*************   Start getIndexByPlayerNum method  **************/

      // Set value to not found (-1)
      menuItemIndex = MENU_ITEM_NOT_FOUND;


   	  // FOR( all players in playerList )
   	  for(int loopStepper = 0; loopStepper < numMenuItems; loopStepper++)
   	  {
         // IF( playerNumber == playerList[i].playerNumber
         if( searchName.equalsIgnoreCase(menuItemList[loopStepper].name) )
         {
            // Set playerIndex
            menuItemIndex = loopStepper;

            //Set quit
            loopStepper = numMenuItems;

	     }// END IF

	  }// END FOR

      return menuItemIndex;

    }// END getIndexItemByName method

    /**********************************************************
     * Method Name    : swapMenuItemSpots
     * Author         : William Golembieski
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: This will serve as the constructor for our Category.
     *
     * BEGIN swapMenuItemSpots
     *    Set return value to first item not found
     *    Get index of itemOne
     *    IF(first item is found)
     *       Get index of itemTwo
     *       IF(second item is found)
     *          Set temp MenuItem to item one
     *          Copy item one into index of item 2
     *          Set index of item two to temp menu item
     *          Return swap success
     *       ELSE
     *          Set return value to second item not found
     *       ENDIF
     *    ENDIF
     *    Return if successful or not
     * END swapMenuItemSpots
     **********************************************************/

    public int swapMenuItemSpots(String itemOne, String itemTwo)
    {
      // Local constants
      int MENU_ITEM_NOT_FOUND   = -1;
      int FIRST_ITEM_NOT_FOUND  = -2;
      int SECOND_ITEM_NOT_FOUND = -3;
      int SWAP_SUCCESS          = 1;

      // Local variables
      int indexItemOne;
      int indexItemTwo;
      int returnValue;
      MenuItem tempMenuItem;

      /******************** Start swapMenuItemSpots method  *****************/

      // Set return value to first item not found
      returnValue = FIRST_ITEM_NOT_FOUND;

      // Get index of itemOne
      indexItemOne = getIndexItemByName(itemOne);

      // IF(first item is found)
      if(indexItemOne != MENU_ITEM_NOT_FOUND)
      {
		  // Get index of itemTwo
		  indexItemTwo = getIndexItemByName(itemTwo);

		  // IF(second item is found)
		  if(indexItemTwo != MENU_ITEM_NOT_FOUND)
		  {
			  // Set temp MenuItem to item one
			  tempMenuItem = menuItemList[indexItemOne];

			  // Copy item one into index of item 2
			  menuItemList[indexItemOne] = menuItemList[indexItemTwo];

			  // Set index of item two to temp menu item
			  menuItemList[indexItemTwo] = tempMenuItem;

			  // Return swap success
			  returnValue = SWAP_SUCCESS;
	      }

          // If item two doesn't exist
	      else
	      {
             // Set return value to second item not found
	         returnValue = SECOND_ITEM_NOT_FOUND;

	      }//END IF

	  }// END IF

	  // Return if successful or not
      return returnValue;

    }// END swapMenuItemSpots method

    /**********************************************************
     * Method Name    : toString
     * Author         : William Golembieski
     * Date           : March 9, 2018
     * Course/Section : CSC264 - 803
     * Program Description: This will format and print the Category
     *    with it's menu items.
     *
     * BEGIN toString
     *    Display category title
     *    FOR( All MenuItems in the category )
     *       Add menuItemList[i] to output string
     *    ENDFOR
     *    Add closing line
     *    Return the built output string
     * END toString
     **********************************************************/

   public String toString()
   {
      // Local constants
      final String CATEGORY_NAME = categoryName;

      // Local variables
      String outputString = "\n\n";   // Holds the output string
      String tempString   = "";       // Temp value to hold player

      /*************   Start toString method  **************/

      // Display category title
      outputString += Util.formStylizedTitle(50, CATEGORY_NAME, 80) + "\n\n";

      // FOR( All MenuItems in the category )
      for(int i = 0; i < numMenuItems; i++)
      {
         // Add menuItemList[i] to output string
         outputString += menuItemList[i].toString() + "\n";

      }// END FOR

      // Add closing line
      outputString += Util.formStylizedSeperator(50, 80) + "\n";

      // Return the built output string
      return outputString;

   }// END toString

} //End Category class
