package View;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import Model.Joueur;

public class PseudoView extends Parent {

    public Joueur j;
    public Text joueur;

    /**
     * Vue du Pseudo
     * @param pseudo Pseudo joueur
     */
    public PseudoView(String pseudo) {
        j=new Joueur(pseudo);
        joueur=new Text("Joueur " + j.getPseudo());
        joueur.setLayoutX(600);
        joueur.setLayoutY(30);
        joueur.setId("joueurcss");
        this.getChildren().add(joueur);
    }

    /**
     * Ajouter le meilleur score au joueur
     * @param sc Score
     */
    public void highScore(int sc){
        j.setHighScore(sc);
    }
}