import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestBattle {

  @Test
  public void testBattle() {
    // Test #1
    String chikapuName = "Chikapu";
    float chikapuAttack = 38.5f;
    float chikapuDefense = 20.0f;
    float chikapuHP = 200f;

    String zarichardName = "Zarichard";
    float zarichardAttack = 25f;
    float zarichardDefense = 12.5f;
    float zarichardHP = 200f;

    Battle battle = new Battle(chikapuName, chikapuAttack, chikapuDefense, chikapuHP, zarichardName, zarichardAttack,
        zarichardDefense, zarichardHP);

    while (!battle.isMonster1Dead() && !battle.isMonster2Dead()) {
      battle.simulateRound();
    }

    assertTrue(battle.isMonster2Dead(), "Test 1, Zarichard did not faint.");
    assertEquals(battle.getMonster1HP(), 160, "Test 1, Chikapu's HP does not match.");
    assertEquals(battle.getMonster2HP(), -8, "Test 1, Zarichard's HP does not match.");

    // Test #2
    chikapuName = "Chikapu";
    chikapuAttack = 15.0f;
    chikapuDefense = 10.0f;
    chikapuHP = 200f;

    zarichardName = "Zarichard";
    zarichardAttack = 45f;
    zarichardDefense = 10.0f;
    zarichardHP = 200f;

    Battle battle2 = new Battle(chikapuName, chikapuAttack, chikapuDefense, chikapuHP, zarichardName, zarichardAttack,
        zarichardDefense, zarichardHP);

    while (!battle2.isMonster1Dead() && !battle2.isMonster2Dead()) {
      battle2.simulateRound();
    }

    assertTrue(battle2.isMonster1Dead(), "Test 2, Chikapu did not faint.");
    assertEquals(battle2.getMonster1HP(), -10, "Test 2, Chikapu's HP does not match.");
    assertEquals(battle2.getMonster2HP(), 170, "Test 2, Zarichard's HP does not match.");
  }
}
