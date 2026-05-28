package Game_Design;
import java.util.*;
public class RPGcharSelection
{
    Random r=new Random();
    static Scanner sc = new Scanner(System.in);
    private int HP;
    private int attackPower;
    private int defensePower;
    private String characterClass;
    private String character;
    
    int choice;
    int botchoice;

    public int getHP()
    {
        return HP;
    }
    public int getAP()
    {
        return attackPower;
    }
    public int getDP()
    {
        return defensePower;
    }
    public String getCharClass()
    {
        return characterClass;
    }
    public String getChar()
    {
        return character;
    }

    private void divider()
    {
        BotEffects.printLine(colours.YELLOW + "--------------------------------------------------" + colours.RESET);
    }

    private void revealFrame(String title)
    {
        System.out.println();
        divider();
        BotEffects.typeLine(colours.BOLD + colours.CYAN + title + colours.RESET);
        divider();
    }

    private String classBanner(String charClass)
    {
        switch(charClass.toLowerCase())
        {
            case "warrior":
                return "  /\\\n /  \\\n |[]|\n/____\\\\";
            case "mage":
                return "   *\n  /|\\\\\n /_|_\\\\\n   |";
            case "assassin":
                return "  /\\\n <  >\n /_/\\\\\n   ||";
            default:
                return " .----.\n | [] |\n |____|\n  /||\\\\";
        }
    }

    private String characterTagline()
    {
        if(this.character.equalsIgnoreCase("Gojo")) return "Infinity stands between you and defeat.";
        if(this.character.equalsIgnoreCase("Sukuna")) return "A king of curses enters the field.";
        if(this.character.equalsIgnoreCase("Goku")) return "Power rises with every heartbeat.";
        if(this.character.equalsIgnoreCase("Naruto")) return "Never backing down.";
        if(this.character.equalsIgnoreCase("Luffy")) return "King of the pirates, ready to fight.";
        if(this.character.equalsIgnoreCase("Megumin")) return "One explosion is all it takes.";
        if(this.character.equalsIgnoreCase("Ainz Ooal Gown")) return "The silence of the undead king.";
        if(this.character.equalsIgnoreCase("Rimuru")) return "Calm, bright, and dangerous.";
        if(this.character.equalsIgnoreCase("Anos Voldigoad")) return "Overwhelming force in human form.";
        if(this.character.equalsIgnoreCase("Frieren")) return "Ancient magic with no wasted motion.";
        if(this.character.equalsIgnoreCase("Levi Ackerman")) return "Precision sharp enough to split air.";
        if(this.character.equalsIgnoreCase("Killua")) return "Lightning moves before thought.";
        if(this.character.equalsIgnoreCase("Kakashi")) return "A copy ninja reads the battlefield.";
        if(this.character.equalsIgnoreCase("Itachi Uchiha")) return "Illusion and control.";
        if(this.character.equalsIgnoreCase("Akame")) return "A silent edge with lethal intent.";
        if(this.character.equalsIgnoreCase("Trump")) return "Loud entrance. Heavy defense.";
        if(this.character.equalsIgnoreCase("Modi")) return "Measured stance. Fiery strike.";
        if(this.character.equalsIgnoreCase("Putin")) return "Cold pressure builds.";
        if(this.character.equalsIgnoreCase("Kim mama")) return "Tension hangs in the air.";
        if(this.character.equalsIgnoreCase("Xi Jinping")) return "Calm posture, dangerous reach.";
        return "A new challenger is ready.";
    }

    private void showSelectionReveal(boolean isBot)
    {
        revealFrame(isBot ? "Bot Challenger Revealed" : "Hero Selected");
        BotEffects.printBlock(colours.PURPLE + classBanner(this.characterClass) + colours.RESET);
        if(isBot)
        {
            BotEffects.typeLine(colours.GREEN + this.character + colours.RESET + "  [" + this.characterClass + "]");
            BotEffects.typeLine(colours.CYAN + characterTagline() + colours.RESET);
        }
        else
        {
            BotEffects.typeLine(colours.GREEN + this.character + colours.RESET + "  [" + this.characterClass + "]");
            BotEffects.typeLine(colours.CYAN + characterTagline() + colours.RESET);
        }
        divider();
    }

