package chat2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by forneus on 20/09/16.
 */
public class Run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Window) throws Exception{

        SceneInitializer kor = new SceneInitializer();
        kor.initialize(Window);
    }

}
