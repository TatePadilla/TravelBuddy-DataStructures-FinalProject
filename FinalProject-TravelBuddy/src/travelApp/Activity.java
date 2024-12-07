package travelApp;

// Activity class represents the activities planned for the trip.
class Activity {
	// Activity name.
    private String name;
    
    // Activity time in 24-hour format for simplicity.
    private int time;  

    // Constructor
    public Activity(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + " at " + time + ":00";
    }
}
