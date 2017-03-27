import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.TableColumn.CellEditEvent;

/**
 * Created by signeborch on 08/03/16.
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
        ObservableList<PersonWithProperties> persons = FXCollections.observableArrayList(new PersonWithProperties("Samuel", "Jackson", "Developer", 45), new PersonWithProperties("Jonathan", "White", "Chef", 29));
        TableView<PersonWithProperties> tableView = new TableView<>();

        tableView.itemsProperty().setValue(persons);

        TableColumn<PersonWithProperties, String> firstName = new TableColumn<>("First name");
        TableColumn<PersonWithProperties, String> lastName = new TableColumn<>("Last name");
        TableColumn<PersonWithProperties, String> job = new TableColumn<>("Job");
        TableColumn<PersonWithProperties, Number> age = new TableColumn<>("Age");

        firstName.setCellValueFactory(e -> e.getValue().firstNameProperty());
        lastName.setCellValueFactory(e -> e.getValue().lastNameProperty());
        job.setCellValueFactory(e -> e.getValue().jobProperty());
        age.setCellValueFactory(e -> e.getValue().ageProperty());


        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        job.setCellFactory(TextFieldTableCell.forTableColumn());
        age.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()
        ));

        firstName.setOnEditCommit((CellEditEvent<PersonWithProperties, String> event) -> {
            ((PersonWithProperties) event.getTableView().getItems().get(event.getTablePosition().getRow())).setFirstName(event.getNewValue());
        });

        lastName.setOnEditCommit((CellEditEvent<PersonWithProperties, String> event) -> {
            ((PersonWithProperties) event.getTableView().getItems().get(event.getTablePosition().getRow())).setLastName(event.getNewValue());
        });

        job.setOnEditCommit((CellEditEvent<PersonWithProperties, String> event) -> {
            ((PersonWithProperties) event.getTableView().getItems().get(event.getTablePosition().getRow())).setJob(event.getNewValue());
        });

        age.setOnEditCommit((CellEditEvent<PersonWithProperties, Number> event) -> {
            ((PersonWithProperties) event.getTableView().getItems().get(event.getTablePosition().getRow())).setAge(((Integer)event.getNewValue()));
        });

        tableView.setEditable(true);
        tableView.getColumns().addAll(firstName, lastName, job, age);

        StackPane pane = new StackPane();
        pane.getChildren().add(tableView);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Persons");
        primaryStage.setHeight(200);
        primaryStage.setWidth(300);
        primaryStage.show();

    }
}
