
/**
 * this is the CyberDemon class.
 * It has STR between 20-40 and HP between 25-100
 *
 * @author Sahar Naz
 * @version 2025-10
 */
public class CyberDemon extends Demon
{   
    private static final int MAX_STR = 40;
    private static final int MIN_STR = 20;
    private static final int MAX_HP = 100;
    private static final int MIN_HP = 25;

    public CyberDemon() {
        super(
            Randomizer.nextInt(MAX_STR - MIN_STR) + MIN_STR,
            Randomizer.nextInt(MAX_HP - MIN_HP) + MIN_HP
        );
    }
}