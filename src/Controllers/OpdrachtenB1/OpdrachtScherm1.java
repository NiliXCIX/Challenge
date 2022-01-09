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

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Objects;

public class OpdrachtScherm1 extends MockupHomeScreenController {

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
    private Button ControleerButton1;

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
    private Label EerstInvullen;

    public OpdrachtScherm1() throws LineUnavailableException {
    }


    @FXML
    void Controleer(ActionEvent event) {
        String GegevenAntwoord = Antwoord.getText();
        if (GegevenAntwoord.equalsIgnoreCase("dacht")){
            Correct.setOpacity(1);
            Fout.setOpacity(0);
            try {
                PrintWriter writer = new PrintWriter("B1.txt", "UTF-8");
                writer.write("1");
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
        if (clip.isRunning()) {
            clip.stop();
        }
        if (Correct.getOpacity() == 1) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm2.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        else{
            EerstInvullen.setOpacity(1);
        }
    }


    @FXML
    void Play(ActionEvent event){
        try {
            if (clip.isRunning()) {
                clip.stop();
                clip.close();
            }
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Audio/AUD-20211202-WA0006.wav"));
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
