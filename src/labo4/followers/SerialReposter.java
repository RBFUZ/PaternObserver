package labo4.followers;

import labo4.Labo4Main;
import labo4.Util;
import labo4.ui.MessageView;

/**
 * Représente un fan
 */
public class SerialReposter extends Reposter implements Follower
{
    /**
     * Constructeur de confort qui initialise une nouvelle fenêtre avec un
     * message personnalisé
     * 
     * @param ui
     * @param n
     */
    public SerialReposter(Labo4Main ui, String n)
    {
        super(ui, n);
    }

    /**
     * Affiche le message dans la fenêtre graphique
     */
    @Override
    public void update(String name, String message)
    {
        viewport.appendMessage(Util.personnalize(name, message));
    }
}