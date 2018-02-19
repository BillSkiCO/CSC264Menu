public class Util
{

   /**********************************************************
    * Method Name    : setLeft
    * Author         : Prof Scheemaker
    * Date           :
    * Course/Section :
    * Program Description:  This method will insert spaces
    *    in front of a string and return the new string. The
    *    number of spaces to insert and the string itself will
    *    be passed in as parameters.
    *
    * BEGIN setLeft (number of spaces, string)
    *   FOR (each space to be inserted)
    *      add a space to be beginning of the string
    *   END FOR
    *   return the new string with the leading spaces
    * END setLeft
    **********************************************************/

   public static String setLeft(int num, String word)
   {
      //local constants

      //local variables

      /*******************************************************/

      for (int i = 0;i < num;i++)

         word = " " + word;

      return word;

   }
   /**********************************************************
    * Method Name    : setRight
    * Author         : Prof Scheemaker
    * Date           :
    * Course/Section :
    * Program Description:  This method will insert spaces
    *    in front of a string and return the new string. The
    *    number of spaces will be determined by the field
    *    width and the length of the string (Width - Length).
    *    If the string is wider than the field width, no
    *    spaces will be added to the front of the string
    *
    * BEGIN setRight (field width, string)
    *    Find the length of the string
    *    Calc the number of spaces to be added
    *    IF (there is room to add spaces)
    *       FOR (each space to be added)
    *          add a space to the front of the string
    *       END FOR
    *    END IF
    *    return the string
    * END setLeft
    **********************************************************/

   public static String setRight(int width, String word)
   {
      //local constants

      //local variables
      int len = word.length(); //get the string length
      int pad = width - len;   //how many spaces to add to front of string

      /*******************/

      //if there is room to add sapces
      if (len < width)

         //add the spaces to the front of the string
         for (int i = 0; i < pad; i++)
            word = " " + word;

      //return the string
      return word;

   }

   /**********************************************************
    * Method Name    : addPostSpace
    * Author         : William Golembieski
    * Date           :
    * Course/Section :
    * Program Description:  This method will insert spaces
    *    at the end of a string and return the new string. The
    *    number of spaces to insert and the string itself will
    *    be passed in as parameters.
    *
    * BEGIN addPostSpace (number of spaces, string)
    *   FOR (each space to be inserted)
    *      add a space to the end of the string
    *   END FOR
    *   return the new string with the trailing spaces
    * END addPostSpace
    **********************************************************/

   public static String addPostSpace(int num, String word)
   {
      //local constants

      //local variables

      /*******************************************************/

      // For every space to be entered after the word
      for (int i = 0; i < num ;i++)
      {
         word += " ";
      }

      // Return the answer string
      return word;
   }

   /**********************************************************
    * Method Name    : formStylizedTitle
    * Author         : William Golembieski
    * Date           :
    * Course/Section :
    * Program Description:  This method will center and stylize
    *    a title for output. Only returns a styled one line string.
    *
    * Will look like: +-----My Title-----+
    *
    * BEGIN formStylizedTitle (field width, string, screenWidth)
    *    IF (there is room to add spaces)
    *       Pre-pad with spaces
    *       Add a + to word
    *       FOR (each space to be added before title)
    *          add style before title
    *       END FOR
    *       Add title
    *       FOR (each space to be added behind title)
    *          add style behind title
    *       END FOR
    *       Add final +
    *    END IF
    *    return the string
    * END formStylizedTitle
    **********************************************************/

   public static String formStylizedTitle(int widthOfStyleArea, String title, int screenWidth)
   {
      //local constants

      //local variables
      int len = title.length();                             // get the string length
      int prePad = ((screenWidth - widthOfStyleArea) / 2);  // Padding before style
      int frontPad = ((widthOfStyleArea - len) / 2);        // width of front title pad styling
      int rearPad = widthOfStyleArea - frontPad - len;      // Padding behind the title
      String word = "";                                     // String to return

      /*******************/

      //if there is room to add spaces
      if (len < widthOfStyleArea)
      {
         // Perform prepad
         for (int i = 0; i < prePad; i++)
         {
            word += " ";
         }

         // Add first +
         word += "+";

         // Perform front style
         for (int j = 2; j < frontPad; j++)
         {
            word += "-";
         }

         // Add pre-title space
         word += " ";

         // Add title
         word += title;

         // Add post-title space
         word += " ";

         // Perform rear style
         for (int k = 2; k < rearPad; k++)
         {
            word += "-";
         }

         // Add final +
         word += "+";

      } // END IF

      //return the string
      return word;
   }

   /**********************************************************
    * Method Name    : formStylizedSeperator
    * Author         : William Golembieski
    * Date           :
    * Course/Section :
    * Program Description:  This method will center and stylize
    *    a title for output. Only returns a styled one line string.
    *
    * Will look like: +-------------+
    *
    * BEGIN formStylizedSeperator (field width, string, screenWidth)
    *    IF (there is room to add spaces)
    *       Pre-pad with spaces
    *       Add a + to word
    *       FOR (each space in style area - 2 )
    *          add - style
    *       END FOR
    *       Add final +
    *    END IF
    *    return the string
    * END formStylizedSeperator
    **********************************************************/

   public static String formStylizedSeperator(int widthOfStyleArea, int screenWidth)
   {
      //local constants

      //local variables
      int prePad = ((screenWidth - widthOfStyleArea) / 2);  // Padding before style
      String word = "";                                     // String to return

      /*******************/

      //if there is room to add spaces
      if (widthOfStyleArea < screenWidth)
      {
         // Perform prepad
         for (int i = 0; i < prePad; i++)
         {
            word += " ";

         }// END FOR

         // Add first +
         word += "+";

         // Perform front style
         for (int j = 2; j < widthOfStyleArea; j++)
         {
            word += "-";

         }// END FOR

         // Add final +
         word += "+";

      } // END IF

      //return the string
      return word;
   }// END formStylizedSeperator

   /**********************************************************
    * Method Name    : formStylizedContent
    * Author         : William Golembieski
    * Date           :
    * Course/Section :
    * Program Description:  This method will center and stylize
    *    content for output
    *
    * Will look like: |   My Content   |
    *
    * BEGIN formStylizedContent (field width, string, screenWidth)
    *    IF (there is room to add spaces)
    *       Pre-pad with spaces
    *       Add a | to word
    *       FOR (each space to be added before title)
    *          add space before title
    *       END FOR
    *       Add title
    *       FOR (each space to be added behind title)
    *          add space behind title
    *       END FOR
    *       Add final |
    *    END IF
    *    return the string
    * END formStylizedContent
    **********************************************************/

   public static String formStylizedContent(int widthOfStyleArea, String title, int screenWidth)
   {
      //local constants

      //local variables
      int len = title.length();                             // get the string length
      int prePad = ((screenWidth - widthOfStyleArea) / 2);  // Padding before style
      int frontPad = ((widthOfStyleArea - len) / 2);        // width of front title pad styling
      int rearPad = widthOfStyleArea - frontPad - len;      // Padding behind the title
      String word = "";                                     // String to return

      /*******************/

      //if there is room to add spaces
      if (len < widthOfStyleArea)
      {
         // Perform prepad
         for (int i = 0; i < prePad; i++)
         {
            word += " ";
         }

         // Add first |
         word += "|";

         // Perform front style
         for (int j = 1; j < frontPad; j++)
         {
            word += " ";
         }

         // Add title
         word += title;

         // Perform rear style
         for (int k = 1; k < rearPad; k++)
         {
            word += " ";
         }

         // Add final |
         word += "|";

      } // END IF

      //return the string
      return word;
   }

   /**********************************************************
    * Method Name    : toTitleCase
    * Author         : William Golembieski
    * Date           :
    * Course/Section :
    * Program Description: This method will take in one word
    *    and convert it to titleCase.
    *
    * BEGIN toTitleCase
    *    IF word is longer than 0
    *       Get first letter and capitalize it
    *       Get rest of word
    *       Concatinate the two
    *       return titleCase word
    *    END IF
    * END toTitleCase
    **********************************************************/

   public static String toTitleCase(String word)
   {
      // Local constants

      // Local variables
      String firstLetter;          // First letter of word
      String restOfWord;           // Rest of the word
      String titleCaseWord = word; // Word in titleCase

      /******** Start to TitleCase method ******/

      // If word is longer than 0
      if(word.length() > 0)
      {
         // Get first letter and capitalize it
         firstLetter = (word.substring(0,1)).toUpperCase();
         restOfWord = (word.substring(1,word.length())).toLowerCase();
         titleCaseWord = firstLetter + restOfWord;

      }// END IF

      return titleCaseWord;

   } // END toTitleCase

   /**********************************************************
    * Method Name    : closingMessage
    * Author         : William Golembieski
    * Date           :
    * Course/Section :
    * Program Description:  This method will create and display a closing message
    *
    * BEGIN closingMessage
    *    Display message
    * END closingMessage
    **********************************************************/

   public static void closingMessage()
   {
      // Local constants
      String word =
            "	                        ������������"+ "\n" +
                  "	                        ��            ��"+ "\n" +
                  "	          �����        ��                ��"+ "\n" +
                  "	          �     �     ��      ��    ��     ��"+ "\n" +
                  "	           �     �    ��       ��    ��      ��"+ "\n" +
                  "	            �    �   ��        ��    ��      ��"+ "\n" +
                  "	             �   �   �                         ��"+ "\n" +
                  "	           ������������                         ��"+ "\n" +
                  "	          �            �    ��            ��    ��"+ "\n" +
                  "	         ��            �    ��            ��    ��"+ "\n" +
                  "	        ��   �����������      ��        ��     ��"+ "\n" +
                  "	        �               �       �������       �� "+ "\n" +
                  "	        ��              �                    ��"+ "\n" +
                  "	         �   ������������                   ��"+ "\n" +
                  "	         ��           �  ��                ��"+ "\n" +
                  "	         ������������    ��            ��"+ "\n" +
                  "                      �����������";

      // Local variables

      /******** Start to closingMessage method ******/

      // Print closing message
      System.out.print("\n\n\n\n" + word + "\n\n\n");

   }// END closingMessage

   /*
   OOOQOQOQOOQQQQQQQQQMQMQMQMQMQMQMQMQQMMQMQQQOOII6O6|^. |OQQMQMQMQMQMQQMMQMQMQMQMQMQMQMQMQMQQQMQMQMQMQMQMQQ
   OOOOQOOOQOQOQQQQQQQQQMQMQMQMQMQMQQMMQMOOO666QQOQI66II^.. .!|6QQMMQQMQMQMQMQMQMQMQMQMQMQMQMQMQMQMQMQMQMQQQ
   OOOOOOOOOQQOQOQQQQQQMQMQMMQQMMQQMO|6!6OQOQQOQQMQQQO6|^!!!!^.    .|MMQQMQMQMQMQMMQMQMQMQMQMQMQMQQMQMQMQMQQ
   OOOOOOOOOQOQOQOQQQOQMQQQQOQQQQQMOOII6OO6OOQQQMMQQI.!^!^6!.^^^..  ....IMMQMMQQMQMQMQMQQQQQQMQMQMQMQMQMQMQM
   OOOOOOOOOOOQOOQOQQQO. !|I666OQOO6OQQOQQQMQQQQQQQ6I|IO|^!O^!^... ^^.   ...OQMQMQMQMQMQMQQMQMQMQMQMQQMQMQMQ
   OOOOOOOOOOQOQQOQOI ^66OOOQOQQQOQOOQQMQMQMQMQQO66!6OOI6II.I6|.^!IOO6I|..  ^|QQQMMQMQMQMQQMQMQMQMQQMQMQMQMQ
   OOOOOOOOOOOOOQO!. IOOOQOQQQQQQQQMQMMQMQMQO|6OQIIO666Q6OOQ!.!  .^^^OQQQIOO...^6MQMQMQMQQMQMQMQMQMMQMQMQQMQ
   6O6OOOOOOOOOO^^I6|^|II66IIIIII6OQMQMQMQQ6|QOO6I6QOQ6I^I6^IOO66666OQ|6OQQQ|..^. !QMQMQMQQQMQQMQMQMQMQMQMQQ
   O6O6O6OOOOOO|6O!  .!I66II||!!6QQMOQ6|666Q6OQQQ6OOO|OO6|OOQOQQOQQQQQMQQQQQO^|     6QQQQQQQQQQMQMQMQMQMQMQQ
   O6OO6O6OOO66QI^  .!I66IIII6OOQO666I6OO6OQQQMQOOQQOQQ6^OQQMQMQQQMQMQMQMMQQQO.      |OQQQQQQMQQMQMQMQMQMQMQ
   6O66OO6O6OQQI!^. .|6OOO6OOOQQQQMQQMMQMQQMQMQQMMQQQMQMMQQMQMQMQMQQMQMMQQMMQQ|. . ^^I!6QQQQQMQMQMQMQMQMQMQQ
   666666OO6QQOOO|!!^6Q66OO666OOQQOQOOQQOQQOOQQMQMQMMQQMQQMQMMQMQMQMQMQQMMQQMQOQQQQQO^!|OMQQQQQQQQMQQQQQQQQQ
   6666666OOQQQQQOIO!.!I6OQQQQO6II|IIIII!^66QQMQMQMQMMQMQMQMQMQMQMQMQMQMQMQQQQMQQQQI!|^^OOQMQQMQQQMQMQMQMQQQ
   6I66666OOQQQMQQO|!!6O|I|66QOOQQQQQOOI||!I6QQMQQMQMQMQMMQMQMQMQMQMQMQMQMQMQMQMQQI|OQ6. OQQQQQQQQQMQQQQQQMQ
   I6I6I666OQQQMQMQQMQOOO6OMQQMQMQMQMMQQMQQQQMQQQQQQMQMQMQQMQMQMMQQMQMQMQMQMMMMQMQMQMQMOI.I|QQQQQQQQQQQQQQQQ
   III6666I6QQQMQMQQMQMMQQMMQQMQMQMQMQMQMMQQMQOOQQQQQQQQQQQQQMQQQQQQQMQMQMQMMQMQMMQMQMQQQO!.!QQQQMQQQQQMQQQQ
   IIII6IIIIOQQQMQMMQQMMQMQMQMQMQMQQMQMQQMMQMQQQMQMQOOQQQQQQMQMQMQQQQQQOQQMQQMQMMMQMQMQMQQ6 ^.OQQQQQQQQQQQQQ
   III6I||!^|OQQMQMQMQMQMMQMQMQMQQQQQQQQMQMQMQMQMQQMQMQMMQMQMQQOOO666IIII|I6QMQMQMQMQMQMQQQO^ .|QQQQQQQQQQQQ
   I|III!^...6OOQQMQMQMQMQMQMQQQOOO6OOOOOOOQQQQQQQQQQQQQQQQOII!!^!^^^!^!^^!!6OQQMMQMQMQMQQOMQ6..6QQQQQQQQQQQ
   ||I||^^.  ^66OQQQQOQQQOQQQO66||!|||!I|IOOOO6OOOOOOO6I|!!.^....^.^.^^^!!!^!6QQQMMQQMQMMQQMQM6IOQQQQQQQQQQQ
   |||!^.     !II666I||||||||!!^^^^..^.^^.^|III||I||!^....^.^^..^.^.^.^^^!!|I66QQQQQMQMQMMQMQMQOQQQQQQQQQQQQ
   !|!...     |6I|||^^^^.^ . ..............^.^....^.....^^.^^^^.^.^^^^^^^!|II66OMQMQMQMQMQMMQMQMQ OQQQQQQQQQ
   !!^.     ^O!!!^!!...^^. . . ....^.^.^.^^.^.^... .....^^^^^!^!^!^^^!^!^|||66QQQQMQMQMQMQMQQQMQQ.|OQQQQQQQQ
   ^^.      ^.!^!!!|^..^.... . ...^.^.^.^.^.^^....^..^.^^.^.^^!^!^!^^!^!!|!|I|IOQMQMQMQMQMQMQMMQO^ QQQQQQQQQ
   ...     . !I|!^I6|...^^^^...^^^^^!^!!^!^^!^^^^.....^^^^^!^!^^^^^!!!^!!|!||IIOQMQMQMQMQMQMQQMMQOI!QQQQQQQQ
   ..       .|6OOOOO|^..^^^!!!.^^^^^^!.^^^^^^^.^..^^^^^.^.^.^..^^^^^^!^^!||||I66QQMQMQMQMQMQQMQMQMQIQQQQQQQQ
           ..|OOQQQOI!.^.^^^^^^!^^!!^^.^.^^^^^^.....^..^.^^.^^^^..^!^^!^||||I|I6OQQMMQMQMQMQQMMQMQQOMQQQQQQQ
           ..I6OOQQQOI^^^..^.....^.^^^^^^^^.^.....^.^.^..^!|!||II6I|!.^^^!||I|I6OOQQQMQMQMQMQMQMMQQOQQMQQQQQ
            |I6OQQQQOO!.^^^..  . . ....^.^..^..^^.^^^|!|6OOQQQQQMQMQQ6I|!!|I|IIIIIOQQMMQMQMQMQMQMQ66QMQQQQQQ
           .II6OQQMQQQ|!^.^... . .^.^^^^.^.^.^..^!||I6IOOQQQQMQMQMQMQQQO666IIII|||IOMQMQMQMQMQMQQMQ|QQQQQQQQ
            .IOOQQQQQQO!^^^..^.^!66||I!!!^^^^!^!!^||I6OOOQQMQMQQQQQQO66III666II||!!IQQMQMQMQMQMQQQQQMQQQQQQQ
           .|OOQQQQQQQOI^^.^!|6QQQOOOO6|!I|I|||I||||I66OOOQMQMQQQQQQQQQO666666I||!!|6QMMQQMQMQMMQMO6QQQQQMQQ
            |6QQOQQQMQQO!^.^6OQQQQQQQOQ666II66666I6666OOQQMQQMMMOQMQQQOQQOO6III||!!!6OQQQMMQQQMQQOO|QQQQQQQM
            .6OOQQQQQQQQ|^|6OMQMQMQQQQQQOO66IIIIIII6OOQQQQQQOQQMMQMI|66OQOO6I||||!|!I6OQQMQMQQQO66O!OQQQQQMQ
             ^6OOQQQQMQQ66QQQMQMQMQMQQMQQMQOO|^^^^!!66O66666!^IQQO|!|!I6I|II|!!|!||||6OMQMQMQMQQ6IIIOQQQQQQQ
             ..QOOQQQQMQQIOOQQQMQMMQQMQ66QOO6|^....^!!!I!^!||!!|!I6III|!^^^^^^^^!!!||IOQMQMQMQQQOI!!QQQQQQQQ
              .^OQOQQQMQQ^6OOQQQOIQQQQQ^!||!|!^...^^!!!^|||!|II666II|!!^^^^..^^.^!|||I6QQMQMQQOQQ6I^OQQQQQQQ
    .           .6OOQQQQQ!|I6OO6|!!!!|||!|!!|^^...^.^!!!^^!|^^^^^^^^^^.^^^...^..^!|||I6OQQMQQOOOOI!!OQQQQQQQ
   . .       . .. ^OQQQQQ6^!||I!II||I||!^!!!!. .....^^^!^.^^^^^!^^^.^^^^^......^!||IIIOQQMOQO6OO6^|!QQQQQQQQ
   . . . . .  . .. !IOQQQO^.^^....^.^^^^!^!!.. ..^. .^!^^...^.^^!^.^.^^^^.^.^^.^!|||II6QMQQO|6OI|I!6QMQQQQQQ
   ..... . . ..  .  .6OQOQ^..... .    ....^^.  . ^..^^^^^^.^.^.^^^^^!^!^^!^^!!!!|||III6QQMQII|!!!!!QMQMQQMQQ
   ..........        .OOQQI...     . ......^.  ...^..^^!^^^^^.^^^^^^^^^^^^^^!!|!|IIII6I6OO666I!^.^6QQMQMQQQQ
   .^.^...            !O6O6... . . ..^........ ...^^.^!!|!!^^^^.^^^^^^^^^^^!!|||I|II6IIIIII!^^^^^6QMQMQMQQQQ
   ^.^^...            .^OI^|.......^.......^^  ......^^!^!!!!^^^^.^.^.^^^^!!|I||||I|II6III6!^^!!OQMQMQMQMQQQ
   ^^...               ^I.^|^^.^^^^^.....^^!|. .   . .^!!^^!^^^.^^^^^^.^^!!!|I||||II6IIIIIO6II6MQMQMQMQMQMQQ
   .                   ...^|I|!!!^^^^.^..^^!^....^.^!!|||||!!^^.^^.^.^.^!^|!!|I||||IIIIIIIIIQMQMQQMMQMQMQMQQ
                          ^^|O||!!^^^.^.^.^!^!|!!|IIIIOQQOO6!^^....^.^.^!^!!|I|||IIIII|II6|IO6MQQMQMQMQMQMQM
                           .^O6I|||!!^...^.^^!6O66OOOOO6I|!|!^^.^^.^.^^.!^!||II|I||IIII|IIII|QQMQQMQMQMQMQMQ
                             !66II||!^^..^.. .  .!6OO6I!!^^^^^.^.^^^^^^!!!||IIIIIII||IIII6I|IQQMQMMQMQMQMQMQ
                         .   . .^|||!^... .   ..^||!II|!!^^^^^^^.!!!||!!!||||IIIII|IIII666I|IQQQMQMQMQMQMMQM
                        ....... .|I|!^^ . . . ^^^!!|II|||!!!||!!!!!|IIII|II||IIIII|II|I66OI|IOQQQMQMMQMQQMMQ
                    .....^.^......|I|!^ ....^^^!!||!II||!.^!!!III666OOO66II|IIII6I6II66666I|I6MQMQMQQMQMQMMQ
   ..^.^^.. .      ...^^^^!^^^....^|I|^^!!!|||I||^!^^.^.!666O6I6I66QOO66666I|II66I6II6OO66|IIIQMQMQMQQMMQMQM
   !|!!!^^. . .   ....^^^^^^^^^....!|||!||I666I!|6OOOOO6OQQOQQO6I|^^^^|!||I6I66O66I666OO66|||IOQQMQMQMQMQMQM
   I6I|!!.. . .   ..^^!!!^^^.^..... II||I66OQQOOQQOO6666||!!|!!!^^^^^^^!II6I6O66666O6OOO66|I|IOQQQMQMQQMQMQM
   66I|!!....  . .^.^^!!!!!^!^^..... |6II666I!^!!|||||!!!!!^!|!!^!|!!!|||II6I666666OQOOOII|||IIOQQQQMQMQMMQM
   666I|!^... . ..^^!!!!|!!^^^..^.....|II6II!!!|!|!||III6OO6IIIIII|||III6I6I666I6OQOOOOOI|||I||6.^OQQQMQQMMQ
   666II|!^^.......^!!!!|!|!^^^..^.....|666II||!|II6II6666I6OOO666II6IIIIII6I6OOOQOOOO6II||I|I|IQMQ6 6MQQMMQ
   I6III||!^^......^^^!!!!!^!!!^^^^^.^.^!66O66III6I666OOOOOO6IIIIII|||I|IIII66OOQOOOO6II|I||I|I|MMQQMQM^|MQQ
   I6I6I||!^^... ....!^^!^!!!!!!!!!!^!!|||I66666II6I66I!^^..^^^^!^^!!||III6OOOOOOOOO6IIIIIIIIII|IQMQMQMQMO.6
   I6I6II|!!^.........^^^!!!||!||||I|I6I66!||IIII||!!^!^^.^^^..^^^^!!|II666OOOOOOOOIIIII6IIIII6I|^OMQQMQMQMQ
   I6I6II|||!!^^... . ....^!!|II6I66O6OOOO^|!I6||!!^^..^^.^!!^^.^!||I6I66OOOO6OO66IIIII6IIIIIII6I!|6QQMQQMQM
   IIII6II||!!^^... ....^^!!II666OOOQQQO^!|!||I6I|||!||||II6III6I66O6OO6OOOOOOO6III|6II666IIIII6I|!|IQQQMQQM
   IIII6III||!!!^^^..^.^^!||I6OOOQQQQQQ^!OI!|III6666II6I666O6O6OO6OQOOOQQQOOOO6III6IIIII6IIIIII6II||IIOQQQQM
   IIII6I66II||!!!^!^^!!!II66OOOQQQQOI!!OQ6!||III666OOOOOOOOQOOQOOOQQQQOQQOOO66IIIIII66II6II6I66IIII|I6OQOQQ
   I|IIII6I66II|||||I|III66OOOQOQO6^.^!IQMQ!|II|I666666OOOOOQQQQQQQQQQQQOQQO6I6II6II66I6IIIIIIII6III||IOQOQO
   I|I|IIIII6I6I6I6II66O6OQOQOOO6! .!|!QQQM!|I|III6666OO6OOOOOQQQQQQQQQQQQOO666666I6IIIIIIIII6I6IIII|||OQOO6
   IIII|IIIIII6666O6O6OOQOQQQQO6^..^!^IQQMQ^|||IIII6666OOOOOQOOQQQQQQOQOOO6666666I6IIIIII6IIIIIIII||!||6OO6I
   II|I|I|IIII666OOOOQQQQQQQO6.   .!!6OQQQQ^!|I|III666666OOOOOOOOOQQOQOQOOOO666II6IIIIIII66IIIIIIII||!|6OO6^
   II|I|I|III6666OQOQQQQQQQQI.   .. .|QQQMQ!!|IIIIII66I66666O66OOOOOOOOOOO6O66IIIII6IIIII6III6I|||I||!!66O6
   III|I||I666OOOOQQQQQQQO ...!!^||IOQQQMQQI!!|II|I6I6I666666666O6OOOOO66I666IIIIIII|IIII6I6II|||I||!|I66O^
   III|IIII666OOQOQQQMQ^^ . .I|!I6IIQQQMQMQ6|!!|IIII66I6666I666666O6OOO6I6IIII||I||IIII6III|I|!!|!|!||I66| .
   IIIIIIII66OOOQQQQQ.| ^^!I6I^^IO66QQQMQMQO6|||||III66666I66666I6I66III6IIII|||I|I||IIII|||!!!!!|!!^!|6!
IIIIII6I6OOQQQQQ!.6 ^!^IO6I||II6IMQMQMQQ6II|||||III6I66I666I6666|IIIIIIIIIIIII||||I|I||^!!^^^^!!!!|6! .
*/
}
