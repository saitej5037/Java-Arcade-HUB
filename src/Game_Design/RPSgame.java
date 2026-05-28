package Game_Design;
//import Game_Design.colours;
import java.util.*;
public class RPSgame
{
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();          // Random object to generate random moves for the bot
    public static final int ROCK=0;
    public static final int PAPER=1;
    public static final int SCISSORS=2;
    public int difficulty;
    public int pMove;                    // Player's move for the current round
    public int playerScore;             // Player's score for the game
    public int botScore;               // Bot's score for the game

    private void divider()
    {
        BotEffects.printLine(colours.YELLOW + "========================================" + colours.RESET);
    }

    private void showBanner()
    {
        BotEffects.printBlock(colours.CYAN + colours.BOLD
            + "  ____  ____  ____\n"
            + " |  _ \\|  _ \\/ ___|\n"
            + " | |_) | |_) \\___ \\\n"
            + " |  _ <|  __/ ___) |\n"
            + " |_| \\_\\_|   |____/"
            + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Best of three. Read the bot and strike fast." + colours.RESET);
        divider();
    }

    private String moveArt(int move)
    {
        if(move==ROCK)
        {
            return "    _______\n---'   ____)\n      (_____)\n      (_____)\n      (____)\n---.__(___)";
        }
        else if(move==PAPER)
        {
            return "     _______\n---'    ____)____\n           ______)\n          _______)\n         _______)\n---.__________)";
        }
        return "    _______\n---'   ____)____\n          ______)\n       __________)\n      (____)\n---.__(___)";
    }

    private boolean promptYesNo(String message)
    {
        while(true)
        {
            BotEffects.printPrompt(message);
            String input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("yes"))
            {
                return true;
            }
            if(input.equalsIgnoreCase("no"))
            {
                return false;
            }
            BotEffects.typeLine(colours.RED + "Please type yes or no." + colours.RESET);
        }
    }

