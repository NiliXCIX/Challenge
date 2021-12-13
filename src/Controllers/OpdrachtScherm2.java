package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Objects;

public class OpdrachtScherm2 {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane TitlePane;

    @FXML
    private Label Opdrachten;

    @FXML
    private Separator TopSeparator;

    @FXML
    private Button homeButton;

    @FXML
    private Label Vraag2Titel;

    @FXML
    private Pane AudioPane;

    @FXML
    private ProgressBar AudioProgress;

    @FXML
    private Rectangle PlayPane;

    @FXML
    private Button PlayButton;

    @FXML
    private Separator ButtomSeparator;

    @FXML
    private Label AntwoordLabel;

    @FXML
    private Label Opdrachttext;

    @FXML
    private TextField Antwoord;

    @FXML
    private Button ControleerButton;

    @FXML
    private Button VolgendeButton;

    @FXML
    private Label Correct;

    @FXML
    private Label Fout;

    @FXML
    private Button TerugButton;

    @FXML
    private Label EerstInvullen;

    @FXML
    void Controleer(ActionEvent event) {
        String GegevenAntwoord = Antwoord.getText();
        if (GegevenAntwoord.equalsIgnoreCase("hingen")){
            Correct.setOpacity(1);
            Fout.setOpacity(0);
        }
        else{
            Fout.setOpacity(1);
            Correct.setOpacity(0);
        }

    }

    @FXML
    void GoToNextQuestion(ActionEvent event) throws IOException {
        if (Correct.getOpacity() == 1) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm3.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        else{
            EerstInvullen.setOpacity(1);
        }
    }

    @FXML
    void GoToPreviousQuestion(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm1.fxml")));
        AnchorPane.getChildren().setAll(pane);

    }

    @FXML
    void Play(ActionEvent event) {

    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupHomeScreen.fxml")));
        AnchorPane.getChildren().setAll(pane);

    }

}
