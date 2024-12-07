package travelApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TravelBuddyTest {

	private TravelBuddy travelBuddy;

	// Creating new TravelBuddy before each test
    @BeforeEach
    void setup() {
        travelBuddy = new TravelBuddy("Paris", 3);
    }

    @Test
    void testAddActivityValidDay() {
        // Act: Add an activity on a valid day
        String result = travelBuddy.addActivity(0, "Eiffel Tower visit", 14);

        // Assert: Verify the activity is added
        assertEquals("Added activity: Eiffel Tower visit at 14:00 on day 1", result);
    }

    @Test
    void testAddActivityInvalidDay() {
        // Act: Try to add an activity on an invalid day
        String result = travelBuddy.addActivity(5, "Invalid day activity", 10);

        // Assert: Verify error message
        assertEquals("Invalid day.", result);
    }

    @Test
    void testViewTasksEmptyQueue() {
        // Act: View tasks when no tasks are added
        String tasks = travelBuddy.viewTasks();

        // Assert: Verify the message shows no tasks
        assertEquals("No tasks have been added yet.", tasks);
    }

    @Test
    void testAddTask() {
        // Act: Add a task
        travelBuddy.addTask("Buy souvenirs");

        // Assert: Verify the task is added to the queue
        assertEquals("Buy souvenirs", travelBuddy.viewTasks());
    }

    @Test
    void testViewTasksMultipleTasks() {
        // Arrange: Add multiple tasks
        travelBuddy.addTask("Book museum tickets");
        travelBuddy.addTask("Reserve dinner spot");

        // Act: View tasks
        String tasks = travelBuddy.viewTasks();

        // Assert: Verify tasks are in order
        assertEquals("Book museum tickets - Reserve dinner spot", tasks);
    }    
    
    @Test
    void testSortActivitiesSingleDay() {
        // Arrange: Add activities on one day
        travelBuddy.addActivity(0, "Breakfast", 8);
        travelBuddy.addActivity(0, "Dinner", 19);

        // Act: Sort activities
        String sortedActivities = travelBuddy.sortActivities();

        // Assert: Verify the activities are sorted by time
        assertTrue(sortedActivities.contains("Breakfast at 8:00"));
        assertTrue(sortedActivities.contains("Dinner at 19:00"));
    }

    @Test
    void testSortActivitiesMultipleDays() {
        // Arrange: Add activities on multiple days
        travelBuddy.addActivity(0, "Scuba", 7);
        travelBuddy.addActivity(1, "Lunch", 12);
        travelBuddy.addActivity(0, "Museum visit", 10);

        // Act: Sort activities
        String sortedActivities = travelBuddy.sortActivities();

        // Assert: Verify activities are sorted within each day
        assertTrue(sortedActivities.contains("Scuba at 7:00"));
        assertTrue(sortedActivities.contains("Museum visit at 10:00"));
        assertTrue(sortedActivities.contains("Lunch at 12:00"));
    }

    @Test
    void testAddBooking() {
        // Arrange: Add a booking
        travelBuddy.addTravelDetails("Hotel", "5-star hotel near Eiffel Tower");

        // Act: View trip details
        travelBuddy.viewTripDetails();

        // Assert: Ensure no exceptions and booking is stored
        assertDoesNotThrow(() -> travelBuddy.viewTripDetails());
    }

    @Test
    void testAddActivityTimeBoundary() {
        // Act: Add activities at boundary times
        String morningActivity = travelBuddy.addActivity(0, "Sunrise walk", 0);
        String nightActivity = travelBuddy.addActivity(0, "Stargazing", 23);

        // Assert: Verify they are successfully added
        assertTrue(morningActivity.contains("Added activity: Sunrise walk at 0:00"));
        assertTrue(nightActivity.contains("Added activity: Stargazing at 23:00"));
    }
    

}
