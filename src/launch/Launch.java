package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;

import java.io.IOException;

public class Launch extends Application{
    public void start(Stage stage) throws IOException {
        Parent root=(Parent) FXMLLoader.load(getClass().getClassLoader().getResource("mario.fxml"));
        Scene scene=new Scene(root,400,400);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
