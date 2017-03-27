import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by signeborch on 07/03/16.
 */
public class TableViewWithPropertyBinding extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // making an ObservableList with Person objects and connecting it to a TableView
        ObservableList<PersonWithProperties> persons = FXCollections.observableArrayList(new PersonWithProperties("Signe", "Borch", "Teacher"), new PersonWithProperties("Asger", "Clausen", "Teacher"));

        TableView<PersonWithProperties> tableView = new TableView<>();
        tableView.itemsProperty().setValue(persons);

        // making the columns
        TableColumn<PersonWithProperties, String> firstName = new TableColumn<>("First name");
        TableColumn<PersonWithProperties, String> lastName = new TableColumn<>("Last name");
        TableColumn<PersonWithProperties, String> job = new TableColumn<>("Job");

        //if you are using reflection instead of properties to connect columns to the Person objects in the ObservableList
/*
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
*/

        // connecting columns and Person objects via property binding
        firstName.setCellValueFactory(e -> e.getValue().firstNameProperty());
        lastName.setCellValueFactory(e -> e.getValue().lastNameProperty());
        job.setCellValueFactory(e -> e.getValue().jobProperty());

        //making the cells in the columns editable
        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        job.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.setEditable(true);

        tableView.getColumns().addAll(firstName, lastName, job);

        StackPane pane = new StackPane();
        pane.getChildren().add(tableView);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Persons");
        // primaryStage.setWidth(300);
        //primaryStage.setHeight(200);
        primaryStage.show();


    }
}
