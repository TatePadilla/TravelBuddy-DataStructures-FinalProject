package travelApp;

import java.util.ArrayList;

class Trip {
    private String destination;
    private ArrayList<Booking> bookings;
    
    // Array of ArrayLists for multiple activities per day
    private ArrayList<Activity>[] activities; 

    // Constructor
    public Trip(String destination, int days) {
        this.destination = destination;
        bookings = new ArrayList<>();
        activities = new ArrayList[days];

        // Initialize each day's activity list
        for (int i = 0; i < days; i++) {
            activities[i] = new ArrayList<>();
        }
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Method to add activities
    public String addActivity(int day, Activity activity) {
    	// If day is above 0 and less than the total days input
        if (day >= 0 && day < activities.length) {
            activities[day].add(activity);
            return "Added activity: " + activity + " on day " + (day + 1);
        } else {
            return "Invalid day.";
        }
    }

    // Method used to view details of trips
    public void viewDetails() {
        System.out.println("Destination: " + destination);
        
        // Displaying bookings by looping through them
        System.out.println("Bookings:");
        for (Booking booking : bookings) {
            System.out.println("  - " + booking);
        }
        
        // Displaying activities for trip
        System.out.println(sortActivitiesByTime());
    }

    public String sortActivitiesByTime() {
        StringBuilder sortedActivities = new StringBuilder("Sorted Activities:\n");

        for (int day = 0; day < activities.length; day++) {
            // Apply selection sort to the list of activities for each day
            for (int i = 0; i < activities[day].size() - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < activities[day].size(); j++) {
                    if (activities[day].get(j).getTime() < activities[day].get(minIndex).getTime()) {
                        minIndex = j;
                    }
                }
                // Swap the activities to place the smallest time first
                if (minIndex != i) {
                    Activity temp = activities[day].get(i);
                    activities[day].set(i, activities[day].get(minIndex));
                    activities[day].set(minIndex, temp);
                }
            }

            // Append sorted activities for the current day
            sortedActivities.append("Day ").append(day + 1).append(":\n");
            if (activities[day].isEmpty()) {
                sortedActivities.append("  No activities planned.\n");
            } 
            else {
                for (Activity activity : activities[day]) {
                    sortedActivities.append("  ").append(activity).append("\n");
                }
            }
        }

        return sortedActivities.toString();
    }

}
