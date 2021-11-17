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
import java.util.Objects;

public class MockupKindToevoegenController {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane TitlePane;

    @FXML
    private Label Title;

    @FXML
    private Label subTitleLabel;

    @FXML
    private Separator kindseperator;

    @FXML
    private Label kindlabel;

    @FXML
    private Label achternaamkind;

    @FXML
    private Pane controlePane;

    @FXML
    private TextField achternaamtextfieldkind;

    @FXML
    private DatePicker datepickerkind;

    @FXML
    private ComboBox<?> comboboxkind;

    @FXML
    private Label voornaamkind;

    @FXML
    private Label geslachtkind;

    @FXML
    private Label geboortedatumkind;

    @FXML
    private Separator controleSeparator;

    @FXML
    private Label controleLabel;

    @FXML
    private TextField gebruikersnaamTextField;

    @FXML
    private TextField wachtwoordTextField;

    @FXML
    private Button Toevoegenbutton;

    @FXML
    private TextField voornaamTextfield;

    @FXML
    void goToHomeScreen(ActionEvent event)throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupHomeScreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }

}
