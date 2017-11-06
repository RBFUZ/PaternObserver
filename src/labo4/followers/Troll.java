package labo4.followers;

import labo4.Labo4Main;
import labo4.Util;
import labo4.ui.MessageView;

/**
 * Fan qui représente un Troll
 */
public class Troll implements Follower
{
    protected MessageView viewport;
    private String name;
    private int numeroDictionnaire;

    /**
     * Constructeur de confort qui initialise une nouvelle fenêtre avec un
     * message personnalisé
     * 
     * @param ui
     * @param n
     */
    public Troll(Labo4Main ui, String n, int num)
    {
        name = n;
        viewport = new MessageView(ui, name + " news feed");
        numeroDictionnaire = num;
    }

    @Override
    public void update(String name, String message)
    {
        if (numeroDictionnaire == 1)
        {
            if (Util.contains(message, Util.TROLL_DICTIONNARY1))
                viewport.appendMessage(Util.personnalize(name, message) + "\n" + Util.TROLL_REPLY1);
        }
        else if (numeroDictionnaire == 2)
        {
            if (Util.contains(message, Util.TROLL_DICTIONNARY2))
            viewport.appendMessage(Util.personnalize(name, message) + "\n" + Util.TROLL_REPLY2);
        }
    }
}