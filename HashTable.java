import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * HashTable.java - opens a text file of common words and creates a hash table
 * from the contents, and provides functions for hashing, finding, and toString
 *
 * @author Garrett Detwiler
 * @version 9 December 2023
 */
public class HashTable
{
    public static final int MAX = 30;
    private int numCollisions = 0;
    private String hashTable[];
    /**
     * @param Constructor opens a text file and creates a hash table of the contents
     */
    public HashTable ()
    {
        String in = "common_words.txt"; // file name
        hashTable = new String[MAX]; // array of strings will be filled with common words
        
        try (BufferedReader reader = new BufferedReader(new FileReader(in))) // try to open file
        {
            String line;
            while ((line = reader.readLine()) != null) // read line by line
            {
                String word = line.toLowerCase();
                
                int hashed = hash(word); // store as int to increment if necessary
                // linear probing
                while (hashTable[hashed] != null)
                {
                    hashed++;
                    numCollisions++;
                }
                hashTable[hashed] = word;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * @param hash(String word) creates an index point for the 
     * word in the hash table
     * @return integer representing assigned index in hash table
     */
    public int hash(String word)
    {
        char ch;
        double total;
        total = 0.0;
        for (int i = 0; i < word.length(); ++i) 
        {
            ch = word.charAt(i);
            total += (double) ch;
            total *= Math.PI;
        }
        double decimal = total - (int) total;
        int hash = (int) (MAX * decimal);
        return hash;
    }
    /**
     * @param find(String word) determines if an inputted word is in the hash table
     * @return true if the inputted word is in the hash table
     */
    public boolean find(String word)
    {
        for (int i = hash(word); i < MAX; i++) // searches whole hash table
        {
            if (hashTable[i] != null) // avoids null pointer exception being thrown
            {
                if (hashTable[i].equals(word)) // compare words
                {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * @param toString() creates a formatted String representing the 
     * information of the hash table
     * @return a formatted String representing the data of the hash table
     */
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        
        result.append("Number of collisions building the table: " + numCollisions + "\n"); // header showing number of collisions
        for (int i = 0; i < MAX; i++) // traverse whole hash table
        {
            if (hashTable[i] != null)
            {
                result.append(i + 1).append(" ").append(hashTable[i]).append("\n"); // add next word to String
            }
        }
        
        return result.toString(); // convert to String
    }
}
