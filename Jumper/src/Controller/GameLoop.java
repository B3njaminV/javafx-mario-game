package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Model.Jumper;
import View.BackgroundView;
import View.JumperView;
import View.PseudoView;
import View.ScoreView;
import java.io.IOException;
import Model.Audio;

public class GameLoop {
    private static int i=0;
    public boolean contact = false;
    public boolean reset = false;
    public int stade = 0;

    /**
     * Thread Principal : boucle de jeu
     * @param b Vue de l'arrière plan
     * @param jView Vue du jumper
     * @param sc Vue du Score
     * @param pv Vue du Joueur
     * @param j Classe Jumper pour la gestion du saut
     */
    public GameLoop(BackgroundView b, JumperView jView, ScoreView sc, PseudoView pv, Jumper j) {
        Thread loop = new Thread(() -> {
            long currenttime = System.currentTimeMillis();
            while(currenttime>currenttime-1) {
                if (b.isReset()){
                    b.setReset(false);
                    contact = false;
                }
                // Tant qu'il n'y a pas de contact entre tuyau et jumper
                while (!contact) {
                    try {
                        // Si on relance la partie on réinitialise reset
                        if(reset == true){reset = false;}
                        // Gestion de la boucle de jeu
                        Platform.runLater(() ->{
                            b.updateBackground();
                            b.updateTuyau();
                            b.updateChateau();
                            sc.addPoint();
                            sc.updatePoint();
                        });
                        // Gestion du saut
                        j.calculCoordonnee();

                        // Gestion des collisions
                        if (jView.joueur.contactTuyau(b.t)) {
                            System.out.println("===> CONTACT");
                            contact = true;
                            sc.ajoutFinPartie();
                            Audio.playSound("audio/boum.wav");
                            b.afficheBoom();
                            pv.highScore(sc.score.getNbPoint());
                            sc.verifHighScore();
                            System.out.println("===> FIN DE PARTIE : " + pv.j.getPseudo() + " -> Score : " + pv.j.getHighScore() + " points - Meilleur Score : " + sc.highScore.getNbPoint() + " points !");
                        }

                        // Gestion de l'accélération de la boucle de jeu
                        if(sc.score.getNbPoint()%100 == 0) {
                            Thread.sleep(20);
                        }else {
                            Thread.sleep(10);
                        }
                    }
                    catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }

                }
                // Dans le cas d'une fin de partie
                b.buttonRelance.setVisible(true); // on fait apparaître le bouton qui permet de relancer une partie
                b.buttonRelance.setOnAction(new EventHandler<ActionEvent>() {

                    // Si on clique sur le bouton relancer Partie
                    @Override
                    public void handle(ActionEvent e) {
                        System.out.println("===> RELANCE PARTIE !");
                        sc.resetScore();// on réinitialise le score
                        b.resetGame(); // on appel la méthode de reset de background
                        jView.resetJumper();// on reset la vue du Jumper
                        b.buttonRelance.setVisible(false);// on recache le bouton Relancer Partie
                        try {
                            sc.setHighScore(b.relanceHighScorePartie()); // on recharge le meilleur score
                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
        loop.setDaemon(true);// pour couper le thread a la fermeture de la fenetre
        loop.start();
    }

}
