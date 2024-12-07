package travelApp;

import java.util.Scanner;

// UserInterface class contains all logic for user interface as well as majority of input validation.
public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get destination input from user
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        
        int days = 0;
        while (true) {
            System.out.print("Enter number of days for trip: ");
            try {
                days = scanner.nextInt();
                
                // Take newline
                scanner.nextLine(); 
                if (days > 0) {
                    break;
                } 
                else {
                    System.out.println("Number of days must be positive.");
                }
                // Ensuring valid input only (incase of issue with nextInt)
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.nextLine(); // Clear invalid input
            }
            scanner.close();
        }

        TravelBuddy app = new TravelBuddy(destination, days);

     // Prompting user for choice above
        int choice = 0;
        
        while (choice != 7) {
            System.out.println("---------------------------\nTravel Buddy Menu:");
            System.out.println("1 = Add Travel Details (Flight, Hotel, Rental, etc.)");
            System.out.println("2 = Add Activity");
            System.out.println("3 = View Trip Details");
            System.out.println("4 = View Tasks");
            System.out.println("5 = Add Task");
            System.out.println("6 = Sort Activities by Time");
            System.out.println("7 = Exit");

            while (true) {
                System.out.print("Enter your choice: ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    // If choice is inside valid range, break
                    if (choice >= 1 && choice <= 7) {
                        break;
                    } 
                    else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    scanner.nextLine(); // Clear invalid input
                }
            }

            // Determining output based on choice input above
            switch (choice) {
            	// Add Travel Details
                case 1:
                    System.out.print("Enter type (Flight, Hotel, etc.): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter details: ");
                    String details = scanner.nextLine();
                    app.addTravelDetails(type, details);
                    break;
                    
                // Add Activity (with validation)
                case 2:
                	int day = -1;
                    while (true) {
                        System.out.print("Enter day of trip (1 - " + days + "): ");
                        if (scanner.hasNextInt()) {
                            day = scanner.nextInt();
                            scanner.nextLine(); // Clear the buffer
                            
                            // Validate range
                            if (day >= 1 && day <= days) {
                                day--; // Convert to 0-based index
                                break;
                            } else {
                                System.out.println("Invalid day. Please enter a number between 1 and " + days + ".");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number between 1 and " + days + ".");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }

                    System.out.print("Enter activity name: ");
                    String name = scanner.nextLine();

                    int activityTime = -1;
                    while (activityTime < 0) {
                        System.out.print("Enter time (0 - 23): ");
                        try {
                        	activityTime = scanner.nextInt();
                            scanner.nextLine();
                            if (activityTime >= 0 && activityTime <= 23) {
                                break;
                            } 
                            else {
                                System.out.println("Invalid time. Please enter a number between 0 and 23.");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a number between 0 and 23.");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }

                    app.addActivity(day, name, activityTime);
                    break;

                // View Trip Details
                case 3:
                    app.viewTripDetails();
                    break;
                
                // View Tasks
                case 4:
                    String tasks = app.viewTasks();
                    System.out.println(tasks);
                    break;

                // Add Task
                case 5:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    app.addTask(task);
                    break;
                
                // View sorted activities
                case 6:
                	String sortedActivities = app.sortActivities();
                    System.out.println(sortedActivities);
                    break;
                    
                // Exit
                case 7:
                    System.out.println("Exiting Travel Buddy.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
