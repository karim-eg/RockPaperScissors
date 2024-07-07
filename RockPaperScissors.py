"""
    Made For Fun By Karim Abdallah, Android Engineer.
    contact: karim@kotect.com
    website: https://kotect.com
"""
import time
import random


CHOICES = {
    "1": "🪨",
    "2": "📃",
    "3": "✂️"
}

WINNING_COMBOS = {
    "🪨": "✂️",
    "📃": "🪨",
    "✂️": "📃"
}



# Main Game Loop
def play_game():
    game_running = True
    print("====================================")
    print("        Rock Paper Scissors")
    print("====================================\n")

    while game_running:
        for key, value in CHOICES.items():
            print(f"{key}) {value}")

        player_choice = input(">> Pick a number: ")
        player = CHOICES.get(player_choice, None)

        if not player:
            print("Invalid choice, please pick a number between 1 and 3.\n")
            continue

        print(f"> You Chose {player}, It's The CPU's Turn Now.\n")
        time.sleep(1)

        computer = CHOICES[str(random.randint(1, 3))]

        if player == computer:
            print(f"> It's a Tie! 🙌, CPU chose: {computer}")
        elif WINNING_COMBOS[player] == computer:
            print(f"> You Won! 🥇, CPU chose: {computer}")
        else:
            print(f"You Lost ❌, CPU chose: {computer}")


        play_again = input(">> Want to play again? (y/n): ").strip().lower()
        if play_again == "n":
            print("\n====================================")
            print("   That's It, Thanks For Playing!")
            print("====================================\n")
            game_running = False
        else:
            print("\n====================================")
            print("        LET'S PLAY AGAIN!")
            print("====================================\n")


if __name__ == "__main__":
    play_game()