    public void chooseClass(String charClass, boolean isplayerORbot)
    {
        this.characterClass=charClass;
        if(isplayerORbot)
        {
            choice=plycharSelction();
        }
        else if(!isplayerORbot)
        {
            choice=botCharSelction();
        }
        switch(charClass.toLowerCase())
        {
            case "warrior":
                chooseCharacter(choice);
                switch (choice)
                {
                    case 1:
                        this.HP=200;
                        this.attackPower=25;
                        this.defensePower=20;
                        break;
                    case 2 :
                        this.HP=250;
                        this.attackPower=30;
                        this.defensePower=10;
                        break;
                    case 3:
                        this.HP=220;
                        this.attackPower=28;
                        this.defensePower=18;
                        break;
                    case 4:
                        this.HP=180;
                        this.attackPower=22;
                        this.defensePower=25;
                        break;
                    case 5:
                        this.HP=210;
                        this.attackPower=27;
                        this.defensePower=17;
                        break;
                }
            break;
            case "mage":
                chooseCharacter(choice);
                switch (choice)
                {
                    case 1:
                        this.HP=150;
                        this.attackPower=35;
                        this.defensePower=15;
                        break;
                    case 2:
                        this.HP=160;
                        this.attackPower=32;
                        this.defensePower=18;
                        break;
                    case 3:                        
                        this.HP=140;
                        this.attackPower=38;
                        this.defensePower=12;
                        break;
                    case 4:                        
                        this.HP=130;
                        this.attackPower=40;
                        this.defensePower=10;
                        break;
                    case 5:                        
                        this.HP=155;
                        this.attackPower=33;
                        this.defensePower=17;
                        break;
                }
            break;
            case "assassin":
                chooseCharacter(choice);
                switch (choice)
                {
                    case 1:
                        this.HP=170;
                        this.attackPower=30;
                        this.defensePower=20;
                       break;
                    case 2:
                        this.HP=160;
                        this.attackPower=28;
                        this.defensePower=22;
                        break;
                    case 3:
                        this.HP=165;
                        this.attackPower=29;
                        this.defensePower=21;
                        break;
                        case 4:
                        this.HP=155;
                        this.attackPower=27;
                        this.defensePower=23;
                        break;
                    case 5:
                        this.HP=160;
                        this.attackPower=31;
                        this.defensePower=19;   
                        break;
                }
            break;
            case "politician":
                chooseCharacter(choice);
                switch(choice)
                {
                    case 1:
                        this.HP=180;
                        this.attackPower=20;
                        this.defensePower=30;
                        break;
                    case 2:
                        this.HP=170;
                        this.attackPower=22;
                        this.defensePower=28;
                        break;
                    case 3:
                        this.HP=175;
                        this.attackPower=25;
                        this.defensePower=25;
                        break;
                    case 4:
                        this.HP=160;
                        this.attackPower=18;
                        this.defensePower=32;
                        break;
                    case 5:
                        this.HP=180;
                        this.attackPower=30;
                        this.defensePower=20;
                        break;
                }
            break;
        }
    }
    public void botclassSel()
    {
        botchoice=r.nextInt(4);
        if(botchoice==0)
        {
            this.characterClass="warrior";
            chooseClass(this.characterClass, false);

        }
        else if (botchoice==1) 
        {
            this.characterClass="mage"; 
            chooseClass(this.characterClass, false);  
        }
        else if(botchoice==2)
        {
            this.characterClass="Assassin";
            chooseClass(this.characterClass, false);
        }
        else if(botchoice==3)
        {
            this.characterClass="politician";
            chooseClass(this.characterClass, false);
        }
    }
    public int plycharSelction()
    {
        while(true)
        {
            revealFrame("Class Selection");
            if(this.characterClass.equalsIgnoreCase("Warrior"))
            {
                BotEffects.printBlock(colours.RED + classBanner("warrior") + colours.RESET);
                BotEffects.typeLine("Choose character 1. Gojo 2. Sukuna 3. Goku 4. Naruto 5. Luffy");
            }
            else if(this.characterClass.equalsIgnoreCase("Mage"))
            {
                BotEffects.printBlock(colours.BLUE + classBanner("mage") + colours.RESET);
                BotEffects.typeLine("Choose character 1. Megumin 2. Ainz Ooal Gown 3. Rimuru 4. Anos Voldigoad 5. Frieren");
            }
            else if(this.characterClass.equalsIgnoreCase("Assassin"))
            {
                BotEffects.printBlock(colours.GREEN + classBanner("assassin") + colours.RESET);
                BotEffects.typeLine("Choose character 1. Levi Ackerman 2. Killua 3. Kakashi 4. Itachi Uchiha 5. Akame");
            }
            else if(this.characterClass.equalsIgnoreCase("Politician"))
            {
                BotEffects.printBlock(colours.YELLOW + classBanner("politician") + colours.RESET);
                BotEffects.typeLine("Choose character 1. Trump 2. Modi 3. Putin 4. Kim mama 5. Xi Jinping");
            }
            try
            {
                BotEffects.printPrompt("Select fighter: ");
                choice=Integer.parseInt(sc.nextLine());
                if(choice<1 || choice>5)
                {
                    BotEffects.typeLine(colours.RED + "Choose a fighter from 1 to 5." + colours.RESET);
                    continue;
                }
                break;
            }
            catch(NumberFormatException e)
            {
                BotEffects.typeLine(colours.RED + "Enter a number for your fighter." + colours.RESET);
                continue;
            }
        }
        return choice;
    }
    public void chooseCharacter(int a)
    {
        if(this.characterClass.equalsIgnoreCase("Warrior"))
        {
            this.character=a==1 ? "Gojo" : a==2 ? "Sukuna" : a==3 ? "Goku" : a==4 ? "Naruto" : a==5 ? "Luffy" : "Unknown";
        }
        else if(this.characterClass.equalsIgnoreCase("Mage"))
        {
            this.character=a==1 ? "Megumin" : a==2 ? "Ainz Ooal Gown" : a==3 ? "Rimuru" : a==4 ? "Anos Voldigoad" : a==5 ? "Frieren" : "Unknown";
        }
        else if(this.characterClass.equalsIgnoreCase("Assassin"))
        {
            this.character=a==1 ? "Levi Ackerman" : a==2 ? "Killua" : a==3 ? "Kakashi" : a==4 ? "Itachi Uchiha" : a==5 ? "Akame" : "Unknown";
        }
        else if(this.characterClass.equalsIgnoreCase("Politician"))
        {
            this.character=a==1 ? "Trump" : a==2 ? "Modi" : a==3? "Putin" : a==4 ? "Kim mama" : a==5 ? "Xi Jinping" : "Unknown";
        }
    }
    public int botCharSelction()
    {
        BotEffects.thinking();
        choice=r.nextInt(5)+1;
        return choice;
    }
    public void displayStats()
    {
        showSelectionReveal(false);
        BotEffects.typeLine(colours.MAGENTA + "Class        : " + colours.BLUE + this.characterClass + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Character    : " + colours.BLUE + this.character + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Hit Points   : " + colours.BLUE + this.HP + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Attack Power : " + colours.BLUE + this.attackPower + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Defense      : " + colours.BLUE + this.defensePower + colours.RESET);
        divider();
    }
    public void displayBOTStats()
    {
        showSelectionReveal(true);
        BotEffects.typeLine(colours.MAGENTA + "Bot Class    : " + colours.BLUE + this.characterClass + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Bot Fighter  : " + colours.BLUE + this.character + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Bot HP       : " + colours.BLUE + this.HP + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Bot Attack   : " + colours.BLUE + this.attackPower + colours.RESET);
        BotEffects.typeLine(colours.MAGENTA + "Bot Defense  : " + colours.BLUE + this.defensePower + colours.RESET);
        divider();
    }
    public void mainplay()
    {
        revealFrame("Choose Your Class");
        BotEffects.typeLine("Warrior    | frontline bruiser");
        BotEffects.typeLine("Mage       | glass cannon");
        BotEffects.typeLine("Assassin   | speed and pressure");
        BotEffects.typeLine("Politician | defense and disruption");
        divider();
        BotEffects.typeLine("Choose your character class ( Warrior / Mage / Assassin / Politician ):");
        while(true)
        {
            try
            {
                BotEffects.printPrompt("Class: ");
                String charClass=sc.nextLine();
                if(charClass.equalsIgnoreCase("Warrior") || charClass.equalsIgnoreCase("Mage") || charClass.equalsIgnoreCase("Assassin") || charClass.equalsIgnoreCase("Politician"))
                {
                    this.chooseClass(charClass, true);
                    break;
                }
                else
                {
                    BotEffects.typeLine(colours.RED + "Choose Warrior, Mage, Assassin, or Politician." + colours.RESET);
                    continue;
                }
            }
            catch(Exception e)
            {
                BotEffects.typeLine(colours.RED + "Please enter a valid class name." + colours.RESET);
                continue;
            }
        }
    }
    
    public void takedmg(int dmg)
    {
        HP-=dmg;
        if(HP<0)
        {
            HP=0;
        }
    }
}
