import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;




public class Layoutfx extends Application{

	int buttonClick;

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{


		Button button = new Button("Click-a-me");
		TextField textField = new TextField();

		HBox hBox = new HBox();
		hBox.setStyle("-fx-background-color: #336699;");
		hBox.getChildren().addAll(button, textField);
		hBox.setSpacing(50);
		hBox.setPadding(new Insets(15, 12, 15, 12));

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(hBox);

		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.show();


		button.setOnAction(buttonPressed ->{
			textField.setText("GET AMD'ed");
			System.out.println("Click for more HBM! "+buttonClick+" RAM");
			textField.setText("0.00001 NM + Infinite HBM");
			buttonClick++;
		});


	}


}