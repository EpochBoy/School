package chatprogram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by forneus on 06/09/16.
 */
public class Run extends Application {

    public static void main(String[] args) {

        launch(args);



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        primaryStage.setScene(new Scene(new ChatWindow(),1000,1000));
        primaryStage.setResizable(false);

        primaryStage.widthProperty().addListener(e -> {
            ((Resizable) primaryStage.getScene().getRoot()).updateLayout();
        });

        primaryStage.heightProperty().addListener(e -> {
            ((Resizable) primaryStage.getScene().getRoot()).updateLayout();
        });

        ((Resizable) primaryStage.getScene().getRoot()).updateLayout();
    }

}
