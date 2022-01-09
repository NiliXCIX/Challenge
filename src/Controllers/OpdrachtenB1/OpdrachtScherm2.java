package Controllers.OpdrachtenB1;

import Controllers.MockupHomeScreenController;
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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class OpdrachtScherm2 extends MockupHomeScreenController {

    private Clip clip = AudioSystem.getClip();

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

    public OpdrachtScherm2() throws LineUnavailableException {
    }

    @FXML
    void Controleer(ActionEvent event) {
        String GegevenAntwoord = Antwoord.getText();
        if (GegevenAntwoord.equalsIgnoreCase("hingen")){
            Correct.setOpacity(1);
            Fout.setOpacity(0);
            try {
                PrintWriter writer = new PrintWriter("B1.txt", "UTF-8");
                writer.write("1");
                writer.write("2");
                writer.close();
            }
            catch (IOException e){

            }
        }
        else{
            Fout.setOpacity(1);
            Correct.setOpacity(0);
        }

    }

    @FXML
    void GoToNextQuestion(ActionEvent event) throws IOException {
        if (Correct.getOpacity() == 1) {
            if (clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm3.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        else{
            EerstInvullen.setOpacity(1);
        }
    }

    @FXML
    void GoToPreviousQuestion(ActionEvent event) throws IOException {
        if (clip.isRunning()) {
            clip.stop();
            clip.close();
        }
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm1.fxml")));
        AnchorPane.getChildren().setAll(pane);

    }

    @FXML
    void Play(ActionEvent event) {
        try {
            if (clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Audio/AUD-20211202-WA0007.wav"));
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        if (clip.isRunning()) {
            clip.stop();
            clip.close();
        }
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupHomeScreen.fxml")));
        AnchorPane.getChildren().setAll(pane);

    }

}
