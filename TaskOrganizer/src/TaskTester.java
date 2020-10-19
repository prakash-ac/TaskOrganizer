import java.time.*;
import java.util.*;
public class TaskTester {

	public static void main(String[] args) {
		
		ArrayList<Task> taskList = new ArrayList<Task>();
		
		for(int i=0;i<5;i++) {
			String taskName = "Demo Task " + i;
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			Task task = new Task(taskName, date, time);
			taskList.add(task);
			
		}
		
		for(Task t: taskList) {
			System.out.println(t);
		}

	}

}
