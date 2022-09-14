package models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorID;
    private int slotsPerFloor;
    List<ParkingSlot>parkingSlots;

    public ParkingFloor(int floorID, int slotsPerFloor) {
        this.floorID = floorID;
        this.slotsPerFloor = slotsPerFloor;
        this.parkingSlots = new ArrayList<>();
        initialiseParkingFloor(floorID);
    }

    public int getSlotsPerFloor() {
        return slotsPerFloor;
    }

    public void setSlotsPerFloor(int slotsPerFloor) {
        this.slotsPerFloor = slotsPerFloor;
    }

    public int getFloorId() {
        return floorID;
    }

    public void setFloorID(int floorNo) {
        this.floorID = floorNo;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    private void initialiseParkingFloor(int floorID){

        if(slotsPerFloor == 0){
            System.out.println("No slots present on floor");
        }

        int currentSlotIndex = 1;
//        System.out.println("parkingSlots " + parkingSlots.size());
//        System.out.println("slotsPerFloor " + slotsPerFloor);

        parkingSlots.add(new ParkingSlot(currentSlotIndex++, floorID, "TRUCK"));

        while(currentSlotIndex <=3 && currentSlotIndex < slotsPerFloor){
            parkingSlots.add(new ParkingSlot(currentSlotIndex++, floorID, "BIKE"));
        }

        while(currentSlotIndex <= slotsPerFloor){
            parkingSlots.add(new ParkingSlot(currentSlotIndex++, floorID, "CAR"));
        }

    }
}
