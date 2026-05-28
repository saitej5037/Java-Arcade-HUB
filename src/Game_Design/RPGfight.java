package Game_Design;
import java.util.*;

public class RPGfight
{
    static Scanner sc=new Scanner(System.in);
    String play_skill;
    String bot_skill;
    String play_ultimate;
    String bot_ultimate;

    int x;
    String cmd;
    int dmg;
    int gauge;
    int botGauge;
    boolean botdead;
    boolean playerdead;

    private void divider()
    {
        BotEffects.printLine(colours.YELLOW + "==================================================" + colours.RESET);
    }

    private void dramaticPause(long millis)
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

    private void showBattleIntro(RPGcharSelection player1, RPGcharSelection bot)
    {
        System.out.println();
        divider();
        BotEffects.typeLine(colours.BOLD + colours.RED + "BATTLE START" + colours.RESET);
        divider();
        BotEffects.typeLine(colours.GREEN + player1.getChar() + colours.RESET + " steps into the arena.");
        BotEffects.typeLine(colours.RED + bot.getChar() + colours.RESET + " answers the challenge.");
        BotEffects.typeLine(colours.CYAN + "Steel rises. Mana hums. The crowd goes silent." + colours.RESET);
        divider();
        dramaticPause(350);
    }

    private void showHud(RPGcharSelection player1, RPGcharSelection bot)
    {
        divider();
        BotEffects.printLine(colours.BOLD + "PLAYER : " + colours.GREEN + player1.getChar() + colours.RESET
            + "   HP " + player1.getHP() + "   Gauge " + gauge);
        BotEffects.printLine(colours.BOLD + "ENEMY  : " + colours.RED + bot.getChar() + colours.RESET
            + "   HP " + bot.getHP() + "   Gauge " + botGauge);
        divider();
    }

    private void showActionBanner(String actor, String action, String accent)
    {
        if(actor.equalsIgnoreCase("Enemy"))
        {
            BotEffects.typeLine(accent + colours.BOLD + actor + " -> " + action + colours.RESET);
        }
        else
        {
            BotEffects.typeLine(accent + colours.BOLD + actor + " -> " + action + colours.RESET);
        }
    }

    private void showUltimateBanner(String actor, String move, String accent)
    {
        divider();
        if(actor.equalsIgnoreCase("Enemy"))
        {
            BotEffects.typeLine(accent + colours.BOLD + actor + " unleashes " + move + colours.RESET);
            BotEffects.typeLine(accent + "The battlefield shakes..." + colours.RESET);
        }
        else
        {
            BotEffects.typeLine(accent + colours.BOLD + actor + " unleashes " + move + colours.RESET);
            BotEffects.typeLine(accent + "The battlefield shakes..." + colours.RESET);
        }
        divider();
        dramaticPause(450);
    }

    public RPGcharSelection botCreation()
    {
        RPGcharSelection bot=new RPGcharSelection();
        bot.botclassSel();
            
        bot_skill = CharSkills.skillSel(bot.getCharClass(), bot.getChar());
        bot_ultimate = CharSkills.ultimateSel(bot.getCharClass(), bot.getChar());
            
        bot.displayBOTStats();
        BotEffects.typeLine(colours.RED + "Bot Skill    : " + bot_skill + colours.RESET);
        BotEffects.typeLine(colours.RED + "Bot Ultimate : " + bot_ultimate + colours.RESET);

        BotEffects.typeLine(colours.CYAN + "The challenger has entered the arena." + colours.RESET);
        System.out.println();
        return bot;
    }
    public RPGcharSelection playerCreation()
    {
        RPGcharSelection player1=new RPGcharSelection();
        player1.mainplay();

        play_skill = CharSkills.skillSel(player1.getCharClass(), player1.getChar());
        play_ultimate = CharSkills.ultimateSel(player1.getCharClass(),  player1.getChar());

        player1.displayStats();
        BotEffects.typeLine(colours.GREEN + "Your Skill    : " + play_skill + colours.RESET);
        BotEffects.typeLine(colours.GREEN + "Your Ultimate : " + play_ultimate + colours.RESET);

        BotEffects.typeLine(colours.CYAN + "Your champion is ready." + colours.RESET);
        System.out.println();
        return player1;
    }
    
