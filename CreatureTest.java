import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the Creature hierarchy.
 * 
 * @Author Sahar Naz
 * @version 2025-10
 */
public class CreatureTest
{
    //Human class tests
    @Test
    public void testHumanRanges() {
        Human h = new Human();
        int hp = h.getHealth();
        
        assertTrue("Human HP should be between 5 and 25", hp >= 5 && hp <= 25);
        
        // Attack tests indirectly verify strength range (5–20)
        int dmg = h.attack();
        assertTrue("Human attack should be at least 1", dmg >= 1);
        assertTrue("Human attack should not exceed max strength", dmg <= 20);
    }

    // Elf class tests
    @Test
    public void testElfRanges() {
        Elf e = new Elf();
        int hp = e.getHealth();
        
        assertTrue("Elf HP should be between 8 and 25", hp >= 8 && hp <= 25);

        int dmg = e.attack();
        assertTrue("Elf attack should be at least 1", dmg >= 1);
        assertTrue("Elf attack should not exceed possible max (18 * 2 = 36)",
                   dmg <= 36);
    }

    @Test
    public void testElfMagicPossible() {
        Elf e = new Elf();

        boolean doubledDamageSeen = false;

        // Try enough attacks to give the 10% magic a chance to appear
        for (int i = 0; i < 200; i++) {
            int dmg = e.attack();
            if (dmg > 18) {
                doubledDamageSeen = true;
                break;
            }
        }

        assertTrue("Elf should occasionally do double damage", doubledDamageSeen);
    }

    // CyberDemon class tests 
    @Test
    public void testCyberDemonRanges() {
        CyberDemon cd = new CyberDemon();
        int hp = cd.getHealth();
        assertTrue(hp >= 25 && hp <= 100);

        int dmg = cd.attack();
        assertTrue(dmg >= 1);
        assertTrue(dmg <= 40 + 50); // possible demon bonus
    }

    @Test
    public void testDemonMagicPossible() {
        CyberDemon cd = new CyberDemon();

        boolean bonusSeen = false;

        // Try many attacks to detect the +50 demon bonus
        for (int i = 0; i < 400; i++) {
            int dmg = cd.attack();
            if (dmg > 40) {
                bonusSeen = true;
                break;
            }
        }

        assertTrue("Demon should occasionally do +50 bonus damage", bonusSeen);
    }

    // Balrog class tests 
    @Test
    public void testBalrogRanges() {
        Balrog b = new Balrog();
        int hp = b.getHealth();

        assertTrue("Balrog HP should be between 80 and 200", hp >= 80 && hp <= 200);
    }

    @Test
    public void testBalrogAttacksTwice() {
        Balrog b = new Balrog();

        int dmg = b.attack();

        // Balrog strength is minimum 50, so each hit is at least 1.
        // Two attacks means minimum total = 2.
        assertTrue("Balrog should do at least 2 damage", dmg >= 2);
    }

    @Test
    public void testBalrogDamageUpperBound() {
        Balrog b = new Balrog();

        // Max = (100 + 50) twice = 300 max possible
        int dmg = b.attack();
        assertTrue(dmg <= 300);
    }

    // Tests for damage and death
    @Test
    public void testTakeDamageAndAliveStatus() {
        Human h = new Human();

        h.takeDamage(999); // kill it
        
        assertTrue("Human should be knocked out", h.isKnockedOut());
        assertFalse("Human should not be alive", h.isAlive());
    }
}
