package com.example.maze_ex;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    int [][] mazedata = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
            {1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,1},
            {1,1,1,0,1,1,1,1,1,1,1,0,1,0,0,0,0,1,1,1,0,1},
            {1,1,1,0,1,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,0,1},
            {1,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1},
            {1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,1},
            {1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,0,1,0,0,0,1,0,1,1,1,1,1,1,1,1},
            {1,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,1,0,0,0,1,1},
            {1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},

    };

    @FXML
    MazeDisplayer mazedis;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void start(){
        System.out.println("we start!");
    }

    public void openfile(){
        FileChooser fc = new FileChooser();
        fc.setTitle("open maze file");
        fc.setInitialDirectory(new File("./resources"));
        FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG, JPEG images", "*.jpg", "*.jpeg", "*.JPG", ".JPEG");
        fc.getExtensionFilters().add(jpgFilter);
        //fc.setSelectedExtensionFilter(jpd);
        File chosen = fc.showOpenDialog(null);
        if(chosen != null)
            System.out.println(chosen.getName());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mazedis.setMazeData(mazedata);
        mazedis.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)-> mazedis.requestFocus());
        mazedis.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                int r = mazedis.getcRow();
                int c = mazedis.getcCol();
                if(keyEvent.getCode() == KeyCode.UP){
                    mazedis.setCaracter(r-1,c);
                }
                if(keyEvent.getCode() == KeyCode.DOWN){
                    mazedis.setCaracter(r+1,c);
                }
                if(keyEvent.getCode() == KeyCode.LEFT){
                    mazedis.setCaracter(r,c-1);
                }
                if(keyEvent.getCode() == KeyCode.RIGHT){
                    mazedis.setCaracter(r,c+1);
                }
            }
        });
    }
}