/*
    Made For Fun By Karim Abdallah, Android Engineer.
    contact: karim@kotect.com
    website: https://kotect.com
*/
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public static void main() throws InterruptedException {
    boolean gameRunning = true;

    String[] choicesList = {"\uD83E\uDEA8", "\uD83D\uDCC3", "✂️"};
    Map<String, String> winningCombos = new HashMap<>();
    winningCombos.put("🪨", "✂️");
    winningCombos.put("📃", "🪨");
    winningCombos.put("✂️", "📃");

    System.out.println("""
        ====================================
        |       Rock Paper Scissors!       |
        ====================================
        """.trim());

    while (gameRunning) {
        for (int i = 0; i < choicesList.length; i++) {
            System.out.println(i + 1 + ". " + choicesList[i]);
        }

        System.out.print(">> Pick a number: ");
        int getInput = Integer.parseInt(System.console().readLine().trim());
        String playerChoice = Array.getLength(choicesList) >= getInput ? choicesList[getInput - 1] : null;

        if (playerChoice == null) {
            System.out.println("Invalid choice. Please try again.");
            continue;
        }

        System.out.printf("> You Chose %s, It's The CPU's Turn Now.\n\n", playerChoice);
        Thread.sleep(800);

        String cpuChoice = choicesList[(int) Math.floor(Math.random() * choicesList.length)];

        if (playerChoice.equals(cpuChoice)) {
            System.out.printf("> It's a Tie! \uD83D\uDE4C, CPU chose: %s", cpuChoice);

        } else if (winningCombos.get(playerChoice).equals(cpuChoice)) {
            System.out.printf("> You Won! \uD83E\uDD47, CPU chose: %s", cpuChoice);

        } else {
            System.out.printf("You Lost ❌, CPU chose: %s", cpuChoice);
        }

        System.out.print("\n>> Do you want to play again? (y/n): ");
        if (System.console().readLine().equalsIgnoreCase("n")) {
            gameRunning = false;
            System.out.println();
            System.out.println("""
                ====================================
                |  That's It, Thanks For Playing!  |
                ====================================
                """.trim());
            System.out.println();

        } else {
            System.out.println();
            System.out.println("""
                ====================================
                |        LET'S PLAY AGAIN!         |
                ====================================
                """.trim());
            System.out.println();
        }
    }
}