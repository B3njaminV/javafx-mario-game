package Launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Launch extends Application {

    /**
     * Lancement de la page d'Accueil
     * @param stage Fenetre
     * @throws IOException
     */
    public void start(Stage stage) throws IOException {
        Parent root=(Parent) FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Accueil.fxml"));
        Scene scene=new Scene(root,320,569);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("css/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.getIcons().setAll(new Image(getClass().getClassLoader().getResource("images/icoJumper.png").toExternalForm()));
        stage.setResizable(false);
        stage.setTitle("Bienvenue sur JumperGame");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

