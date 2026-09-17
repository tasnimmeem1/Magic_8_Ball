module org.example.magic_8_ball {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.magic_8_ball to javafx.fxml;
    exports org.example.magic_8_ball;
}