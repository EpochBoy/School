package chat2;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by forneus on 20/09/16.
 */
public class LoginView extends Pane implements Runnable {

    private VBox loginVBox;
    private Button initializeServer;
    private Button initializeClient;
    private BorderPane loginView;
    private SceneInitializer sceneInitializer;
    private Server myServer = Server.getInstance();
    private static boolean heartbeat = true;
    private Thread heartThread;
    private boolean imAlive = true;

    public LoginView(SceneInitializer sceneInitializer) {

        loginView = new BorderPane();
        this.sceneInitializer = sceneInitializer;

        loginVBox = new VBox(50); // spacing = 10
        initializeServer = new Button("Initialize Server");
        initializeClient = new Button("Start Chatting");
        initializeServer.setPrefSize(200, 100);
        initializeClient.setPrefSize(200, 100);

        initializeClient.setOnMouseClicked(event -> this.sceneInitializer.changeScene("goToUsernameInput"));
        //initializeServer.setOnMouseClicked(event -> this.initializeServer.setText("Server Started"));
        initializeServer.setOnMouseClicked(this::serverStart);

        loginView.setPrefSize(499, 499);
        loginView.setStyle("-fx-border-color: black;");

        loginVBox.setAlignment(Pos.CENTER);

        loginVBox.getChildren().addAll(
                initializeClient,
                initializeServer
        );

        loginView.setCenter(loginVBox);

        this.getChildren().addAll(
                loginView
        );

    }

    private void serverStart(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            try {
                if (initializeServer.getText() == "Initialize Server") {
                    new Thread(()-> myServer.startServer()).start();
                    this.initializeServer.setText("Stop Server");
                    heartThread = new Thread(this);
                    heartThread.start();
                } else if (initializeServer.getText() == "Stop Server"){
                    myServer.stopServer();
                    myServer.currentThread().interrupt();
                    imAlive = false;
                    heartThread.interrupt();
                    this.initializeServer.setText("Initialize Server");
                }
            }catch (Exception e){
                System.out.println("server start e");
            }
        }
    }

    public void run(){
        while (imAlive){
            if (heartbeat){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Heartbeat");
            }
        }
    }


}
