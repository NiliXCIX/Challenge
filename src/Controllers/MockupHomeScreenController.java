package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.util.Objects;

public class MockupHomeScreenController {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane pane22;

    @FXML
    private Label voortgangLabel;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    @FXML
    private Line line5;

    @FXML
    private Line line6;

    @FXML
    private Line line7;

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
    private Label nieuweGesprekkenLabel;

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
    private Line line8;

    @FXML
    void goToOpnames(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupOpnames.fxml")));
        AnchorPane.getChildren().setAll(pane);
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