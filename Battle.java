public class Battle {
    
    // YOUR CODE GOES HERE

	public static void main(String[] args) {
		String chikapuName = "Chikapu";
		float chikapuAttack = 38.5f;
		float chikapuDefense = 20.0f;
		float chikapuHP = 200f;
		
		String zarichardName = "Zarichard";
		float zarichardAttack = 25f;
		float zarichardDefense = 12.5f;
		float zarichardHP = 200f;

		Battle battle = new Battle(chikapuName, chikapuAttack, chikapuDefense, chikapuHP, zarichardName, zarichardAttack, zarichardDefense, zarichardHP);
		
		while (!battle.isMonster1Dead() && !battle.isMonster2Dead()) {
			battle.simulateRound();
		}
		
		if (battle.isMonster1Dead()) {
			System.out.printf("\n%s has fainted!\n", battle.getMonster1Name());
		} else {
			System.out.printf("\n%s has fainted!\n", battle.getMonster2Name());
		}
	}
}
