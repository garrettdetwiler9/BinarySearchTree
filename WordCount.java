/**
 * WordCount.java - stores the word, number of occurrences, 
 * and line numbers of said occurrences for words in a medium
 *
 * @author Garrett Detwiler
 * @version 9 December 2023
 */
public class WordCount implements Comparable<WordCount>
{
    protected String word;
    protected int count;
    protected CircularList lineNums;
    /**
     * @param Constructor() creates an empty object and instantiates data members
     */
    public WordCount()
    {
        word = "";
        count = 0;
        lineNums = new CircularList();
    }
    /**
     * @param Constructor(String w) creates an object for a specific word and 
     * instantiates data members
     */
    public WordCount(String w)
    {
        word = w;
        count = 0;
        lineNums = new CircularList();
    }
    /**
     * @param compareTo(WordCount other) compares the letters of two words to each other
     */
    public int compareTo(WordCount other)
    {
        return word.compareTo(other.word);
    }
    /**
     * @param toString() creates a formatted String representing the 
     * data of the WordCount object
     * @return formatted String representing data of the WordCount object
     */
    public String toString()
    {
        return String.format("%-12s %3s %s", word, count, lineNums.toString());
    }
}
