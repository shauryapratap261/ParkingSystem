package models;

public class ParkingSlot {
    private int slotID;
    private int floorID;
    private boolean isEmpty;
    private Vehicle vehicle;
    private String parkingSlotType;

    public ParkingSlot(int slotID, int floorID, String parkingSlotType) {
        this.slotID = slotID;
        this.floorID = floorID;
        this.isEmpty = true;
        this.vehicle = null;
        this.parkingSlotType = parkingSlotType;
    }

    public int getFloorID() {
        return floorID;
    }

    public void setFloorID(int floorID) {
        this.floorID = floorID;
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(String parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }
}
