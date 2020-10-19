//*******************************************************
// Task.java		
// Author: Prakash Acharya
//*******************************************************

import java.time.*;

public class Task implements Comparable<Task>{
	
	private String taskName;
	private LocalTime taskTime;
	private LocalDate taskDate;
	
	public Task(String taskName, LocalDate taskDate, LocalTime taskTime) {
		this.taskName = taskName;
		this.taskDate = taskDate;
		this.taskTime = taskTime;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public LocalTime getTime() {
		return taskTime;
	}

	public void setTime(LocalTime time) {
		this.taskTime = time;
	}

	public LocalDate getDate() {
		return taskDate;
	}

	public void setDate(LocalDate date) {
		this.taskDate = date;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += taskName + " " + taskDate + " " + (taskTime.getHour() < 10 ? "0" + taskTime.getHour() :  + taskTime.getHour()) +
				":" + taskTime.getMinute();
		return str;
	}
	
	@Override
	public int compareTo(Task task) {
		
		return taskTime.compareTo(task.taskTime);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Task) {
			Task task = (Task) obj;
			return taskName.equals(task.taskName) && taskTime.equals(task.taskTime) && 
					taskDate.equals(task.taskDate);
		}
		return false;
	}
	
}
