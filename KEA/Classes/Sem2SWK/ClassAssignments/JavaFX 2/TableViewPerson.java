
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Cell;
import javafx.scene.control.TableView;






public class TableViewPerson extends Application{


	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception{

		ObservableList<Person> persons = FXCollections.observableArrayList(new Person("Signe","Borch","Teacher"),new Person("Asger","Clausen","Teacher"));

		TableView<Person> tableView = new TableView<>();
		TableView.itemsProperty().setValue(persons);

		TableColumn<Person, String> firstName = new TableColumn<>("First name");
		TableColumn<Person, String> lastName = new TableColumn<>("Last Name");
		TableColumn<Person, String> job = new TableColumn<>("Job");

		// Not necessary with <Person, String>, redundant due to java 8 update.
		firstName.setCellValueFactory(new PropertyValueFacotry<Person, String>"firstName");
		firstName.setCellValueFactory(new PropertyValueFacotry<Person, String>"lastName");
		job.setCellValueFactory(new PropertyValueFacotry<Person, String>"job");

		tableView.getColumns().addAll(firstName, lastName, job);
		StackPane pane = new StackPane();
		pane.getChildren().add(tableView);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Persons");
		//primaryStage.setWidth(300);
		//primaryStage.setHeight(200);
		primaryStage.show();



	}
}