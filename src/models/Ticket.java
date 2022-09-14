package models;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;

    public Ticket(String ticketId, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
