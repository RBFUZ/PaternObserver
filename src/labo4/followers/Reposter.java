package labo4.followers;

import labo4.Labo4Main;
import labo4.Util;
import labo4.ui.MessageView;

public class Reposter implements Follower
{
    protected MessageView viewport;
    private String name;

    /*
     * Un reposter est un fan de la c�l�brit�.
     */
    public Reposter(Labo4Main ui, String n)
    {
        name = n;
        viewport = new MessageView(ui, name + " news feed");
    }

    /*
     * LABO4: code de mise � jour de l'affichage. Un reposter est un fan qui ne
     * fait que r�afficher ce que la vedette a dit dans son propre fil de
     * nouvelles
     */
    public void update(String name, String message)
    {
        // Ajoute tout simplement le message dans la bo�te de texte.
        viewport.appendMessage(Util.personnalize(name, message));
    }
}