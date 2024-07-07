/*
   Made For Fun By Karim Abdallah, Android Engineer.
   contact: karim@kotect.com
   website: https://kotect.com
*/
package main

import (
	"bufio"
	"fmt"
	"os"
	"time"
)

func main() {
	var gameRunning = true

	var choicesList = [3]string{"🪨", "📃", "✂️"}
	winningCombos := map[string]string{"🪨": "✂️", "📃": "🪨", "✂️": "📃"}

	fmt.Println("====================================")
	fmt.Println("|       Rock Paper Scissors!       |")
	fmt.Println("====================================")

	for gameRunning {
		for i := 0; i < len(choicesList); i++ {
			fmt.Println(i + 1, ".", choicesList[i])
		}

		fmt.Print(">> Pick a number: ")
		getInput, _ := bufio.NewReader(os.Stdin).ReadString('\n')
		playerChoice := choicesList[(int(getInput[0]) - 49)]

		if playerChoice != "🪨" && playerChoice != "📃" && playerChoice != "✂️" {
			fmt.Println("Invalid choice, please pick a number between 1 and 3.\n")
			return
		}


		fmt.Printf("> You Chose %s, It's The CPU's Turn Now.\n\n", playerChoice)
		time.Sleep(800 * time.Millisecond)

		cpuChoice := choicesList[time.Now().UnixNano() % 3]

		if playerChoice == cpuChoice {
			fmt.Printf("> It's a Tie! 🙌, CPU chose: %s", cpuChoice)

		} else if winningCombos[playerChoice] == cpuChoice {
			fmt.Printf("> You Won! 🥇, CPU chose: %s", cpuChoice)

		} else {
			fmt.Printf("You Lost ❌, CPU chose: %s", cpuChoice)
		}

		fmt.Print("\n>> Do you want to play again? (y/n): ")
		playAgain, _ := bufio.NewReader(os.Stdin).ReadString('\n')
		if playAgain[0] == 'n' {
			gameRunning = false
			fmt.Println()
			fmt.Println("====================================")
			fmt.Println("|  That's It, Thanks For Playing!  |")
			fmt.Println("====================================")
			fmt.Println()

		} else {
			fmt.Println()
			fmt.Println("====================================")
			fmt.Println("|        LET'S PLAY AGAIN!         |")
			fmt.Println("====================================")
			fmt.Println()
		}
	}
}
