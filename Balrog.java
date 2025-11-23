
/**
 * This is a Balrog class. It has STR between 50-100 and HP between 80-200.
 * It can attack twice; attack musty include creature base damage, 
 * demon 5% bonus, then repeat.
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Balrog extends Demon
{
    private static final int MAX_STR = 100;
    private static final int MIN_STR = 50;
    private static final int MAX_HP = 200;
    private static final int MIN_HP = 80;

    public Balrog() {
        super(
            Randomizer.nextInt(MAX_STR - MIN_STR) + MIN_STR,
            Randomizer.nextInt(MAX_HP - MIN_HP) + MIN_HP
        );
    }

    // Balrog attacks *twice* 
    @Override
    public int attack() {
        int firstHit  = super.attack();  // Demon -> Creature chain
        int secondHit = super.attack();
        return firstHit + secondHit;
    }
}