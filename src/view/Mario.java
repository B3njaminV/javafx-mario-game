package view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.awt.event.ActionEvent;

public class Mario {
    @FXML
    Label labelAafficher;
    @FXML
    private void cliqueSurBouton(){
        labelAafficher.setVisible(true);
        labelAafficher.setText("RIEN");
    }
}
