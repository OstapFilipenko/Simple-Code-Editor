import Scenes.Editor;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.geom.RectangularShape;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //title of the window
        primaryStage.setTitle("Simple Code Editor");
        //width and height of Stage
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        Label label = new Label("Hello World!");

        StackPane root = new StackPane();

        //adding elements to the root Pane
        root.getChildren().add(label);

        Editor editor = new Editor(primaryStage);
        Scene scene = editor.mainScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
