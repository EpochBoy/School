import javafx.application.Application;

public class Calculator extends Application{


	public static void main(String[] args){

	}

	public void start(Stage primaryStage) throws Exception{

	TextField calcWindow = new TextField(); // Resultat Vindue

	Button addition = new Button("+"); // Additions Knap
	Button negere = new Button("-"); // Minus Knap

	BorderPane borderPane = new BorderPane();
	borderPane.setTop(calcInterface);

	HBox calcInterface = new HBox();
	calcInterface.getChildren().addAll();

	Scene scene = new Scene(borderPane);
	primaryStage.setScene(scene);
	primaryStage.show();


	}




}