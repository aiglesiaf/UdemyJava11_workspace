package com.angel.todolistapp;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.angel.todolistapp.model.TodoItem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

public class MainController {
	
	@FXML
	private ListView<TodoItem> todoListView = new ListView<TodoItem>();
	
	@FXML
	private TextArea detailsTextArea = new TextArea();
	
	@FXML
	private Label dueDateLabel = new Label();
	
	
	
	public MainController() {
		super();
		initialize();
	}



	public void initialize()
	{
		
		List<TodoItem> todoList = new ArrayList<TodoItem>();
		TodoItem item1 = 
				new TodoItem("Go to the supermarket", 
						"Buy milk, bread and butter from the superMarket", 
						LocalDate.of(2020, Month.DECEMBER, 20));
		TodoItem item2 = 
				new TodoItem("Go to the hairdresser", 
						"Go to get a haircut", 
						LocalDate.of(2020, Month.DECEMBER, 20));
		TodoItem item3 = 
				new TodoItem("Go to Madrid", 
						"Take some pictures around Madrid", 
						LocalDate.of(2020, Month.DECEMBER, 20));
		
		todoList.add(item1);
		todoList.add(item2);
		todoList.add(item3);
		
		todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {

			@Override
			public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
				TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
				detailsTextArea.setText(selectedItem.getDetails());
				dueDateLabel.setText(selectedItem.getDeadLine().toString());
			}
		});
		
		todoListView.getItems().addAll(todoList);
		todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		todoListView.getSelectionModel().selectFirst();
		
	}
	
	/*public void handleTodoItemSelected()
	{
		TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
		//System.out.println(selectedItem.getDetails());
		detailsTextArea.setText(selectedItem.getDetails());
		dueDateLabel.setText(selectedItem.getDeadLine().toString());
		
	}*/
	
	

	
	
	
}
