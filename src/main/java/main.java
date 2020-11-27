import Scenes.Editor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //title of the window
        primaryStage.setTitle("Simple Code Editor");

        Label label = new Label("Hello World!");

        StackPane root = new StackPane();

        //adding elements to the root Pane
        root.getChildren().add(label);

        Editor editor = new Editor();
        Scene scene = editor.mainScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
