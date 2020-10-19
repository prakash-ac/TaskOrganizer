//*******************************************************
// TaskOrganizerUserInterface.java		
// Author: Prakash Acharya
//*******************************************************

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class TaskOrganizerUserInterface {
	
	private Text greetingText, taskNameInputLabel, datePickerLabel, timeSpinnerLabel;
	private HBox greetingBox, taskListBox, taskInputHBox, dateTimeHBox;
	private VBox rootVBox, taskInputVBox;
	private TextField task;
	private TextArea taskList;
	private Spinner hourSpinner, minuteSpinner;
	private DatePicker date;
	private Button todayTaskButton, weekTaskButton, allTaskButton, createTaskButton, saveButton; 
	
	
	public TaskOrganizerUserInterface() {
		
		// root node
		rootVBox = new VBox();
		rootVBox.setStyle("-fx-background-color: transparent");
		
		// greet user based on time of the day
		greetingText = new Text();
		
		String userNameRaw = System.getProperty("user.name");
		String userName = userNameRaw.substring(0, 1).toUpperCase() + userNameRaw.substring(1);
		String dayOfWeekRaw = LocalDate.now().getDayOfWeek().toString();
		String dayOfWeek = dayOfWeekRaw.substring(0, 1) + dayOfWeekRaw.substring(1).toLowerCase();
		String monthRaw = LocalDate.now().getMonth().toString();
		String month = monthRaw.substring(0, 1) + monthRaw.substring(1).toLowerCase();
		
		
		String dateTimeInfo = "Today is "  + dayOfWeek + ", " +
				month + " " + LocalDateTime.now().getDayOfMonth() + ".";
		
		int hour = LocalTime.now().getHour();
		if(hour<12) {
			greetingText.setText("Good morning, " + userName + "! " + dateTimeInfo);
		} else if(hour >= 12 && hour < 17){
			greetingText.setText("Good afternoon, " + userName + "! " + dateTimeInfo);
		} else {
			greetingText.setText("Good evening, " + userName + "! " + dateTimeInfo);
		}
		
		greetingBox = new HBox(greetingText);
		greetingBox.setAlignment(Pos.TOP_RIGHT);
		greetingBox.setPadding(new Insets(20, 20, 30, 20));
		rootVBox.getChildren().add(greetingBox);
		
		// buttons that will allow users to display today's, this week's and all tasks
		todayTaskButton = new Button("Today's Tasks");
		weekTaskButton = new Button("This Week's Tasks");
		allTaskButton = new Button("All Buttons");
		
		// HBox that hosts taskList buttons
		taskListBox = new HBox(todayTaskButton, weekTaskButton, allTaskButton);
		//taskListBox.setPadding(new Insets(0, 0, 0, 10));
		rootVBox.getChildren().add(taskListBox);
		
		// Text Area where the task lists will be displayed
		taskList = new TextArea();
		taskList.setMaxHeight(300);
		taskList.setPadding(new Insets(0, 0, 0, 10));
		taskList.setEditable(false);
		rootVBox.getChildren().add(taskList);
		
		// this will enable users to create new tasks
		createTaskButton = new Button("New Task");
		rootVBox.getChildren().add(createTaskButton);
		
		// text field to input task name
		taskNameInputLabel = new Text("Task");
		task = new TextField("");
		task.setMinWidth(240);
		taskInputHBox = new HBox(taskNameInputLabel, task);
		taskInputHBox.setSpacing(10);
		
		// let users pick date the task;
		datePickerLabel = new Text("Day");
		//datePickerLabel.setTextOrigin(VPos.CENTER);
		date = new DatePicker();
		date.setMaxWidth(150);
		date.setEditable(true);
		
		// let users pick hour and minute
		timeSpinnerLabel = new Text("Time");
		//timeSpinnerLabel.setTextAlignment(TextAlignment.CENTER);
		hourSpinner = new Spinner(0, 23, 0);
		hourSpinner.setMaxWidth(75);
		hourSpinner.setEditable(true);
		minuteSpinner = new Spinner(0, 59, 0);
		minuteSpinner.setMaxWidth(75);
		minuteSpinner.setEditable(true);
		dateTimeHBox = new HBox(datePickerLabel, date, timeSpinnerLabel, hourSpinner, minuteSpinner);
	
		dateTimeHBox.setSpacing(10);
		
		// button that allows to save the task
		saveButton = new Button("Save");
		
		
		// group taskInputHBox and dateTimeHBox, and save button in a VBox 
		taskInputVBox = new VBox(taskInputHBox, dateTimeHBox, saveButton);
		taskInputVBox.setSpacing(10);
		taskInputVBox.setPadding(new Insets(20, 0, 0, 20));
		rootVBox.getChildren().add(taskInputVBox);
		
	}
	
	public Parent getParent() {
		return rootVBox;
	}
	
	public LocalTime getTime() {
		return LocalTime.of((int)hourSpinner.getValue(), (int)minuteSpinner.getValue());
	}
	
	public LocalDate getDate() {
		return date.getValue();
	}
	
	public String getTask() {
		return task.getText();
	}
	
	public void setTodayTaskButtonAction(EventHandler<ActionEvent> handler) {
		todayTaskButton.setOnAction(handler);
	}
	
	public void setWeekTaskButtonAction(EventHandler<ActionEvent> handler) {
		weekTaskButton.setOnAction(handler);
	}
	
	public void setAllTaskButtonAction(EventHandler<ActionEvent> handler) {
		allTaskButton.setOnAction(handler);
	}
	
	public void setCreateTaskButtonAction(EventHandler<ActionEvent> handler) {
		createTaskButton.setOnAction(handler);
	}
	
	public void setSaveButtonAction(EventHandler<ActionEvent> handler) {
		saveButton.setOnAction(handler);
	}
	
}
