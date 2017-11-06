package labo4;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import labo4.celebrities.BroScienceCelebrity;
import labo4.celebrities.DramaticCelebrity;
import labo4.celebrities.PositiveCelebrity;
import labo4.celebrities.SocialMediaCelebrity;
import labo4.followers.*;
import labo4.ui.MessageView;

public class Labo4Main extends JFrame
{
    private static final long serialVersionUID = 1L;
    private JPanel background;

    private ArrayList<MessageView> views = new ArrayList<MessageView>();
    private ArrayList<SocialMediaCelebrity> celebs = new ArrayList<SocialMediaCelebrity>();
    private ArrayList<Reposter> fans = new ArrayList<Reposter>();
    private MessageLog log = new MessageLog();

    // Exercice 4
    private SerialReposter nolife;

    // Exercice 5
    private Fanboy fanboy;
    private Hater hater;

    // Exercice 6
    private Troll troll1;
    private Troll troll2;

    // Exercice 7
    private PressAgent pressAgent;

    /*
     * Initialisation des Celebrities et des Followers. �tablissement des liens
     * entre eux.
     */
    public Labo4Main(String[] args)
    {
        DramaticCelebrity dramaQueen = new DramaticCelebrity("BritneySpears", 2);
        PositiveCelebrity spiritualKing = new PositiveCelebrity("LookWithin", 2);
        BroScienceCelebrity superBro = new BroScienceCelebrity("JohnCena", 2);
        celebs.add(dramaQueen);
        celebs.add(spiritualKing);
        celebs.add(superBro);

        fans.add(new Reposter(this, "BritneyFan"));
        fans.add(new Reposter(this, "SpiritualFan"));
        fans.add(new Reposter(this, "JohnCenaFan"));

        // Exercice 4
        nolife = new SerialReposter(this, "NoLife");

        // Exercice 5
        fanboy = new Fanboy(this, "Fanboy");
        hater = new Hater(this, "Hater");

        // Exercice 6
        troll1 = new Troll(this, "Troll numéro 1", 1);
        troll2 = new Troll(this, "Troll numéro 2", 2);

        // Exercice 7
        pressAgent = new PressAgent();

        // Ajout des observateurs au sujet
        dramaQueen.attach(fans.get(0));
        spiritualKing.attach(fans.get(1));
        superBro.attach(fans.get(2));

        dramaQueen.attach(log);
        spiritualKing.attach(log);
        superBro.attach(log);

        // Exerice 4
        dramaQueen.attach(nolife);
        spiritualKing.attach(nolife);
        superBro.attach(nolife);

        // Exercice 5
        dramaQueen.attach(fanboy);
        spiritualKing.attach(hater);

        fanboy.attach(fans.get(0));
        hater.attach(fans.get(1));

        // Exercice 6
        dramaQueen.attach(troll1);
        dramaQueen.attach(troll2);
        spiritualKing.attach(troll1);
        spiritualKing.attach(troll2);
        superBro.attach(troll1);
        superBro.attach(troll2);
        fanboy.attach(troll1);
        fanboy.attach(troll2);
        hater.attach(troll1);
        hater.attach(troll2);

        // Exercice 7
        dramaQueen.attachVeto(pressAgent);
        spiritualKing.attachVeto(pressAgent);
        superBro.attachVeto(pressAgent);
    }

    /*
     * Boucle qui change les statuts des vedettes � tour de r�le. Drama knows no
     * bounds! Ne terminera jamais (fermez la fen�tre pour arr�ter le
     * programme).
     */
    public void startTheDrama()
    {
        while (true)
        {
            for (SocialMediaCelebrity celeb : celebs)
            {
                celeb.changeStatus();
            }
        }
    }

    /*
     * Initialisation de la fen�tre.
     */
    private void initUI()
    {
        setTitle("FaceTwit");
        setSize(500, 700);
        background = new JPanel(new GridLayout(4, 5));
        for (MessageView view : views)
        {
            background.add(view);
        }

        add(background);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addToMainWindow(MessageView view)
    {
        views.add(view);
    }

    public static void main(String[] args)
    {
        /*
         * Mise en file de l'ex�cution de l'interface graphique pour le
         * EventDispatchThread (gestionnaire de fen�tres).
         */
        Labo4Main ex = new Labo4Main(args);

        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ex.initUI();
                ex.setVisible(true);
            }
        });

        ex.startTheDrama();
    }
}