    public void easyBot()             // Bot will play a random move
    {
        BotEffects.thinking();
        int bot = r.nextInt(3);
        botMove(bot);
    }
    public void mediumBot(int pMove) // Bot will either play winning move or tying move
    {
        BotEffects.thinking();
        int bot;
        if(pMove==ROCK)
        {
            bot=r.nextInt(2)==0 ? ROCK : SCISSORS; // Bot will play Rock or Scissors
        }
        else if(pMove==PAPER)
        {
            bot=r.nextInt(2)==0 ? PAPER : ROCK; // Bot will play Paper or Rock
        }
        else
        {
            bot=r.nextInt(2)==0 ? SCISSORS : PAPER; // Bot will play Scissors or Paper
        }
        botMove(bot);
    }
    public void hardBot(int pMove) // Bot will either play the winning move or the losing move, with equal probability
    {
        BotEffects.thinking();
        int bot;
        if(pMove==ROCK)
        {
            bot=r.nextInt(2)==0 ? PAPER : SCISSORS; // Bot will play paper or Scissors
        }
        else if(pMove==PAPER)
        {
            bot=r.nextInt(2)==0 ? ROCK : SCISSORS; // Bot will play Rock or Scissors
        }
        else
        {
            bot=r.nextInt(2)==0 ? ROCK : PAPER; // Bot will play Rock or Paper
        }
        botMove(bot);
    }
    public String playerMove(int pMove) // Method to display the player's move
    {
        if(pMove==ROCK)
        {
            return "You played 🪨 ROCK";
        }
        else if(pMove==PAPER)
        {
            return "You played 📄 PAPER";
        }
        else
        {
            return "You played ✂️ SCISSORS";
        }
    }
    public void botMove(int bot)      // Method to display the bot's move and determine the winner of the round
    {
        String botmove="";
        if(bot==ROCK)
        {
            botmove="🪨 ROCK";
        }
        else if(bot==PAPER)
        {
            botmove="📄 PAPER";
        }
        else if(bot==SCISSORS)
        {
            botmove="✂️ SCISSORS";
        }
        BotEffects.printBlock(colours.BLUE + moveArt(bot) + colours.RESET);
        BotEffects.typeLine("Bot played: " + botmove);
        BotEffects.typeLine(checkWinner(bot,pMove));
    }
    public String checkWinner(int botMove, int pMove)
    {
        if(botMove==ROCK && pMove==ROCK || botMove==PAPER && pMove==PAPER || botMove==SCISSORS && pMove==SCISSORS)
        {
            return colours.CYAN+"It's a tie!"+colours.RESET;
        }
        else if(botMove==ROCK && pMove==PAPER || botMove==PAPER && pMove==SCISSORS || botMove==SCISSORS && pMove==ROCK)
        {
            playerScore++;
            return colours.GREEN+"You win!"+colours.RESET;
        }
        else
        {
            botScore++;
            return colours.RED+"Bot wins!"+colours.RESET;
        }
    }
    public void startRPSgame()
    {
        boolean playAgain = true;
        while(playAgain)
        {
            this.playerScore=0;
            this.botScore=0;
            showBanner();
            while(true)
            {
                BotEffects.typeLine("Select difficulty level: 1 for Easy, 2 for Medium, 3 for Hard");
                BotEffects.printPrompt("Difficulty: ");
                try
                {
                    this.difficulty=Integer.parseInt(sc.nextLine());
                    if(this.difficulty<1 || this.difficulty>3)
                    {
                        BotEffects.typeLine(colours.RED+"Invalid difficulty level! Please enter 1, 2, or 3."+colours.RESET);
                        continue;
                    }
                    break;
                }
                catch(NumberFormatException e)
                {
                    BotEffects.typeLine(colours.RED+"Invalid difficulty level! Please enter 1, 2, or 3."+colours.RESET);
                    continue;
                }
            }
            int round=1;
            while(round<=3)
            {
                divider();
                BotEffects.typeLine(colours.YELLOW+"Round "+round +" 🎲"+colours.RESET);
                BotEffects.typeLine("Enter your move: 0 for Rock, 1 for Paper, 2 for Scissors");
                BotEffects.printPrompt("Your move: ");
                try
                {
                    this.pMove=Integer.parseInt(sc.nextLine());
                    if(this.pMove<0 || this.pMove>2)
                    {
                        BotEffects.typeLine(colours.RED+"Invalid move! Please enter 0, 1, or 2."+colours.RESET);
                        continue;
                    }
                }
                catch(NumberFormatException e)
                {
                    BotEffects.typeLine(colours.RED+"Invalid move! Please enter 0, 1, or 2."+colours.RESET);
                    continue;
                }
                BotEffects.printBlock(colours.GREEN + moveArt(this.pMove) + colours.RESET);
                BotEffects.typeLine(this.playerMove(this.pMove));
                if(this.difficulty==1)
                {
                    this.easyBot();
                }
                else if(this.difficulty==2)
                {
                    this.mediumBot(this.pMove);
                }
                else
                {
                    this.hardBot(this.pMove);
                }
                round++;
            }
            displayFinalScore();
            playAgain=promptYesNo("Do you want to play again? (yes/no): ");
        }
        BotEffects.typeLine(colours.BLUE+"Thank you for playing :"+colours.RESET);
    }
    public void displayFinalScore()
    {
        divider();
        BotEffects.typeLine(colours.MAGENTA+"Final Score: You "+playerScore+" - Bot "+botScore+colours.RESET);
        if(playerScore>botScore)
        {
            BotEffects.typeLine(colours.GREEN+"Congratulations! You won the game!"+colours.RESET);
        }
        else if(botScore>playerScore)
        {
            BotEffects.typeLine(colours.RED+"Bot wins the game! Better luck next time!"+colours.RESET);
        }
        else
        {
            BotEffects.typeLine(colours.CYAN+"It's a tie!"+colours.RESET);
        }
    }
}
