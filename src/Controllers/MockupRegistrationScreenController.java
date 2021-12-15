package Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.UUID;

public class MockupRegistrationScreenController {

    PreparedStatement pst;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane TitlePane;

    @FXML
    private Label Title;

    @FXML
    private Label Registartielabel;

    @FXML
    private Separator ouderseperator;

    @FXML
    private Label ouderlabel;

    @FXML
    private Label voornaamlabel;

    @FXML
    private Label emaillabel;

    @FXML
    private TextField emailtextfield;

    @FXML
    private TextField voornaamtextfield;

    @FXML
    private Label geboortedatumlabel;

    @FXML
    private Label geslachtlabel;

    @FXML
    private TextField Achternaamtextfield;

    @FXML
    private Pane LoginPane;

    @FXML
    private DatePicker datepicker;

    @FXML
    private ComboBox combobox = new ComboBox();

    @FXML
    private TextField gebruikersnaamtextfield;

    @FXML
    private Label gebruikersnaamlabel;

    @FXML
    private TextField wachtwoordTextfield;

    @FXML
    private Label wachtwoordlabel;

    @FXML
    private Separator kindseparator;

    @FXML
    private Label kindlabel;

    @FXML
    private Label voornaamkind;

    @FXML
    private Label achternaamkind;

    @FXML
    private TextField voornaamtextfieldkind;
    private static String voornaam;

    @FXML
    private TextField achternaamtextfieldkind;

    @FXML
    private Label geboortedatumkind;

    @FXML
    private DatePicker datepickerkind;

    @FXML
    private Label geslachtkind;

    @FXML
    private ComboBox comboboxkind = new ComboBox();

    @FXML
    private Button aanmeldbutton;

    @FXML
    public void initialize() {
        combobox.getItems().removeAll(combobox.getItems());
        combobox.getItems().addAll("Man", "Vrouw");
        combobox.getSelectionModel().select("Geslacht");

        comboboxkind.getItems().removeAll(comboboxkind.getItems());
        comboboxkind.getItems().addAll("Man", "Vrouw");
        comboboxkind.getSelectionModel().select("Geslacht");
    }


    @FXML
    void goToRegister(ActionEvent event) throws IOException {

        String geslacht = (String) combobox.getValue();
        String email = emailtextfield.getText();
        String voornaam = voornaamtextfield.getText();
        String achternaam = Achternaamtextfield.getText();
        String gebruikersnaam = gebruikersnaamtextfield.getText();
        String wachtwoord = wachtwoordTextfield.getText();
        String voornaamkind1 = voornaamtextfieldkind.getText();
        String achternaamkind1 = achternaamtextfieldkind.getText();
        LocalDate geboortedatumkind1 = datepickerkind.getValue();
        String geslachtkind1 = (String) comboboxkind.getValue();


        try{
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root","1234");
            Statement statement = connectionString.createStatement();

            PreparedStatement stmt2 = connectionString.prepareStatement("select * from gebruiker where gebruikersnaam = ?");
            stmt2.setString(1, gebruikersnaam);
            ResultSet resultset = statement.executeQuery("select * from gebruiker");

            ResultSet results = stmt2.executeQuery();
            if (results.next()){
                System.out.println("Naam bestaat al, account niet aangemaakt");
            }
            else if(voornaam.equals("") || String.valueOf(geboortedatumkind1).equals("") || voornaamkind1.equals("") || achternaamkind1.equals("") || gebruikersnaam.equals("") || wachtwoord.equals("") || achternaam.equals("") || email.equals("")){
                System.out.println("Vakken mogen niet leeg zijn");
            }
            else {
                pst = connectionString.prepareStatement("insert into gebruiker(geslacht,emailadres,voornaam,achternaam,gebruikersnaam,wachtwoord,voornaamkind1,achternaamkind1,geboortedatumkind1,geslachtkind1)values(?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, geslacht);
                pst.setString(2, email);
                pst.setString(3, voornaam);
                pst.setString(4, achternaam);
                pst.setString(5, gebruikersnaam);
                pst.setString(6, wachtwoord);
                pst.setString(7, voornaamkind1);
                pst.setString(8, achternaamkind1);
                pst.setString(9, String.valueOf(geboortedatumkind1));
                pst.setString(10, geslachtkind1);

                pst.executeUpdate();
            }



        } catch (Exception e){
            e.printStackTrace();
        }



        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupRegisterscreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }



}
