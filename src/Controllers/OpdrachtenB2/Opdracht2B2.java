package Controllers.OpdrachtenB2;

import Controllers.MockupHomeScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
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

public class Opdracht2B2 extends MockupHomeScreenController {

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
    private Label vraag;

    @FXML
    private CheckBox A;

    @FXML
    private CheckBox C;

    @FXML
    private CheckBox B;

    String gebruikersnaamdb;
    String passworddb;
    String loggedinuser = getname();


    public Opdracht2B2() throws LineUnavailableException {
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


            if (B.isSelected() && !A.isSelected() && !C.isSelected()) {
                Correct.setOpacity(1);
                Fout.setOpacity(0);
                EerstInvullen.setOpacity(0);
                pst = connectionString.prepareStatement("update gebruiker set B2 = 2 where gebruikersnaam = ?");
                pst.setString(1,loggedinuser);
                pst.executeUpdate();
            }
            else{
                Fout.setOpacity(1);
                Correct.setOpacity(0);
                EerstInvullen.setOpacity(0);
            }

        }
        catch(Exception e){
            e.printStackTrace();
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
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Audio/Demo-2-B2.wav"));
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


