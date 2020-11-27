package Scenes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Editor {
    public TextArea textArea = new TextArea();

    public Scene mainScene(){
        VBox root = new VBox();

        //disable scroll in x axis
        textArea.setWrapText(true);

        //createting menu
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem open = new MenuItem("Open File");
        MenuItem save = new MenuItem("Save");
        file.getItems().addAll(open, save);
        menuBar.getMenus().addAll(file);
        //MenuItem newFile = new MenuItem("New");
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                saveFile();
            }
        });

        root.getChildren().addAll(menuBar, textArea);
        return new Scene(root, 300, 275);
    }


    public void saveFile() {
        String sb = textArea.getText();
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save File");
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
                fw.write(sb);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
