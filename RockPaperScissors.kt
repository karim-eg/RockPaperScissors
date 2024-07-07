/*
    Made For Fun By Karim Abdallah, Android Engineer.
    contact: karim@kotect.com
    website: https://kotect.com
*/
import java.lang.Thread.sleep

fun main() {
    var gameRunning = true

    val choicesList = arrayOf("\uD83E\uDEA8", "\uD83D\uDCC3", "✂\uFE0F")
    val winningCombos = mapOf("🪨" to "✂️", "📃" to "🪨", "✂️" to "📃")

    println("""
        ====================================
        |       Rock Paper Scissors!       |
        ====================================
    """.trimIndent())

    while (gameRunning) {
        for ((index, choice) in choicesList.withIndex())
            println("${index + 1}. $choice")

        print(">> Pick a number: ")
        val getInput = readln().toInt()
        val playerChoice = choicesList.getOrNull(getInput - 1)

        if (playerChoice == null) {
            println("Invalid choice, please pick a number between 1 and 3.\n")
            continue
        }

        println("> You Chose $playerChoice, It's The CPU's Turn Now.\n")
        sleep(800)

        val cpuChoice = choicesList.random()

        if (playerChoice == cpuChoice) {
            println("> It's a Tie! \uD83D\uDE4C, CPU chose: $cpuChoice")

        } else if (winningCombos[playerChoice] == cpuChoice) {
            println("> You Won! \uD83E\uDD47, CPU chose: $cpuChoice")

        } else {
            println("You Lost ❌, CPU chose: $cpuChoice")
        }

        print(">> Do you want to play again? (y/n): ")
        if (readln().lowercase() == "n") {
            gameRunning = false
            println()
            println("""
                ====================================
                |  That's It, Thanks For Playing!  |
                ====================================
            """.trimIndent())
            println()

        } else {
            println()
            println("""
                ====================================
                |        LET'S PLAY AGAIN!         |
                ====================================
            """.trimIndent())
            println()
        }
    }
}