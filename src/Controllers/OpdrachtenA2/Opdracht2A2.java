package Controllers.OpdrachtenA2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Opdracht2A2 {

    // to store current position
    Long currentFrame;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath;
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
    private Label Vraag1Titel;

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
    private Button ControleerButton;

    @FXML
    private Label Correct;

    @FXML
    private Label Fout;

    @FXML
    private Label EerstInvullen;

    @FXML
    private Button VolgendeButton;

    @FXML
    private TextArea Antwoord;

    public Opdracht2A2() throws LineUnavailableException {
    }


    @FXML
    void Controleer(ActionEvent event) {
        String GegevenAntwoord = Antwoord.getText();
        if (GegevenAntwoord.contains("werken") || GegevenAntwoord.contains("werkte") || GegevenAntwoord.contains("werkt") || GegevenAntwoord.contains("gewerkt") || GegevenAntwoord.contains("werk") || GegevenAntwoord.contains("Werken") || GegevenAntwoord.contains("Werkt") || GegevenAntwoord.contains("Werkte") || GegevenAntwoord.contains("Gewerkt") || GegevenAntwoord.contains("Werk")){
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
        if (clip.isRunning()) {
            clip.stop();
        }
        if (Correct.getOpacity() == 1) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupHomescreen.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        else{
            EerstInvullen.setOpacity(1);
        }
    }

    @FXML
    void Play(ActionEvent event) {
        try {
            if (clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Audio/Demo-2-A2.wav"));
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
        }
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupHomescreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }
}

