package Controllers;

import Controllers.OpdrachtenB1.OpdrachtScherm1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurve;

import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class MockupHomeScreenController extends MockupRegisterScreenController {
    PreparedStatement pst;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane pane22;

    @FXML
    private Label voortgangLabel;

    @FXML
    private Label IngevuldeOpdrachtenLabel;

    @FXML
    private Label AantalIngevuldeOpdrachten;

    @FXML
    private Label AantalOpdrachten;

    @FXML
    private Pane pane23;

    @FXML
    private CubicCurve batterijcurve;

    @FXML
    private Label batterijprocent;

    @FXML
    private Label batterijlabel;

    @FXML
    private Label title;

    @FXML
    private Pane pane2;

    @FXML
    private Label gesprekkenLabel;

    @FXML
    private Label aantalGesprekkenLabel;

    @FXML
    private Button opnamesButton;

    @FXML
    private Hyperlink afmeldenLink;

    @FXML
    private Button schakelButton;

    @FXML
    private Label buttonTekst;

    @FXML
    private Pane pane21;

    @FXML
    private Label huidigeNiveau;

    @FXML
    private Label niveaus;

    @FXML
    private Label niveauLabel;

    @FXML
    private Button ButtonA1;

    @FXML
    private Button ButtonA2;

    @FXML
    private Button ButtonB1;

    @FXML
    private Button ButtonB2;

    public int GoedeAntwoordenA1;
    public int GoedeAntwoordenA2;
    public int GoedeAntwoordenB1;
    public int GoedeAntwoordenB2;


    String gebruikersnaamdb;
    String passworddb;

    String loggedinuser = getname();


    void connectDatabase() {

        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            pst = connectionString.prepareStatement("select gebruiker set B1 = 1 where gebruikersnaam = ?");
            pst.setString(1,loggedinuser);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ChangeA1(ActionEvent event) {
        huidigeNiveau.setText("A1");
        aantalGesprekkenLabel.setText("2");
        AantalOpdrachten.setText("/ 2");
        AantalIngevuldeOpdrachten.setText(""+GoedeAntwoordenA1);

    }

    @FXML
    void ChangeA2(ActionEvent event) {
        huidigeNiveau.setText("A2");
        aantalGesprekkenLabel.setText("2");
        AantalOpdrachten.setText("/ 2");
        AantalIngevuldeOpdrachten.setText(""+GoedeAntwoordenA2);
    }

    @FXML
    void ChangeB1(ActionEvent event) {
        huidigeNiveau.setText("B1");
        aantalGesprekkenLabel.setText("3");
        AantalOpdrachten.setText("/ 3");
        AantalIngevuldeOpdrachten.setText(""+GoedeAntwoordenB1);
    }

    @FXML
    void ChangeB2(ActionEvent event) {
        huidigeNiveau.setText("B2");
        aantalGesprekkenLabel.setText("2");
        AantalOpdrachten.setText("/ 2");
        AantalIngevuldeOpdrachten.setText(""+GoedeAntwoordenB2);
    }

    @FXML
    void goToOpnames(ActionEvent event) throws IOException {
        String huidigniveau = huidigeNiveau.getText();
        if (huidigniveau.equalsIgnoreCase("A1")) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/Opdracht1A1.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        if (huidigniveau.equalsIgnoreCase("A2")) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/Opdracht1A2.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
        if (huidigniveau.equalsIgnoreCase("B1")) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm1.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }
//        if (huidigniveau.equalsIgnoreCase("B2")) {
//            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/OpdrachtScherm1.fxml")));
//            AnchorPane.getChildren().setAll(pane);
//        }

    }


    @FXML
    void goToRegister(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupRegisterscreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }


    @FXML
    void goToToevoegen(ActionEvent event) throws IOException {
    AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupKindToevoegen.fxml")));
        AnchorPane.getChildren().setAll(pane);
}

}
