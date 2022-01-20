package View;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import Model.Score;
import java.io.*;

public class ScoreView extends Parent {

    public Score score;
    public Text textScore;
    public Score highScore;
    public Text texthighScore;
    public Text finPartie;

    /**
     * Vue de notre score
     * @param sc Meilleur score chargé auparavant grace a la persistence
     */
    public ScoreView(Score sc) {

        score=new Score();
        this.highScore=sc;
        textScore=new Text("Score : " + score.getNbPoint() + " points");
        texthighScore=new Text("Meilleur Score :" + highScore.getNbPoint());
        finPartie=new Text(" ");
        textScore.setLayoutX(20);
        textScore.setLayoutY(50);
        texthighScore.setLayoutX(20);
        texthighScore.setLayoutY(25);
        finPartie.setLayoutX(60);
        finPartie.setLayoutY(160);
        finPartie.setVisible(false);
        textScore.setId("textScore");
        texthighScore.setId("textScore");
        finPartie.setId("finPartiecss");
        this.getChildren().add(finPartie);
        this.getChildren().add(textScore);
        this.getChildren().add(texthighScore);
    }

    /**
     * Mettre à jour le score dans la vue
     */
    public void updatePoint(){
        textScore.setText("Score : " + score.getNbPoint() + " points"); // on set le text contenu dans textScore
        texthighScore.setText("Meilleur Score : " + highScore.getNbPoint());
    }

    /**
     * Affichage du bouton fin de Partie
     */
    public void ajoutFinPartie(){
        finPartie.setText("FIN DE PARTIE : " + score.getNbPoint() + " points");
        finPartie.setVisible(true);
    }

    public void setHighScore(Score sc){
        this.highScore=sc;
    }

    /**
     * Ajouter des points au Score du jeu
     */
    public void addPoint(){
        this.score.addPoint();
    }

    /**
     * Remettre le score a 0 après une fin de partie
     */
    public void resetScore(){
        score.remisAZreo();
        finPartie.setVisible(false);
    }

    /**
     * Vérifié si le score du Joueur est supérieur au meilleur score
     * Si oui score joueur devient le meilleur Score
     * @throws IOException Problème d'ouverture de fichier
     */
    public void verifHighScore() throws IOException {
        if(this.score.getNbPoint() > this.highScore.getNbPoint()){
            File fichier =  new File(getClass().getClassLoader().getResource("persistence/HighScore.xml").getPath());
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier));
            oos.writeObject(score);
            oos.close();
        }
    }

}