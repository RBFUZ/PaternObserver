package labo4;

import java.util.ArrayList;

import labo4.followers.Follower;

public abstract class Sujet
{
    private ArrayList<Follower> listObs;

    /**
     * Constructeur par défaut
     */
    public Sujet()
    {
        listObs = new ArrayList<Follower>();
    }

    /**
     * Ajout d'un observateur à la liste
     * 
     * @param f
     */
    public void attach(Follower f)
    {
        listObs.add(f);
    }

    /**
     * Notifie l'ensemble des observateurs
     * 
     * @param ns
     */
    public void notifyFollowers(String name, String ns)
    {
        for (int i = 0; i < listObs.size(); i++)
            listObs.get(i).update(name, ns);
    }
}