import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class Calculator extends Application {


    int calcNumber1;
    int calcNumber2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Calculator");

        Button addition = new Button("+"); // Additions Knap

        Button negere = new Button("-"); // Minus Knap

        TextField calcWindow = new TextField(); // Resultat Vindue
        calcWindow.setPrefWidth(400);

        HBox calcInterface = new HBox();
        calcInterface.setStyle("-fx-background-color: #336699;");
        calcInterface.setSpacing(50);
        calcInterface.setPadding(new Insets(15, 12, 15, 12));
        calcInterface.getChildren().addAll(addition, negere, calcWindow);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(calcInterface);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        addition.setOnAction(buttonPressed -> {
            if (calcNumber1 == 0) {
                try{
                    calcNumber1 = Integer.parseInt(calcWindow.getText());
                }catch(NumberFormatException exception){
                    calcWindow.setText("Please input Integer");
                }
                calcWindow.setPromptText("Please input number");
            } else {
                calcNumber2 = Integer.parseInt(calcWindow.getText());
                calcWindow.setText("" + (calcNumber1 + calcNumber2));
                reset();
            }
        });

        negere.setOnAction(buttonPressed -> {
            if (calcNumber1 == 0) {
                try {
                    calcNumber1 = Integer.parseInt(calcWindow.getText());
                }catch(NumberFormatException exception){
                    calcWindow.setText("Please input Integer");
                }
                calcWindow.setPromptText("Please input number");
            } else {
                calcNumber2 = Integer.parseInt(calcWindow.getText());
                calcWindow.setText(""+(calcNumber1 - calcNumber2));
                reset();
                }
            });
        }

    public void reset(){
        calcNumber1 = 0;
        calcNumber2 = 0;
    }

    }