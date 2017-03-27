/**
 * Created by Rasmus Reiler on 26-02-2016.
 * Computer Science at KEA.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane);
    HBox hBox = new HBox();
    HBox hBox2 = new HBox();
    HBox hBox3 = new HBox();
    VBox vBox = new VBox();
    Label prompt = new Label();
    TextField userName = new TextField();
    Button button = new Button("Go");
    Button changeScene = new Button("Change scene");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Layout
        vBox.getChildren().addAll(hBox, hBox2, hBox3, changeScene);
        hBox.getChildren().addAll(prompt);
        hBox2.getChildren().addAll(userName);
        hBox3.getChildren().addAll(button);
        vBox.setSpacing(5);
        hBox.setSpacing(15);
        hBox.setPadding(new Insets(10, 50, 10, 65));
        hBox2.setPadding(new Insets(10, 50, 10, 50));
        hBox3.setPadding(new Insets(10,50,10,120));
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);

        // Calls
        prompt.setText("Enter your name please");
        button.setOnAction(e -> {
                    prompt.setText("Hello, " + userName.getText());
                }
        );
        changeScene.setOnAction(e -> {
            sceneSecond(primaryStage);
        });


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void sceneSecond(Stage primaryStage) {
        // Layout
        BorderPane borderPane2 = new BorderPane();
        Scene scene2 = new Scene(borderPane2);
        HBox hBoxSceneTwo = new HBox();
        VBox vBoxSceneTwo = new VBox();
        vBoxSceneTwo.getChildren().addAll(hBoxSceneTwo, changeScene);
        hBoxSceneTwo.getChildren().addAll(prompt);

        prompt.setText("You changed to another scene");


        borderPane2.setTop(hBoxSceneTwo);
        primaryStage.setScene(scene2);
        primaryStage.setResizable(true);
        double i = 500;
        primaryStage.setWidth(i);
        primaryStage.setHeight(i);
    }
}