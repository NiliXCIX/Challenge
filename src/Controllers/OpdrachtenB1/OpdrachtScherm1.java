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
import java.sql.*;
import java.util.Objects;

public class OpdrachtScherm1 extends MockupHomeScreenController {

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

    String gebruikersnaamdb;
    String passworddb;
    String loggedinuser = getname();

    public OpdrachtScherm1() throws LineUnavailableException {
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
            if (GegevenAntwoord.equalsIgnoreCase("dacht")) {
                Correct.setOpacity(1);
                Fout.setOpacity(0);
                EerstInvullen.setOpacity(0);
                pst = connectionString.prepareStatement("update gebruiker set B1 = 1 where gebruikersnaam = ?");
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
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm2.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        else{
            EerstInvullen.setOpacity(1);
            Fout.setOpacity(0);
            Correct.setOpacity(0);
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
