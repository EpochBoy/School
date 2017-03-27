import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;





public class Simplefx extends Application{

	int buttonClick;

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception{

		Button button = new Button("Click me");
		button.setOnAction(buttonPressed ->{
			System.out.println("ANARCHISTS JOINED "+buttonClick+" YAY");
			buttonClick++;
		});

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(button);

		Scene scene = new Scene(borderPane, 200, 200);

		primaryStage.setScene(scene);

		primaryStage.show();

		primaryStage.setOnCloseRequest(event ->{
			event.consume();
			primaryStage.close();
		});
	}










}