import java.util.Random;

/**
 * A static utility class Singleton that maps random number generation 
 * from the range 0..limit -1
 * to the range 1..limit
 * 
 * @author Sahar Naz
 * @version 2025-10
 */
public class Randomizer
{
    private static Random rand;


    /**
     * nextInt is a static method designed to return a random number between 1 and maxValue, inclusive
     * NOTE this is different than the behavior of the Random class default behavior which
     * returns 0 .. maxValue-1
     * 
     * As a side effect, the first time the Randomizer is utilized it initializes 
     * the object of type Random. It is implementing the Singleton pattern. We will discuss singletons
     * later in the course
     * 
     * @param  maxValue  the cap of the random number generation (inclusive)
     * @return a random number from 1..maxvalue
     */
    public static int nextInt(int maxValue)
    {
        if (rand == null) {
            rand = new Random();
        }
        
        return rand.nextInt(maxValue)+1;
    }
}
