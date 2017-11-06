package labo4;

public class PressAgent implements VetoFollower
{
    @Override
    public boolean checkVeto(String message)
    {
        if (Util.contains(message, Util.TROLL_DICTIONNARY1) || Util.contains(message, Util.TROLL_DICTIONNARY2))
            return false;
        else
            return true;
    }
}