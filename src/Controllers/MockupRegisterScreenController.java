package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class MockupRegisterScreenController{

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane TitlePane;

    @FXML
    private Label Title;

    @FXML
    private Pane LoginPane;

    @FXML
    private TextField PasswordTextfield;

    @FXML
    private Label Registerlabel;

    @FXML
    private Hyperlink RegisterHyperlink;

    @FXML
    private Hyperlink PasswordHyperlink;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField UsernameTextfield;


    @FXML
    void goToHome(ActionEvent event)throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupHomeScreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goToRegistration(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupRegistrationScreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goToWachtwoord(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupWachtwoordScreen.fxml")));
        AnchorPane.getChildren().setAll(pane);
    }

}
