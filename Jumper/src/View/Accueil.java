package View;

import Controller.GameLoop;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import Model.Jumper;
import Model.Score;
import Model.Audio;

public class Accueil implements Initializable {

    private Jumper joueur;
    private JumperView jView;
    @FXML
    private javafx.scene.control.TextField field;
    @FXML Text titre;

    @FXML
    private void handleAction(ActionEvent event) throws IOException, ClassNotFoundException {
        String pseudoDonne = field.getText();
        if(pseudoDonne == null || pseudoDonne.trim().isEmpty()){
            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.setContentText("ATTENTION : Vous devez entrez un pseudo valide !");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            LancerPartie(pseudoDonne);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        joueur = new Jumper(200,245);
        jView = new JumperView(joueur);
    }

    /**
     * Lancement du Jeu
     * @param textPseudo Pseudo renseigné sur la page d'accueil
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void LancerPartie(String textPseudo) throws IOException, ClassNotFoundException {
        Stage stage = (Stage) field.getScene().getWindow();
        stage.close();

        Group root = new Group();
        BackgroundView b = new BackgroundView();

        /*Chargement du meilleur score*/
        Score highScore = new Score();
        try {
            File fichier =  new File(getClass().getClassLoader().getResource("persistence/HighScore.xml").getPath());
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
            highScore = (Score)ois.readObject();
        }catch(Exception e){
            System.out.println("PB OUVERTURE FICHIER PERSISTENCE !!" + e);
        }

        ScoreView sView = new ScoreView(highScore);
        PseudoView pView = new PseudoView(textPseudo);

        GameLoop g = new GameLoop(b,jView, sView,pView,joueur);

        root.getChildren().add(b);
        root.getChildren().add(jView);
        root.getChildren().add(sView);
        root.getChildren().add(pView);

        /*Fenetre*/
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("css/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.setHeight(350);
        stage.setWidth(800);
        stage.setResizable(false);
        stage.setTitle("JumperGame");
        stage.show();
        /*Fond sonore*/
        Audio.playSound("audio/fond.wav");
        System.out.println("===> QUE LE JEU COMMENCE !");
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(!g.contact) {
                    System.out.println("===> SAUT");
                    Audio.playSound("audio/saut.wav");
                    joueur.sautDebut();
                }
            }
        }
        );
    }
}