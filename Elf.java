
/**
 * This is the Elf class
 * It has 10% chance to do double damage. STR ranges from 5-18 and HP
 * range from 8-25.
 *
 * @author Sahar Naz
 * @version 2025-10
 */
public class Elf extends Creature
{
    private static final int MAX_STR = 18;
    private static final int MIN_STR = 5;
    private static final int MAX_HP  = 25;
    private static final int MIN_HP  = 8;
    
    public Elf() {
        super(
            Randomizer.nextInt(MAX_STR - MIN_STR) + MIN_STR,
            Randomizer.nextInt(MAX_HP - MIN_HP) + MIN_HP
        );
    }
    
    //10% chance to double the normal damage 
    @Override
    public int attack() {
        int damage = super.attack();

        // 10% chance → Randomizer.nextInt(10) == 1 (1..10)
        if (Randomizer.nextInt(10) == 1) {
            damage *= 2;
        }

        return damage;
    }
}