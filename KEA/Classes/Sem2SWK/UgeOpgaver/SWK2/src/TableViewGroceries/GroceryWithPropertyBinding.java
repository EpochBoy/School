package TableViewGroceries;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;


public class GroceryWithPropertyBinding extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<GroceryItemOrderWithProperties> groceries = FXCollections.observableArrayList(new GroceryItemOrderWithProperties("Banan", 5, 7.5));
        TableView<GroceryItemOrderWithProperties> tableView = new TableView<>();

        tableView.itemsProperty().setValue(groceries);

        TableColumn<GroceryItemOrderWithProperties, String> nameColumn = new TableColumn<>("Grocery Item");
        TableColumn<GroceryItemOrderWithProperties, Number> quantityColumn = new TableColumn<>("Quantity");
        TableColumn<GroceryItemOrderWithProperties, Number> pricePerUnitColumn = new TableColumn<>("Price");

        nameColumn.setCellValueFactory(e -> e.getValue().nameProperty());
        quantityColumn.setCellValueFactory(e -> e.getValue().quantityProperty());
        pricePerUnitColumn.setCellValueFactory(e -> e.getValue().pricePerUnitProperty());

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        pricePerUnitColumn.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));


        nameColumn.setOnEditCommit((CellEditEvent<GroceryItemOrderWithProperties, String> event) -> {
            ((GroceryItemOrderWithProperties) event.getTableView().getItems().get(event.getTablePosition().getRow())).setName(event.getNewValue());
        });

        quantityColumn.setOnEditCommit((CellEditEvent<GroceryItemOrderWithProperties, Number> event) -> {
            ((GroceryItemOrderWithProperties) event.getTableView().getItems().get(event.getTablePosition().getRow())).setQuantity((Integer) event.getNewValue());
        });

        pricePerUnitColumn.setOnEditCommit((CellEditEvent<GroceryItemOrderWithProperties, Number> event) -> {
            ((GroceryItemOrderWithProperties) event.getTableView().getItems().get(event.getTablePosition().getRow())).setPricePerUnit((Double) event.getNewValue());
        });

        tableView.setEditable(true);
        tableView.getColumns().addAll(nameColumn, quantityColumn, pricePerUnitColumn);

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