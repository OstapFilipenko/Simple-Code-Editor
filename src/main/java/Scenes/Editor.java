package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Editor {
    private TextArea textArea = new TextArea();
    private Stage stage;
    public Editor(Stage stage){
        this.stage = stage;
    }

    public Scene mainScene(){
        VBox root = new VBox();

        //disable scroll in x axis
        textArea.setWrapText(true);

        //createting menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem open = new MenuItem("Open File");
        MenuItem save = new MenuItem("Save");
        fileMenu.getItems().addAll(open, save);
        menuBar.getMenus().addAll(fileMenu);
        //MenuItem newFile = new MenuItem("New");

        save.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show save file dialog
            File file = fileChooser.showSaveDialog(stage);

            if (file != null) {
                saveTextToFile(textArea.getText(), file);
            }
        });

        root.getChildren().addAll(menuBar, textArea);
        return new Scene(root);
    }

    /*
    * String content > the content of the file
    * File file > file in which the text will be saved
    * */
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

}
