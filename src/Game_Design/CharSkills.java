package Game_Design;
public class CharSkills
{
    // String skill;
    // String ultimate;
    public static String skillSel(String characterClass, String character)
    {
        if(characterClass.equalsIgnoreCase("warrior"))
        {
            if(character.equalsIgnoreCase("gojo")) return "HOLLOW PURPLE";
        if(character.equalsIgnoreCase("sukuna")) return "WORLD CUTTING SLASH";
            if(character.equalsIgnoreCase("goku")) return "ULTRA INSTINCT";
            if(character.equalsIgnoreCase("naruto")) return "MULTI-SHADOW CLONE JUTSU";
            if(character.equalsIgnoreCase("luffy")) return "RED ROC";
        }
        else if(characterClass.equalsIgnoreCase("mage"))
        {
            if(character.equalsIgnoreCase("megumin")) return "FIRE BALL";
            if(character.equalsIgnoreCase("ainz ooal gown")) return "GRASP HEART";
            if(character.equalsIgnoreCase("rimuru")) return "GLUTTONY";
            if(character.equalsIgnoreCase("anos voldigoad")) return "HELLER";
            if(character.equalsIgnoreCase("frieren")) return "ZOLTRAAK";
        }
        else if(characterClass.equalsIgnoreCase("assassin"))
        {
            if(character.equalsIgnoreCase("levi ackerman")) return "SPIRAL SLASH";
            if(character.equalsIgnoreCase("killua")) return "THUNDERBOLT";
            if(character.equalsIgnoreCase("kakashi")) return "CHIDORI";
            if(character.equalsIgnoreCase("itachi uchiha")) return "FIREBALL JUTSU";
            if(character.equalsIgnoreCase("akame")) return "MURASAME STRIKE";
        }
        else if(characterClass.equalsIgnoreCase("politician"))
        {
            if(character.equalsIgnoreCase("trump")) return "TWEET";
            if(character.equalsIgnoreCase("modi")) return "AGNI";
            if(character.equalsIgnoreCase("putin")) return "ZICRON STRIKE";
            if(character.equalsIgnoreCase("kim mama")) return "BALLISTIC MISSILE";
            if(character.equalsIgnoreCase("xi jinping")) return "CARRIER KILLER";
        }
        return "Unknown";
    }

    public static String ultimateSel(String characterClass, String character)
    {
        if(characterClass.equalsIgnoreCase("warrior"))
        {
            if(character.equalsIgnoreCase("gojo")) return "UNLIMITED VOID";
            if(character.equalsIgnoreCase("sukuna")) return "MALEVOLENT SHRINE";
            if(character.equalsIgnoreCase("goku")) return "KAMEHAMEHA";
            if(character.equalsIgnoreCase("naruto")) return "RASENGAN";
            if(character.equalsIgnoreCase("luffy")) return "BAJRANG GUN";
        }
        else if(characterClass.equalsIgnoreCase("mage"))
        {
            if(character.equalsIgnoreCase("megumin")) return "EXPLOSION";
            if(character.equalsIgnoreCase("ainz ooal gown")) return "ALL LIFE IS DEATH";
            if(character.equalsIgnoreCase("rimuru")) return "AZATHOTH";
            if(character.equalsIgnoreCase("anos voldigoad")) return "VENUZDONOA";
            if(character.equalsIgnoreCase("frieren")) return "DOOM";
        }
        else if(characterClass.equalsIgnoreCase("assassin"))
        {
            if(character.equalsIgnoreCase("levi ackerman")) return "OMNI-DIRECTIONAL ASSAULT";
            if(character.equalsIgnoreCase("killua")) return "GODSPEED";
            if(character.equalsIgnoreCase("kakashi")) return "KAMUI";
            if(character.equalsIgnoreCase("itachi uchiha")) return "TSUKUYOMI";
            if(character.equalsIgnoreCase("akame")) return "ICHIZAN HISSATSU";
        }
        else if(characterClass.equalsIgnoreCase("politician"))
        {
            if(character.equalsIgnoreCase("trump")) return "ATOM BOMB";
            if(character.equalsIgnoreCase("modi")) return "ATOM BOMB";
            if(character.equalsIgnoreCase("putin")) return "ATOM BOMB";
            if(character.equalsIgnoreCase("kim mama")) return "ATOM BOMB";
            if(character.equalsIgnoreCase("xi jinping")) return "HYDROGEN BOMB";
        }
        return "Unknown";
    }

}