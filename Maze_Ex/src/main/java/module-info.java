module com.example.maze_ex {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maze_ex to javafx.fxml;
    exports com.example.maze_ex;
}