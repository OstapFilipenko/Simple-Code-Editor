package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Editor {
    private TextArea textArea = new TextArea();
    File fileOpend;
    private Stage stage;
    public Editor(Stage stage){
        this.stage = stage;
    }

    public Scene mainScene(){
        FileChooser fileChooser = new FileChooser();
        VBox root = new VBox();
        //disable scroll in x axis
        textArea.setWrapText(true);
        //set font size
        textArea.setStyle("-fx-font-size: 1.5em;");

        //createting menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem open = new MenuItem("Open File");
        MenuItem save = new MenuItem("Save");
        Menu runCode = new Menu("Run");
        MenuItem execute = new MenuItem("Execute Code");
        fileMenu.getItems().addAll(open, save);
        runCode.getItems().addAll(execute);
        menuBar.getMenus().addAll(fileMenu, runCode);

        save.setOnAction(event -> {
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Kotlin Script (*.kts)", "*.kts");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show save file dialog
            fileOpend = fileChooser.showSaveDialog(stage);

            if (fileOpend != null) {
                saveTextToFile(textArea.getText(), fileOpend);
            }
            stage.setTitle(fileOpend.getName());
        });

        open.setOnAction(event -> {
            //open File that user has choosen
            fileOpend = fileChooser.showOpenDialog(stage);
            //adding the content of the file to the textArea
            try {
                String contents = new Scanner(fileOpend).useDelimiter("\\Z").next();
                textArea.clear();
                textArea.setText(contents);
                stage.setTitle(fileOpend.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
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
