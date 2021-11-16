package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class JavaFXApp extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root;
        final double[] xOffset = new double[1];
        final double[] yOffset = new double[1];


        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXMLFiles/MockupOpnames.fxml")));

        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);

        scene.setFill(Color.TRANSPARENT);


        root.setOnMousePressed(event -> {
            xOffset[0] = event.getSceneX();
            yOffset[0] = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset[0]);
            primaryStage.setY(event.getScreenY() - yOffset[0]);
        });

        primaryStage.setTitle("Kumbaya");
        primaryStage.show();


    }
}
