package Game_Design;
import java.util.*;
public class Escape_Room
{
    static Scanner sc=new Scanner(System.in);
    boolean haskey=false;
    boolean dooropened=false;

    boolean drawerOpened =false;
    boolean foundCode = false;
    boolean laptopOpen = false;
    boolean laptopUnlocked = false;
    boolean bagOpened = false;
    boolean foundFlashlight = false;


    static String cmd;
    public void startgame()
    {
        System.out.println("RULES of the game: You will wake up in a room and inspect the room. You will have five commands (five chances), give a command todo the specific action. Like inspecting the room, opening the drawer, and etc.");
        System.out.println("You wake up in a locked room");
        gameloop();

    }
    public void gameloop()
    {
        Random r=new Random();
        int x = r.nextInt(5);
        int chance=0;
        int life=5;
        while(true)
        {
            if(chance > life)
            {
                System.out.println("You used up all your chances");
                return;
            }
            int y=-1;
            System.out.print("Enter command : ");
            cmd=sc.nextLine();
            chance++;
            if(chance==3 || chance==6)
            {
                y=r.nextInt(2);
                x=r.nextInt();
            }
            if(cmd.equalsIgnoreCase("inspect"))
            {
                inspectroom();
            }
            else if(cmd.equalsIgnoreCase("open drawer") || cmd.equalsIgnoreCase("check drawer"))
            {
                if(x==0)
                {
                    if(y==0)
                    {
                        System.out.println("The key dissapeard. You get an extra life as a bonus");
                        life++;
                        continue;
                    }
                    System.out.println("you opened the drawer and found a key :)");
                    haskey=true;
                }
                else
                {
                    System.out.println("you opened the drawer and found a book. The book is about "+colours.RED+"OOPS IN JAVA "+colours.RESET);
                    System.out.println("Do you like to read the book? You might find some clues.");
                    String b=sc.nextLine();
                    if(b.equalsIgnoreCase("yes"))
                    {
                        System.out.println("Who is your favorite JAVA trainer?");
                        String c=sc.next();
                        if(c.equalsIgnoreCase("charan"))
                        {
                            System.out.print("ASCII value of 'c' and 'f' ");
                        }
                        else
                        {
                            System.out.println("Wrong Answer ❌");
                        }
                        System.out.println("You can read it after you escaped the room.");
                    }
                    else
                    {
                        System.out.println("You missed the chance to find the laptop password");
                    }
                }
                drawerOpened=true;
            }
            else if(cmd.equalsIgnoreCase("open laptop"))
            {
                if(x==1)
                {
                    System.out.println("you opened the laptop, please enter the password. Five digit pin ");
                    String b=sc.nextLine();
                    if(b.equals("99100"))
                    {
                        System.out.println("you unlocked the laptop. ");
                        laptopUnlocked=true;
                    }
                    else
                    {
                        System.out.println("Incorrect password ❌ ");
                    }
                    if(laptopUnlocked)
                    {
                        if(y==0)
                        {
                            System.out.println("The key dissapeard. You get an extra life as a bonus");
                            life++;
                            continue;
                        }
                        System.out.println("you opened found an encryptedkey for the Door🚪 😁");
                        haskey=true;
                    }
                }
                else
                {
                    System.out.println("you opened the laptop, please enter the password. Five digit pin ");
                    String b=sc.nextLine();
                    if(b.equals("99100"))
                    {
                        System.out.println("you unlocked the laptop. Congratulations you earned a life");
                        laptopUnlocked=true;
                        life++;
                    }
                    else
                    {
                        System.out.println("Incorrect password ❌ ");
                    }
                }
                laptopOpen=true;
            }
            else if(cmd.equalsIgnoreCase("painting")) // needs work here
            {
                if(x==2)
                {
                    if(y==0)
                    {
                        System.out.println("The key dissapeard. You get an extra life as a bonus");
                        life++;
                        continue;
                    }

                    System.out.println("you found a key :)");
                    haskey=true;
                }
                else
                {
                    while(true)
                    {
                        System.out.println("Check the painting \ncmds: \n* move painting\n* look behind painting\n* clean painting ");
                        String b=sc.nextLine();
                        int re=r.nextInt(3);
                        if(b.equalsIgnoreCase("move painting"))
                        {
                            if(re==0 || re ==1)
                            {
                                System.out.println("You moved the painting and found a code carved into the wall\n *99100*");
                            }
                            else
                            {
                                System.out.println("You moved the painting and found Nothing");
                            }
                        }
                        else if(b.equalsIgnoreCase("look behind painting"))
                        {
                            if(re==0 || re ==1)
                            {
                                if(x==3)
                                {
                                System.out.println("Check under the table");
                                }
                                else
                                {
                                    System.out.println("There is nothing on the back");
                                }
                            }
                            else
                            {
                                System.out.println("There is nothing on the back");
                            }                    
                        }
                    }
                }
                drawerOpened=true;
            }
            if(haskey)
            {
                return;
            }
        }
    }
    public void inspectroom()
    {
        while(true)
        {
            System.out.println("Infront of you there is a painting next to that there is a table with a laptop on it.Under the table there is a suspicious bag. Right to the painting there is a switch board.");
            System.out.println("Check your " +colours.RED+" Right \nleft  \nstop inspection or exit"+colours.RESET);
            cmd=sc.nextLine();
            if(cmd.equalsIgnoreCase("right"))
            {
                System.out.println("Here you have ");
                System.out.println("Check your" +colours.RED+" Left "+colours.RESET);
                cmd=sc.nextLine();
            }
            else if(cmd.equalsIgnoreCase("left"))
            {
                System.out.println("Here you can see ");
            }
            else if(cmd.equalsIgnoreCase("Stop inspection") || cmd.equalsIgnoreCase("exit"))
            {
                return;
            }
            else 
            {
                System.out.println("Invalid Command ");
            }
        }
    }
}