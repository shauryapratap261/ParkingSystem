package models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int totalFloors;
    private int slotsPerFloor;
    private String id;
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(int totalFloors, int slotsPerFloor, String id) {
        this.totalFloors = totalFloors;
        this.slotsPerFloor = slotsPerFloor;
        this.id = id;
        this.parkingFloors = new ArrayList<>();
        initialiseAllFloors();
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public int getSlotsPerFloor() {
        return slotsPerFloor;
    }

    public void setSlotsPerFloor(int slotsPerFloor) {
        this.slotsPerFloor = slotsPerFloor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    private void initialiseAllFloors(){

        for(int i = 0;i<totalFloors;i++){
            parkingFloors.add(new ParkingFloor(i+1,slotsPerFloor));
        }

    }
}
