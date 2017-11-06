package labo4.followers;

import labo4.Labo4Main;
import labo4.Util;
import labo4.celebrities.SocialMediaCelebrity;
import labo4.ui.MessageView;

/**
 * Représente un fan de type Hater
 */
public class Hater extends SocialMediaCelebrity implements Follower
{
    private Reposter reposter;

    /**
     * Constructeur de confort qui initialise une nouvelle fenêtre avec un
     * message personnalisé
     * 
     * @param ui
     * @param n
     */
    public Hater(Labo4Main ui, String n)
    {
        super(n, 0);
        reposter = new Reposter(ui, n);
    }

    @Override
    public void update(String name, String message)
    {
        changeStatus();
        reposter.getViewport().appendMessage(Util.personnalize(name, status));
    }

    @Override
    public void changeStatus()
    {
        setStatus(Util.getRandomString(Util.HATER_DICTIONNARY));
    }
}