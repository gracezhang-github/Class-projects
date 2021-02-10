// This program implements a class that creates an inventory
// to keep track of all the letters in the alphabet.

import java.util.*;

public class LetterInventory {
    public static final int COUNTERS = 26;
    private int[] elementData;
    private int size;
    
    /* Constructs an inventory of all the alphetic letters in the
     * given string, where the casing of letters and non-alphetic letters
     * are ignored
     * @param data - the given string to pass through
     */
    public LetterInventory(String data) {
        // set the size to 0 since no input
        // letter case needs to be ignored
        // create something that stores each element
        elementData = new int[COUNTERS];
        size = 0;
        data = data.toLowerCase();

        // we want something so it loops through the data inputed - for loop
        // if the character is a letter (use Java String and Character classes; charAt)
        // once confirmed that the character is a letter:
        //      increment the size
        //      increment the element at that position (since you want to keep count)
        for (int i = 0; i < data.length(); i++) {
            if (Character.isLetter(data.charAt(i))) {
                elementData[data.charAt(i) - 'a']++;
                size++;
            }
        }
    }

    /* Returns a count of how many of this letter where case doesn't
     * matter are in the inventory.
     * @throws - IllegalArgumentException if a non-alphabetic character
     *           is passed
     * @param letter - the given letter to go through the inventory
     * @return - the total count of how many of the given letter is in the inventory
     */
    public int get(char letter) {
        // we want to get the count of how many times a specified character
        // is in the inventory
        //      case doesn't matter
        //      if that specified character is not a letter, throw 
        // we want to return the number of times a specified character
        // through accessing the elementData was already storing the data
        // in the inventory
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException();
        }
        letter = Character.toLowerCase(letter);
        return elementData[letter - 'a'];
    }

    /* Sets the count of the given letter, where case is ignored
     * to the given value
     * @throws - IllegalArgumentException if the given value is negative 
     *           or if a nonalphabetic character is passed         
     * @param letter, value - the given value is set to be the count of the 
     *                          given letter
     */
    public void set(char letter, int value) {
    // we want to set the total count of the letter equal
    // to the value
    // if the character that was given is not a letter
    // then throw exception; exception is first
    // size should also be altered: create a variable to keep track
    // letter is case not sensitive
        if (!Character.isLetter(letter) || value < 0) {
            throw new IllegalArgumentException();
        }

        letter = Character.toLowerCase(letter);
        int newSize = value - elementData[letter - 'a'];
        size += newSize;
        elementData[letter - 'a'] = value;
    }

   /* 
     * Returns the sum of all the counts in the inventory
     * @return - returns the total of all counts in the inventory
     */
    public int size() {
        // return the sum of all counts
        //      we can do this just by returning the size
        //      since the size is already counted and saved
        //      within the directory
        return size;
    }

    /* Returns true if the inventory is empty (counts = 0)
     * @return - true if the inventory is empty
     */
    public boolean isEmpty() {
        // true if size is 0 == all counts are zero
        return size == 0;
    }

    /* Returns a string representation of all the letters
     * in lowercase and in sorted order within the inventory
     * @return - returns all the letters within the inventory
     *             all in lowercase and sorted order
     */
    public String toString() {
        // want to return a string with brackets
        // we want to know the number of occurrences of each letter
        //      the number of occurences == the count in the inventory
        // set up a result variable
        // go through the counters (for loop), go through the property
        // that stores the elements (nested for loop), 
        //      every time this element occurs, add to the result var
        String result = "[";
        for (int i = 0; i < COUNTERS; i++) {
            for (int j = 0; j < elementData[i]; j++) {
                char occurrence = (char) (i + 'a');
                result += occurrence;
            }
        }
        return result + "]";
    }

    /* Constructs a new inventory object that symbolizes the
     * sum of this LetterInventory and the given LetterInventory        
     * @param other - the other given LetterInventory
     * @return - the sum of the two LetterInventory added together
     */
    public LetterInventory add(LetterInventory other) {
        // create a new LetterInventory object:
        //      this new inventory object should add this inventory
        //      to the other inventory given
        // when adding: the stored counts should be added
        //      which means that the elementData should be added
        //      since thats where the elements are stored
        // use for loop
        // When addingg two inventories together and combining it into one:
        //      the size is also extended, which means that the size should
        //      should also increment with respect to the counts for each letter
        LetterInventory addition = new LetterInventory("");
        for (int i = 0; i < COUNTERS; i++) {
            addition.elementData[i] = this.elementData[i] + other.elementData[i];
        }
        addition.size = this.size + other.size;
        return addition;
    }

    /* Constructs a new LetterInventory object that symbolizes the
     * result of this LetterInventory and the given LetterInventory
     * when subtracted       
     * @param other - the other given LetterInventory
     * @return - returns null if the result is negative, if not
     *              this returns the result of the subtraction
     *              bewteen this LetterInventory and the given LetterInventory
     */
    public LetterInventory subtract(LetterInventory other) {
        // create a new LetterInventory object: 
        //      this new inventory object should subtract the other inventory
        //      from this inventory
        // use for loop
        // when subtracting: the stored counts should be subtracted
        //      which means that the elementData should be subtracted
        //      since thats where the elements are stored
        // if the ending result of the subtraction is less than zero:
        //      then you should return null
        // should alter size: subtract other size from this size
        LetterInventory subtraction = new LetterInventory("");
        for (int i = 0; i < COUNTERS; i++) {
            subtraction.elementData[i] = this.elementData[i] - other.elementData[i];

            if (subtraction.elementData[i] < 0) {
                return null;
            }
        }
        subtraction.size = this.size - other.size;
        return subtraction;
    }

}
