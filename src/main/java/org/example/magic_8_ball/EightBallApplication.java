package org.example.magic_8_ball;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EightBallApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Objects.requireNonNull(
                        EightBallApplication.class.getResource("/org/example/magic_8_ball/EightBall.fxml")
                )
        );

        // Uses the preferred size specified in the FXML
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Magic 8 Ball");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
