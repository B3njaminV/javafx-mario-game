package View;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Model.Score;
import Model.Tuyau;

import java.io.*;
import java.util.*;

public class BackgroundView extends Parent {

    public ImageView fondEcran;
    public ImageView fondEcran2;
    public ImageView chateau;
    public ImageView tuyau;
    public ImageView boom;
    public Tuyau t;
    public Tuyau t2;
    public Tuyau t3;
    public Tuyau t4;
    public Button buttonRelance;

    public boolean isReset() {
        return reset;
    }
    public void setReset(boolean reset) {
        this.reset = reset;
    }
    private boolean reset;
    public List listeTuyau;

    /**
     * Vue de notre Background avec les images
     */
    public BackgroundView() {
        Image fond = new Image(getClass().getClassLoader().getResource("images/fondEcran.png").toExternalForm());
        Image tuy = new Image(getClass().getClassLoader().getResource("images/tuyauRouge.png").toExternalForm());
        Image chat = new Image(getClass().getClassLoader().getResource("images/chateau.png").toExternalForm());
        Image boo = new Image(getClass().getClassLoader().getResource("images/boom.png").toExternalForm());

        t2 = new Tuyau(800, 235, 43, 60);
        t3 = new Tuyau(800, 230, 43, 65);
        t4 = new Tuyau(800, 220, 43, 75);

        listeTuyau = new ArrayList<Tuyau>();
        listeTuyau.add(t2);
        listeTuyau.add(t3);
        listeTuyau.add(t4);

        Random rdm = new Random();
        t = (Tuyau)listeTuyau.get(rdm.nextInt(listeTuyau.size())); // on sort un tuyau aléatoire à chaque nouvelle partie

        fondEcran = new ImageView(fond);
        fondEcran2 = new ImageView(fond);
        tuyau = new ImageView(tuy);
        chateau=new ImageView(chat);
        buttonRelance = new Button();
        boom=new ImageView(boo);

        fondEcran.setFitWidth(800);
        fondEcran.setFitHeight(350);
        fondEcran.setX(0);

        fondEcran2.setFitWidth(800);
        fondEcran2.setFitHeight(350);
        fondEcran2.setX(800);

        chateau.setFitWidth(172);
        chateau.setFitHeight(200);
        chateau.setX(120);
        chateau.setY(94);

        boom.setFitWidth(63);
        boom.setFitHeight(50);
        boom.setX(208);
        boom.setY(208);
        boom.setVisible(false);

        tuyau.setFitWidth(t.getLargeur());
        tuyau.setFitHeight(t.getHauteur());
        tuyau.xProperty().bind(t.getX());
        tuyau.yProperty().bind(t.getY());

        buttonRelance.setText("Relancer une Partie !");
        buttonRelance.setLayoutX(280);
        buttonRelance.setLayoutY(200);
        buttonRelance.setVisible(false);
        buttonRelance.setId("buttonRelance");

        this.getChildren().add(fondEcran);
        this.getChildren().add(fondEcran2);
        this.getChildren().add(tuyau);
        this.getChildren().add(buttonRelance);
        this.getChildren().add(chateau);
        this.getChildren().add(boom);
    }

    /**
     * Mise à jour du fond d'écran
     */
    public void updateBackground() {
        if (fondEcran.getX() == -800)
        {
            fondEcran.setX(800);
        }
        fondEcran.setX(fondEcran.getX()-5);
        if (fondEcran2.getX() == -800)
        {
            fondEcran2.setX(800);
        }
        fondEcran2.setX(fondEcran2.getX()-5);
    }

    /**
     * Avancement du chateau
     */
    public void updateChateau(){
        chateau.setX(chateau.getX()-5);
    }

    /**
     * Mise à jour du tuyau
     */
    public void updateTuyau(){
        if (tuyau.getX() == 0)
        {
            t.remisAZero(800);
        }
        t.avance();
        tuyau.xProperty().bind(t.getX());
    }

    /**
     * Afficher image Boom une fois que collision
     */
    public void afficheBoom(){
        boom.setVisible(true);
    }

    /**
     * Réinitialiser la partie, on reset la position des élements sur le background
     */
    public void resetGame(){ // fct qui reset la position des éléments du background
        fondEcran.setX(0);
        fondEcran2.setX(800);
        chateau.setX(120);
        boom.setVisible(false);
        t.remisAZero(800);
        reset = true; // indic que le background est reset
    }

    /**
     * Fonction qui permet de mettre à jour le score après avoir relancer une partie
     * @return Meilleur Score
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Score relanceHighScorePartie() throws IOException, ClassNotFoundException {
        Score hS = new Score();
        File fichier =  new File(getClass().getClassLoader().getResource("persistence/HighScore.xml").getPath());
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
        hS = (Score)ois.readObject();
        return hS;
    }

}

