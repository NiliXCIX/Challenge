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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

        ObservableList geslacht = combobox.getItems();
        String email = emailtextfield.getText();
        String voornaam = voornaamtextfield.getText();
        String achternaam = Achternaamtextfield.getText();
        String gebruikersnaam = gebruikersnaamtextfield.getText();
        String wachtwoord = wachtwoordTextfield.getText();


        try{
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root","1234");
            Statement statement = connectionString.createStatement();
            ResultSet resultset = statement.executeQuery("select * from gebruiker");


            pst = connectionString.prepareStatement("insert into gebruiker(geslacht,emailadres,voornaam,achternaam,gebruikersnaam,wachtwoord)values(?,?,?,?,?,?)");
            pst.setString(1, String.valueOf(geslacht));
            pst.setString(2,email);
            pst.setString(3,voornaam);
            pst.setString(4,achternaam);
            pst.setString(5,gebruikersnaam);
            pst.setString(6,wachtwoord);
            pst.executeUpdate();



        } catch (Exception e){
            e.printStackTrace();
        }



        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupRegisterscreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }



}
