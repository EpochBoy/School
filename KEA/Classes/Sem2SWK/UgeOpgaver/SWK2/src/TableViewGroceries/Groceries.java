package TableViewGroceries;

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
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.TableColumn.CellEditEvent;


public class Groceries extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception{

        ObservableList<GroceryItemOrder> groceries = FXCollections.observableArrayList(new GroceryItemOrder("Banan", 5, 7.5));
        TableView<GroceryItemOrder> tableView = new TableView<>();

        tableView.itemsProperty().setValue(groceries);

        TableColumn<GroceryItemOrder, String> nameColumn = new TableColumn<>("Grocery Item");
        TableColumn<GroceryItemOrder, Integer> quantityColumn = new TableColumn<>("Quantity");
        TableColumn<GroceryItemOrder, Double> pricePerUnitColumn = new TableColumn<>("Price");

        //nameColumn.setCellValueFactory(e -> e.getValue().getName());
       // quantityColumn.setCellValueFactory(e -> e.getValue().quantity());
       // pricePerUnitColumn.setCellValueFactory(e -> e.getValue().pricePerUnit());

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        pricePerUnitColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));


        nameColumn.setOnEditCommit((CellEditEvent<GroceryItemOrder, String> event) -> {
            ((GroceryItemOrder) event.getTableView().getItems().get(event.getTablePosition().getRow())).setName(event.getNewValue());
        });

        quantityColumn.setOnEditCommit((CellEditEvent<GroceryItemOrder, Integer> event) -> {
            ((GroceryItemOrder) event.getTableView().getItems().get(event.getTablePosition().getRow())).setQuantity((Integer)event.getNewValue());
        });

        pricePerUnitColumn.setOnEditCommit((CellEditEvent<GroceryItemOrder, Double> event) -> {
            ((GroceryItemOrder) event.getTableView().getItems().get(event.getTablePosition().getRow())).setPricePerUnit((Double)event.getNewValue());
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