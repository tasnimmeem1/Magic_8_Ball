package org.example.magic_8_ball;


import java.util.Random;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

//@Author- Shahla Tasnim Meem
public class EightBallController {

    // Possible answers from the Magic 8 Ball
    private final String[] answers = {
            "Yes, definitely!",
            "It is certain.",
            "Most likely.",
            "Without a doubt.",
            "Signs point to yes.",
            "Ask again later.",
            "Cannot predict now.",
            "Better not tell you now.",
            "Do not count on it.",
            "My sources say no.",
            "Very doubtful.",
            "The answer is no."
    };

    private final Random random = new Random();

    private int previousAnswer = -1;

    @FXML
    private TextField questionField;

    @FXML
    private Label answerLabel;

    @FXML
    private StackPane eightBall;

    // Runs automatically when the FXML file loads
    @FXML
    public void initialize() {
        makeDraggable();
    }

    // Displays a random answer when the button is clicked
    @FXML
    private void askEightBall(ActionEvent event) {
        String question = questionField.getText().trim();

        // Require the user to enter a question
        if (question.isEmpty()) {
            answerLabel.setText("Enter a question!");
            questionField.requestFocus();
            return;
        }

        int answerIndex;

        // Prevent the same answer from appearing twice in a row
        do {
            answerIndex = random.nextInt(answers.length);
        } while (answerIndex == previousAnswer);

        answerLabel.setText(answers[answerIndex]);
        previousAnswer = answerIndex;

        shakeEightBall();
    }

    // Creates a short shaking animation
    private void shakeEightBall() {
        RotateTransition shake =
                new RotateTransition(Duration.millis(80), eightBall);

        shake.setByAngle(8);
        shake.setCycleCount(6);
        shake.setAutoReverse(true);
        shake.play();
    }

    // Allows the user to drag the Magic 8 Ball
    private void makeDraggable() {
        final double[] mouseOffset = new double[2];

        eightBall.setOnMousePressed(event -> {
            mouseOffset[0] =
                    event.getSceneX() - eightBall.getTranslateX();

            mouseOffset[1] =
                    event.getSceneY() - eightBall.getTranslateY();

            eightBall.setCursor(Cursor.CLOSED_HAND);
        });

        eightBall.setOnMouseDragged(event -> {
            eightBall.setTranslateX(
                    event.getSceneX() - mouseOffset[0]
            );

            eightBall.setTranslateY(
                    event.getSceneY() - mouseOffset[1]
            );
        });

        eightBall.setOnMouseReleased(event ->
                eightBall.setCursor(Cursor.HAND)
        );

        eightBall.setCursor(Cursor.HAND);
    }
}