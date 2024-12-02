package travelApp;

class Booking {
	// Type of booking (flight, hotel, car rental).
    private String type; 
    // Details of booking.
    private String details;

    // Constructor
    public Booking(String type, String details) {
        this.type = type;
        this.details = details;
    }

    @Override
    public String toString() {
        return type + ": " + details;
    }
}
