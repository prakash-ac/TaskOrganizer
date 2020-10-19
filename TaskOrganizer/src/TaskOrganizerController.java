import javafx.application.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class TaskOrganizerController extends Application{
	private TaskOrganizerUserInterface taskOrganizerUserInterface; 

	public TaskOrganizerController() {
		taskOrganizerUserInterface = new TaskOrganizerUserInterface();
		
		taskOrganizerUserInterface.setTodayTaskButtonAction(this::displayTodayTasks);
		taskOrganizerUserInterface.setWeekTaskButtonAction(this::displayWeekTasks);
		taskOrganizerUserInterface.setAllTaskButtonAction(this::displayAllTasks);
		taskOrganizerUserInterface.setSaveButtonAction(this::saveTask);
	}
	
	@Override
	public void start(Stage primaryStage) {
		TaskOrganizerController controller = new TaskOrganizerController();
		Scene scene = new Scene(controller.taskOrganizerUserInterface.getParent(), 600, 600, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Task Organizer");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);

	}
	
	public void displayTodayTasks(ActionEvent event) {
		
	}
	
	public void displayWeekTasks(ActionEvent event) {
		
	}
	
	public void displayAllTasks(ActionEvent event) {
		
	}
	
	public void saveTask(ActionEvent event) {
		
	}

}
