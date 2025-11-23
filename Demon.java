
/**
 * This is a Demon class
 * This class has 5% to add +50 damage
 *
 * @author Sahar Naz
 * @version 2025-10
 */
public abstract class Demon extends Creature
{
    public Demon(int str, int hp) {
        super(str, hp);
    }

    // 5% chance to add 50 extra damage 
    @Override
    public int attack() {
        int damage = super.attack();

        // 5% chance → 1 out of 20
        if (Randomizer.nextInt(20) == 1) {
            damage += 50;
        }

        return damage;
    }
}