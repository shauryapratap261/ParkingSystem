package models;

public class Vehicle {

    private String type;
    private String regNo;
    private String color;
    private ParkingSlot parkingSlot;

    public Vehicle(String type, String regNo, String color) {
        this.type = type;
        this.regNo = regNo;
        this.color = color;
        this.parkingSlot = null;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
