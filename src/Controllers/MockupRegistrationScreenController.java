package Controllers;

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
import java.util.Objects;
import java.util.ResourceBundle;

public class MockupRegistrationScreenController {

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
    private Pane LoginPane;

    @FXML
    private DatePicker datepicker;

    @FXML
    private ComboBox combobox;

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

    @FXML
    private TextField achternaamtextfieldkind;

    @FXML
    private Label geboortedatumkind;

    @FXML
    private DatePicker datepickerkind;

    @FXML
    private Label geslachtkind;

    @FXML
    private ComboBox<?> comboboxkind;

    @FXML
    private Button aanmeldbutton;

    @FXML
    void goToRegister(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupRegisterscreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }

}
