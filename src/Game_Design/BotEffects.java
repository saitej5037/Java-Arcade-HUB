package Game_Design;

public class BotEffects
{
    private static final int TERMINAL_WIDTH = 80;
    private static final long THINKING_DOT_DELAY = 260;
    private static final long WORD_DELAY = 120;

    private BotEffects()
    {
    }

    private static void sleep(long millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    private static String removeColours(String message)
    {
        return message.replaceAll("\\u001B\\[[;\\d]*m", "");
    }

    private static String centerPadding(String message)
    {
        int visibleLength = removeColours(message).length();
        int padding = (TERMINAL_WIDTH-visibleLength)/2;
        if(padding<0)
        {
            padding=0;
        }
        return " ".repeat(padding);
    }

    public static void printLine(String message)
    {
        System.out.println(centerPadding(message) + message);
    }

    public static void printBlock(String block)
    {
        String[] lines = block.split("\n");
        for(String line : lines)
        {
            printLine(line);
        }
    }

    public static void printPrompt(String message)
    {
        System.out.print(centerPadding(message) + message);
    }

    public static void thinking()
    {
        String message = colours.YELLOW + "Bot is thinking";
        System.out.print(centerPadding(removeColours(message) + "...") + message);
        for(int i=0; i<3; i++)
        {
            sleep(THINKING_DOT_DELAY);
            System.out.print(".");
            System.out.flush();
        }
        System.out.println(colours.RESET);
    }

    public static void typeLine(String message)
    {
        System.out.print(centerPadding(message));
        String[] words = message.split(" ");
        for(int i=0; i<words.length; i++)
        {
            System.out.print(words[i]);
            if(i<words.length-1)
            {
                System.out.print(" ");
            }
            System.out.flush();
            sleep(WORD_DELAY);
        }
        System.out.println();
    }
}
