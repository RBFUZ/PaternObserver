package labo4.followers;

import labo4.Util;

/*
 * Journal syst�me. Affiche dans la console le message en question. Utilisez-le
 * pour voir si les messages sont produits comme pr�vu par les vedettes.
 */
public class MessageLog implements Follower
{

    public void update(String name, String message)
    {
        System.out.println(Util.personnalize(name, message));
    }
}