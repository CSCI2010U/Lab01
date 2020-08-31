public class Lab01 {
	public static void main(String[] args) {
		// part 1
		System.out.println("*** Part 1 ***");
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

		if (battle.isMonster1Dead()) {
			System.out.printf("\n%s has fainted!\n", battle.getMonster1Name());
		} else {
			System.out.printf("\n%s has fainted!\n", battle.getMonster2Name());
		}

		// part 2
		System.out.println("\n*** Part 2 ***");
		int numIterations = 10;
		System.out.printf("e^1 = %.8f\n", TaylorSeries.approximateExp(1, numIterations));
		System.out.printf("e^2 = %.8f\n", TaylorSeries.approximateExp(2, numIterations));
	}
}