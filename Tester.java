import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Tester.java - open a text file, and create a hashed concordance 
 * using a binary search tree and a hash table
 *
 * @author Garrett Detwiler
 * @version 9 December 2023
 */
public class Tester
{
    /**
     * @param main execute all run-time functions
     */
    public static void main()
    {
        String in = "input.txt";
        
        HashTable table = new HashTable();
        System.out.println(table.toString());
        
        try (BufferedReader reader = new BufferedReader(new FileReader(in)))
        {
            // declare variables and objects
            String line;
            int lineNumber = 0;
            BSTree<WordCount> t = new BSTree<WordCount>();
            // read file line-by-line
            while ((line = reader.readLine()) != null)
            {
                String[] words = line.split("\\s+"); // separating words from string
                lineNumber++;
                System.out.print(lineNumber + ":  ");
                boolean sameLine = false; // to not repeat lineNumber printing in concordance
                for (String word : words)
                {
                    //print the word
                    System.out.print(word + " ");
                    word = word.toLowerCase();
                    
                    if (!(table.find(word))) // if current word is not in hash table
                    {
                        WordCount wordCount = new WordCount(word);
                        if (t.find(wordCount) != null) // if word has a place on BST already
                        {
                            // if the word appears on a new line, add new lineNumber to wordCount
                            if (!sameLine)
                            {
                                t.find(wordCount).lineNums.append(lineNumber);
                                sameLine = true;
                            }
                        }
                        else // if current word is not in BST yet
                        {
                            // add word object to BST and add lineNumber to wordCount
                            t.insertBST(wordCount);
                            t.find(wordCount).lineNums.append(lineNumber);
                        }
                        t.find(wordCount).count++; // keep track of word occurrences
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.print(t.toString()); // print BST
        }
        catch (IOException e) // catches file not opened error
        {
            e.printStackTrace();
        }
    }
}
