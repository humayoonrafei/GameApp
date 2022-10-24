import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameApp extends Application {

    private static final int APP_WIDTH = 400;
    private static final int APP_HEIGHT = 800;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group gRoot = new Group();

        Scene scene = new Scene(gRoot,APP_WIDTH,APP_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("GameAPP");
        scene.setFill(Color.BLACK);


        primaryStage.show();

    }
}

