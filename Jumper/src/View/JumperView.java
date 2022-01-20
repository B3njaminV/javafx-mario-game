package View;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Model.Jumper;

public class JumperView extends Parent {

    public ImageView jumper;

    public static Jumper joueur;

    /**
     * Vue de notre jumper
     * @param joueur
     */
    public JumperView(Jumper joueur) {

        Image jump = new Image(getClass().getClassLoader().getResource("images/jumper.png").toExternalForm());
        jumper = new ImageView();
        JumperView.joueur = joueur;
        jumper.setImage(jump);
        jumper.setFitWidth(JumperView.joueur.getLargeur());
        jumper.setFitHeight(JumperView.joueur.getHauteur());
        jumper.xProperty().bind(JumperView.joueur.getX());
        jumper.yProperty().bind(JumperView.joueur.getY());

        this.getChildren().add(jumper);
    }

    /**
     * Réinitialiser les paramètres du Jumper
     */
    public void resetJumper()
    {
        joueur.setY(245);
        joueur.setHauteurMax(false);
        joueur.setHauteurMin(false);
        joueur.setEntrainDeSauter(false);
    }


}
