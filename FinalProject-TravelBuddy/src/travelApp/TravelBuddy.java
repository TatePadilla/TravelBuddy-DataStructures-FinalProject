package travelApp;

import java.util.LinkedList;
import java.util.Queue;
/** This program is the implementation of a travel app that assists with planning your vacations and activities.
 * @author Tate Padilla
 * @version 1.0
 * @since 12/5/2024
*/
/*  
* OS: Windows 10
* IDE: eclipse 2024-09
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/


public class TravelBuddy {
	// Queue to manage tasks in proper order.
    private Queue<String> taskQueue = new LinkedList<>();
    private Trip trip;

    // Constructor
    public TravelBuddy(String destination, int days) {
        trip = new Trip(destination, days);
    }

    public void addTravelDetails(String type, String details) {
        trip.addBooking(new Booking(type, details));
    }

    public String addActivity(int day, String name, int time) {
        return trip.addActivity(day, new Activity(name, time));
    }

    public void viewTripDetails() {
        trip.viewDetails();
    }

    public String sortActivities() {
        return trip.sortActivitiesByTime();
    }

    public void addTask(String task) {
        taskQueue.offer(task);
    }

    public String viewTasks() {
    	if (taskQueue.size() == 0) {
    		return "No tasks have been added yet.";
    	}
    	else {
    		System.out.println("Tasks in order:");
            String tasks = "";
            // Flag to track the first task
            boolean isFirst = true; 

            for (String task : taskQueue) {
            	// If first task, do not include hyphen
                if (isFirst) {
                    tasks = task;
                    isFirst = false;
                } 
                else {
                    tasks += " - " + task; 
                }
            }
            return tasks;
    	}
    }
}
