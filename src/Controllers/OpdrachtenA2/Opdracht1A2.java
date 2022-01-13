package Controllers.OpdrachtenA2;

import Controllers.MockupHomeScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class Opdracht1A2 extends MockupHomeScreenController {

    PreparedStatement pst;

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

    String gebruikersnaamdb;
    String passworddb;
    String loggedinuser = getname();

    public Opdracht1A2() throws LineUnavailableException {
    }


    @FXML
    void Controleer(ActionEvent event) {
        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            ResultSet resultset = statement.executeQuery("select * from gebruiker");
            while (resultset.next()) {
                gebruikersnaamdb = resultset.getString("gebruikersnaam");
                passworddb = resultset.getString("wachtwoord");
            }

            String GegevenAntwoord = Antwoord.getText();
            if (GegevenAntwoord.contains("schrijven") || GegevenAntwoord.contains("schreef") || GegevenAntwoord.contains("schrijft") || GegevenAntwoord.contains("geschreven") || GegevenAntwoord.contains("schrijf") || GegevenAntwoord.contains("Schrijven") || GegevenAntwoord.contains("Schrijft") || GegevenAntwoord.contains("Schreef") || GegevenAntwoord.contains("Schrijf")) {
                Correct.setOpacity(1);
                Fout.setOpacity(0);
                EerstInvullen.setOpacity(0);
                pst = connectionString.prepareStatement("update gebruiker set A2 = 1 where gebruikersnaam = ?");
                pst.setString(1, loggedinuser);
                pst.executeUpdate();
            } else {
                Fout.setOpacity(1);
                Correct.setOpacity(0);
                EerstInvullen.setOpacity(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }





        @FXML
    void GoToNextQuestion(ActionEvent event) throws IOException {
        if (clip.isRunning()) {
            clip.stop();
        }
        if (Correct.getOpacity() == 1) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/Opdracht2A2.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        else{
            EerstInvullen.setOpacity(1);
            Fout.setOpacity(0);
            Correct.setOpacity(0);
        }
    }

    @FXML
    void Play(ActionEvent event) {
        try {
            if (clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Audio/Demo-1-A2.wav"));
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


