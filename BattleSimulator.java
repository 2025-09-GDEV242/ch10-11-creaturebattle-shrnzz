import java.util.ArrayList;
/**
 * This is a battle simulator class. It wil build the two armies, 
 * run the combat loop, handle 1v1 fights and print a battle report 
 *
 * @author Sahar Naz
 * @version 2025-10
 */

public class BattleSimulator
{
    private ArrayList<Creature> goodArmy;
    private ArrayList<Creature> evilArmy;

    public BattleSimulator()
    {
        goodArmy = new ArrayList<>();
        evilArmy = new ArrayList<>();

        buildGoodArmy();
        buildEvilArmy();
    }
    
    //Build the armies
    private void buildGoodArmy()
    {
        // Example: build army of ~100 troops
        for (int i = 0; i < 100; i++) {
            int roll = Randomizer.nextInt(10);  // 1..10

            if (roll <= 6) {
                goodArmy.add(new Human());
            }
            else if (roll <= 8) {
                goodArmy.add(new Elf());
            }
            else {
                // optional: add more races later
                goodArmy.add(new Human());
            }
        }
    }

    private void buildEvilArmy()
    {
        // Example: build army of ~40 troops
        for (int i = 0; i < 40; i++) {
            int roll = Randomizer.nextInt(25); // 1..25

            if (roll <= 18) {
                evilArmy.add(new Human());
            }
            else if (roll <= 24) {
                evilArmy.add(new CyberDemon());
            }
            else {
                evilArmy.add(new Balrog());  // the big bad
            }
        }
    }

    // Run the battle 
    public void runBattle()
    {
        int goodIndex = 0;
        int evilIndex = 0;

        System.out.println("The battle begins!");
        System.out.println("Good army size: " + goodArmy.size());
        System.out.println("Evil army size: " + evilArmy.size());

        // Main loopc: ontinues until one army runs out
        while (goodIndex < goodArmy.size() && evilIndex < evilArmy.size()) {

            Creature good = goodArmy.get(goodIndex);
            Creature evil = evilArmy.get(evilIndex);

            // 1v1 combat
            fightOneOnOne(good, evil);

            // Decide who fell
            if (!good.isAlive() && !evil.isAlive()) {
                // both died
                System.out.println("Both fighters fell!");
                goodIndex++;
                evilIndex++;
            }
            else if (!good.isAlive()) {
                System.out.println("Good creature at index " + goodIndex + " has fallen!");
                goodIndex++;
            }
            else if (!evil.isAlive()) {
                System.out.println("Evil creature at index " + evilIndex + " has fallen!");
                evilIndex++;
            }
        }

        // Final result
        System.out.println("\n===== AFTER ACTION REPORT =====");

        if (goodIndex >= goodArmy.size() && evilIndex >= evilArmy.size()) {
            System.out.println("All combatants on BOTH sides perished.");
        }
        else if (goodIndex >= goodArmy.size()) {
            System.out.println("Evil Army Wins.");
        }
        else {
            System.out.println("Good Army Wins.");
        }
    }

    // One on one fight 
    private void fightOneOnOne(Creature c1, Creature c2)
    {
        System.out.println("\nNew duel begins:");
        System.out.println("Good HP: " + c1.getHealth());
        System.out.println("Evil HP: " + c2.getHealth());

        // Both alive: they simultaneously attack
        while (c1.isAlive() && c2.isAlive()) {
            int dmg1 = c1.attack();
            int dmg2 = c2.attack();

            c2.takeDamage(dmg1);
            c1.takeDamage(dmg2);

            System.out.println("Good hits for " + dmg1 + ", Evil hits for " + dmg2);
            System.out.println("Good HP: " + c1.getHealth() + " | Evil HP: " + c2.getHealth());
        }
    }
}