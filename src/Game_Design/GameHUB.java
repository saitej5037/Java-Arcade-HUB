package Game_Design;
import java.util.*;
public class GameHUB
{
    static Scanner sc =new Scanner(System.in);
    public int choice;

    private static void spacer()
    {
        System.out.println();
    }

    private static void divider()
    {
        BotEffects.printLine(colours.YELLOW + "==================================================" + colours.RESET);
    }

    private static void titleScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        BotEffects.printBlock(colours.CYAN + colours.BOLD
            + "  _______  _______  __   __  _______    __   __  __   __  _______ \n"
            + " |       ||   _   ||  |_|  ||       |  |  | |  ||  | |  ||  _    |\n"
            + " |    ___||  |_|  ||       ||    ___|  |  |_|  ||  | |  || |_|   |\n"
            + " |   | __ |       ||       ||   |___   |       ||  |_|  ||       |\n"
            + " |   ||  ||       ||       ||    ___|  |       ||       ||  _   | \n"
            + " |   |_| ||   _   || ||_|| ||   |___   |   _   ||       || |_|   |\n"
            + " |_______||__| |__||_|   |_||_______|  |__| |__||_______||_______|"
            + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Arcade nights, anime duels, and one more run." + colours.RESET);
        divider();
    }

    private static void gameMenu()
    {
        spacer();
        BotEffects.typeLine(colours.BLUE + colours.BOLD + "Choose Your Arena" + colours.RESET);
        BotEffects.printLine(colours.GREEN + "1. Rock Paper Scissors" + colours.RESET + "  - quick mind games");
        BotEffects.printLine(colours.RED + "2. RPG Battle" + colours.RESET + "           - hero vs challenger");
        divider();
        BotEffects.printPrompt("Enter your choice: ");
    }

    private static boolean promptYesNo(String message)
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

    public static void main(String[] args)
    {
        GameHUB player = new GameHUB();
        boolean playAgain=true;
        while(playAgain)
        {
            titleScreen();
            while(true)
            {
                gameMenu();
                try
                {
                    player.choice=Integer.parseInt(sc.nextLine());
                    if(player.choice<1 || player.choice>2)
                    {
                        BotEffects.typeLine(colours.RED + "Choose 1 or 2 to enter a game." + colours.RESET);
                        continue;
                    }
                    break;
                }
                catch(NumberFormatException e)
                {
                    BotEffects.typeLine(colours.RED + "Enter a number from the menu." + colours.RESET);
                    continue;
                }
            }
            if(player.choice==1)
            {
                RPSgame.sc=sc;
                RPSgame rpsGame=new RPSgame();
                rpsGame.startRPSgame();
            }
            else if(player.choice==2)
            {
                boolean playAgain1=true;
                while (playAgain1) 
                {
                    RPGfight fight=new RPGfight();
                    RPGcharSelection player1 = fight.playerCreation();
                    RPGcharSelection bot = fight.botCreation();
                    fight.battle(player1, bot);
                    spacer();
                    playAgain1=promptYesNo("Would you like another RPG battle? (yes/no): ");
                }
                BotEffects.typeLine(colours.BLUE + "Leaving the arena..." + colours.RESET);
            }
            spacer();
            playAgain=promptYesNo("Would you like to visit another game? (yes/no): ");
        }
        divider();
        BotEffects.typeLine(colours.BLUE + colours.BOLD + "Thanks for playing. See you on the next run." + colours.RESET);
    }
}
