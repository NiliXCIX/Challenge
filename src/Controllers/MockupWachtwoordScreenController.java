package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class MockupWachtwoordScreenController {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane TitlePane;

    @FXML
    private Label Title;

    @FXML
    private Label subTitle;

    @FXML
    private Label tekst1;

    @FXML
    private Label tekst2;

    @FXML
    private Pane LoginPane;

    @FXML
    private TextField emailTextfield;

    @FXML
    private TextField gebruikersnaamTextfield;

    @FXML
    private Label emailLabel;

    @FXML
    private Label gebruikersnaamLabel;

    @FXML
    private Button herstelButtonButton;

    @FXML
    void goToRegister(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupRegisterscreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }

}