    public void battle(RPGcharSelection player1, RPGcharSelection bot)
    {
        gauge=0;
        botGauge=0;
        playerdead=false;
        botdead=false;
        Random r=new Random();
        showBattleIntro(player1, bot);
        while (true)
        {
            showHud(player1, bot);
            BotEffects.typeLine(colours.YELLOW+"Commands : attack | skill | ult | exit"+colours.RESET);
            BotEffects.printPrompt("Your move: ");
            cmd=sc.nextLine();
            if(cmd.equalsIgnoreCase("attack"))
            {
                gauge++;
                dmg = player1.getAP()-bot.getDP();
                showActionBanner("You", "Normal Attack", colours.GREEN);
                if(dmg<=0)
                {
                    BotEffects.typeLine(colours.CYAN + "Enemy defense absorbs most of the hit. You still deal 5 damage." + colours.RESET);
                    bot.takedmg(5);
                    BotEffects.printLine("Enemy HP : "+bot.getHP());
                }
                else
                {
                    BotEffects.typeLine(colours.GREEN + "Direct hit for " + dmg + " damage." + colours.RESET);
                    bot.takedmg(dmg);
                    BotEffects.printLine("Enemy HP : "+bot.getHP());
                }
            }
            else if(cmd.equalsIgnoreCase("skill"))
            {
                if(gauge>=2)
                {
                    showActionBanner("You", play_skill, colours.BLUE);
                    dmg = (int)(player1.getAP()*1.5)-bot.getDP();
                    gauge++;
                    if(dmg<=0)
                    {
                        BotEffects.typeLine(colours.CYAN + "The technique lands through guard for 10 damage." + colours.RESET);
                        bot.takedmg(10);
                        BotEffects.printLine("Enemy HP : "+bot.getHP());
                    }
                    else
                    {
                        BotEffects.typeLine(colours.GREEN + "Skill crushes the target for " + dmg + " damage." + colours.RESET);
                        bot.takedmg(dmg);
                        BotEffects.printLine("Enemy HP : "+bot.getHP());
                    }
                }
                else 
                {
                    BotEffects.typeLine(colours.RED + "Gauge too low: " + gauge + ". The opening slips away." + colours.RESET);
                }
                
            }
            else if(cmd.equalsIgnoreCase("ult"))
            {
                if(gauge>=3)
                {
                    showUltimateBanner("You", play_ultimate, colours.PURPLE);
                    dmg = (int)(player1.getAP()*2)-bot.getDP();
                    gauge=0;
                    if(dmg<=0)
                    {
                        BotEffects.typeLine(colours.CYAN + "Even through full defense, the ultimate forces 15 damage." + colours.RESET);
                        bot.takedmg(15);
                        BotEffects.printLine("Enemy HP : "+bot.getHP());
                    }
                    else
                    {
                        BotEffects.typeLine(colours.GREEN + "Ultimate tears through the arena for " + dmg + " damage." + colours.RESET);
                        bot.takedmg(dmg);
                        BotEffects.printLine("Enemy HP : "+bot.getHP());
                    }
                }
                else 
                {
                    BotEffects.typeLine(colours.RED + "Gauge too low: " + gauge + ". Your ultimate fizzles before release." + colours.RESET);
                }
                
            }
            else if(cmd.equalsIgnoreCase("exit"))
            {
                BotEffects.typeLine(colours.BLUE + "You step out of the arena." + colours.RESET);
                return;
            }
            else 
            {
                BotEffects.typeLine(colours.RED + "Unknown command. Use attack, skill, ult, or exit." + colours.RESET);
                continue;
            }
            if(bot.getHP()<=0)
            {
                botdead=true;
                result();
                return;
            }
            dramaticPause(300);
            BotEffects.thinking();
            BotEffects.typeLine(colours.RED + "The enemy surges forward..." + colours.RESET);
            if(botGauge<2)
            {
                showActionBanner("Enemy", "Normal Attack", colours.RED);
                botGauge++;
                dmg = bot.getAP()-player1.getDP();
                if(dmg<=0)
                {
                    BotEffects.typeLine(colours.CYAN + "You hold the line and take only 5 damage." + colours.RESET);
                    player1.takedmg(5);
                    BotEffects.printLine("Your HP : "+player1.getHP());
                }
                else
                {
                    BotEffects.typeLine(colours.RED + "You take " + dmg + " damage." + colours.RESET);
                    player1.takedmg(dmg);
                    BotEffects.printLine("Your HP : "+player1.getHP());
                }
            }
            else if(botGauge>=2 && botGauge<3)
            {
                x=r.nextInt(2)+1;
                if(x==2)
                {
                    showActionBanner("Enemy", bot_skill, colours.RED);
                    dmg = (int)(bot.getAP()*1.5)-player1.getDP();
                    botGauge++;
                    if(dmg<=0)
                    {
                        BotEffects.typeLine(colours.CYAN + "You weather the technique and take 10 damage." + colours.RESET);
                        player1.takedmg(10);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }
                    else
                    {
                        BotEffects.typeLine(colours.RED + "The skill lands for " + dmg + " damage." + colours.RESET);
                        player1.takedmg(dmg);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }
                }
                else
                {
                    showActionBanner("Enemy", "Normal Attack", colours.RED);
                    botGauge++;
                    dmg = bot.getAP()-player1.getDP();
                    if(dmg<=0)
                    {
                        BotEffects.typeLine(colours.CYAN + "You block most of the impact and take 5 damage." + colours.RESET);
                        player1.takedmg(5);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }
                    else
                    {
                        BotEffects.typeLine(colours.RED + "You take " + dmg + " damage." + colours.RESET);
                        player1.takedmg(dmg);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }   
                }
            }
            else if(botGauge>=3)
            {
                x=r.nextInt(2)+1;
                if(x==2)
                {
                    showActionBanner("Enemy", bot_skill, colours.RED);
                    dmg = (int)(bot.getAP()*1.5)-player1.getDP();
                    botGauge++;
                    if(dmg<=0)
                    {
                        BotEffects.typeLine(colours.CYAN + "You brace and take only 10 damage." + colours.RESET);
                        player1.takedmg(10);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }
                    else
                    {
                        BotEffects.typeLine(colours.RED + "The enemy skill hits for " + dmg + " damage." + colours.RESET);
                        player1.takedmg(dmg);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }
                }
                else
                {
                    showUltimateBanner("Enemy", bot_ultimate, colours.RED);
                    dmg = (int)(bot.getAP()*2)-player1.getDP();
                    botGauge=0;
                    if(dmg<=0)
                    {
                        BotEffects.typeLine(colours.CYAN + "Your guard cracks, but you limit it to 15 damage." + colours.RESET);
                        player1.takedmg(15);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }
                    else
                    {
                        BotEffects.typeLine(colours.RED + "Ultimate strike hits for " + dmg + " damage." + colours.RESET);
                        player1.takedmg(dmg);
                        BotEffects.printLine("Your HP : "+player1.getHP());
                    }
                }
            }
            if(player1.getHP()<=0)
            {
                playerdead=true;
                result();
                return;
            }
        }
    }
    public  void result()
    {
        divider();
        if(botdead)
        {
            BotEffects.typeLine(colours.GREEN + colours.BOLD + "VICTORY" + colours.RESET);
            BotEffects.typeLine(colours.CYAN + "The arena erupts as your fighter stands tall." + colours.RESET);
        }
        else if(playerdead)
        {
            BotEffects.typeLine(colours.RED + colours.BOLD + "DEFEAT" + colours.RESET);
            BotEffects.typeLine(colours.CYAN + "Dust settles. Your rival owns the field this time." + colours.RESET);
        }
        divider();
    }
}
