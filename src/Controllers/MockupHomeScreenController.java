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
    ResultSet rs = null;

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


    @FXML
    void initialize(){
        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            String sql = "SELECT A1 FROM gebruiker WHERE gebruikersnaam =?";
            pst=connectionString.prepareStatement(sql);
            pst.setString(1,loggedinuser);

            rs = pst.executeQuery();
            while (rs.next()) {

                AantalIngevuldeOpdrachten.setText(rs.getString("A1"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void ChangeA1(ActionEvent event) {
        huidigeNiveau.setText("A1");
        aantalGesprekkenLabel.setText("2");
        AantalOpdrachten.setText("/ 2");
        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            String sql = "SELECT A1 FROM gebruiker WHERE gebruikersnaam =?";
            pst=connectionString.prepareStatement(sql);
            pst.setString(1,loggedinuser);

            rs = pst.executeQuery();
            while (rs.next()) {

                AantalIngevuldeOpdrachten.setText(rs.getString("A1"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void ChangeA2(ActionEvent event) {
        huidigeNiveau.setText("A2");
        aantalGesprekkenLabel.setText("2");
        AantalOpdrachten.setText("/ 2");
        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            String sql = "SELECT A2 FROM gebruiker WHERE gebruikersnaam =?";
            pst=connectionString.prepareStatement(sql);
            pst.setString(1,loggedinuser);

            rs = pst.executeQuery();
            while (rs.next()) {

                AantalIngevuldeOpdrachten.setText(rs.getString("A2"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ChangeB1(ActionEvent event) {
        huidigeNiveau.setText("B1");
        aantalGesprekkenLabel.setText("3");
        AantalOpdrachten.setText("/ 3");
        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            String sql = "SELECT B1 FROM gebruiker WHERE gebruikersnaam =?";
            pst=connectionString.prepareStatement(sql);
            pst.setString(1,loggedinuser);

            rs = pst.executeQuery();
            while (rs.next()) {

                AantalIngevuldeOpdrachten.setText(rs.getString("B1"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ChangeB2(ActionEvent event) {
        huidigeNiveau.setText("B2");
        aantalGesprekkenLabel.setText("2");
        AantalOpdrachten.setText("/ 2");
        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            String sql = "SELECT B2 FROM gebruiker WHERE gebruikersnaam =?";
            pst=connectionString.prepareStatement(sql);
            pst.setString(1,loggedinuser);

            rs = pst.executeQuery();
            while (rs.next()) {

                AantalIngevuldeOpdrachten.setText(rs.getString("B2"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (huidigniveau.equalsIgnoreCase("B2")) {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/Opdracht1B2.fxml")));
            AnchorPane.getChildren().setAll(pane);
        }

    }


    @FXML
    void goToRegister(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupRegisterscreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }


    @FXML
    void goToToevoegen(ActionEvent event) throws IOException {

        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root", "1234");
            Statement statement = connectionString.createStatement();
            ResultSet resultset = statement.executeQuery("select * from gebruiker");
            while (resultset.next()) {
                gebruikersnaamdb = resultset.getString("gebruikersnaam");
                passworddb = resultset.getString("wachtwoord");
            }
            pst = connectionString.prepareStatement("update gebruiker set A1 = 0 where gebruikersnaam = ?");
            pst.setString(1, loggedinuser);
            pst.executeUpdate();
            pst = connectionString.prepareStatement("update gebruiker set A2 = 0 where gebruikersnaam = ?");
            pst.setString(1, loggedinuser);
            pst.executeUpdate();
            pst = connectionString.prepareStatement("update gebruiker set B1 = 0 where gebruikersnaam = ?");
            pst.setString(1, loggedinuser);
            pst.executeUpdate();
            pst = connectionString.prepareStatement("update gebruiker set B2 = 0 where gebruikersnaam = ?");
            pst.setString(1, loggedinuser);
            pst.executeUpdate();
        }
        catch (Exception e){e.printStackTrace();}
    initialize();
    }

}
