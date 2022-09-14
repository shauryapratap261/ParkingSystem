package Controller;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {

    private ParkingLot parkingLot;
    Map<String, Vehicle> ticketNoToVehicle;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        ticketNoToVehicle = new HashMap<>();
    }

    public void createParkingLot(String id, int totalFloors, int slotsPerFloor){

        this.parkingLot = new ParkingLot(totalFloors, slotsPerFloor, id);
        System.out.println("Created parking lot with" +  totalFloors + " floors and " + slotsPerFloor + " slots per floor");

    }

    public void parkVehicle(Vehicle vehicle){
        // 1. park the vehicle on the lowest floor and lowest slot
        ParkingSlot parkingSlot = findNearestParkingSlot(vehicle.getType());

        if(parkingSlot == null){
            System.out.println("Parking Lot Full");
            return;
        }
        parkingSlot.setEmpty(false);
        vehicle.setParkingSlot(parkingSlot);
        // 2. generate a ticket
        String ticketID = parkingLot.getId() + "_" + + parkingSlot.getFloorID() + "_" + parkingSlot.getSlotID();
        Ticket ticket = new Ticket(ticketID, vehicle);
        ticketNoToVehicle.put(ticket.getTicketId(), vehicle);
        System.out.println("Parked vehicle. Ticket ID: " + ticketID);

    }

    private ParkingSlot findNearestParkingSlot(String vehicleType){

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()){
                if(parkingSlot.isEmpty() && parkingSlot.getParkingSlotType().equals(vehicleType)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }


    public void unParkVehicle(String ticketNo){

        Vehicle vehicle = ticketNoToVehicle.get(ticketNo);
        // Invalid ticket case1 - when no vehicle is there
        if(vehicle == null){
            System.out.println("Invalid Ticket");
            return;
        }

        // Invalid ticket case2 - when the slot is already empty
        String [] details = ticketNo.split("_") ;
        int floorNo = Integer.parseInt(details[1]);
        int slotNo = Integer.parseInt(details[2]);

        if(parkingLot.getParkingFloors().get(floorNo-1).getParkingSlots().get(slotNo-1).isEmpty()){
            System.out.println("Invalid Ticket");
            return;
        }

        // 1. set the parkingSlot of the vehical as null and set parkingSlot as empty
        vehicle.getParkingSlot().setEmpty(true);
        vehicle.setParkingSlot(null);

        System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegNo() + "and color: " + vehicle.getColor());
    }

    public void display(String commandType, String vehicleType){

        // 3 cases
        if(commandType.equals("free_count")){
            displayFreeCount(vehicleType);
        } else if(commandType.equals("free_slots")){
            displayFreeSlots(vehicleType);
        } else if(commandType.equals("occupied_slots")){
            displayOcuupiedSlots(vehicleType);
        }
    }

    private void displayFreeCount(String vehicleType){
        List<ParkingFloor>parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor : parkingFloors){
            displayFreeCountOnEachFloor(parkingFloor, vehicleType);
        }
    }

    private void displayFreeCountOnEachFloor(ParkingFloor parkingFloor, String vehicleType){

        List<ParkingSlot>parkingSlots = parkingFloor.getParkingSlots();
        int count = 0;
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.getParkingSlotType().equals(vehicleType) && parkingSlot.isEmpty()){
                count++;
            }
        }

        System.out.println("No. of free slots for " + vehicleType + " on Floor " + parkingFloor.getFloorId() + " : " + count);
    }

    private void displayFreeSlots(String vehicleType){

        List<ParkingFloor>parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor : parkingFloors){
            displayFreeSlotsOnEachFloor(parkingFloor, vehicleType);
        }

    }

    private void displayFreeSlotsOnEachFloor(ParkingFloor parkingFloor, String vehicleType){

        List<ParkingSlot>parkingSlots = parkingFloor.getParkingSlots();
        List<Integer>freeSlots = new ArrayList<>();
        int count = 0;
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.getParkingSlotType().equals(vehicleType) && parkingSlot.isEmpty()){
                freeSlots.add(parkingSlot.getSlotID());
            }
        }

        System.out.print("No. of free slots for " + vehicleType + " on Floor " + parkingFloor.getFloorId() + " : ");

        for(int i = 0 ;i <freeSlots.size(); i++){
            if(i == freeSlots.size() - 1){
                System.out.print(freeSlots.get(i));
            } else {
                System.out.print(freeSlots.get(i) + ", ");
            }
        }

        System.out.println();
    }

    private void displayOcuupiedSlots(String vehicleType){

        List<ParkingFloor>parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor : parkingFloors){
            displayOcuupiedSlotsOnEachFloor(parkingFloor, vehicleType);
        }

    }

    private void displayOcuupiedSlotsOnEachFloor(ParkingFloor parkingFloor, String vehicleType){

        List<ParkingSlot>parkingSlots = parkingFloor.getParkingSlots();
        List<Integer>occupiedSlots = new ArrayList<>();
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.getParkingSlotType().equals(vehicleType) && !parkingSlot.isEmpty()){
                occupiedSlots.add(parkingSlot.getSlotID());
            }
        }

        System.out.print("Occupied slots for " + vehicleType + " on Floor " + parkingFloor.getFloorId() + " : ");

        for(int i =0 ;i < occupiedSlots.size(); i++){
            if(i == occupiedSlots.size() - 1){
                System.out.print(occupiedSlots.get(i));
            } else {
                System.out.print(occupiedSlots.get(i) + ", ");
            }
        }
        System.out.println();
    }
}
