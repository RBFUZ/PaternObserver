package labo4;

import java.util.ArrayList;

import labo4.followers.Follower;

public abstract class Sujet
{
    private ArrayList<Follower> listObs;
    private ArrayList<VetoFollower> listVeto;

    /**
     * Constructeur par défaut
     */
    public Sujet()
    {
        listObs = new ArrayList<Follower>();
        listVeto = new ArrayList<VetoFollower>();
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

    public void attachVeto(VetoFollower v)
    {
        listVeto.add(v);
    }

    /**
     * Notifie l'ensemble des observateurs
     * 
     * @param ns
     */
    public void notifyFollowers(String name, String ns)
    {
        for (Follower f : listObs)
            try
            {
                for (VetoFollower v : listVeto)
                    if (!v.checkVeto(ns))
                        throw new Exception();
                f.update(name, ns);
            }
            catch (Exception e)
            {
            }
    }
}