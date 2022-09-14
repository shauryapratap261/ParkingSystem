import Controller.ParkingManager;
import models.ParkingLot;
import models.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String CREATE_PARKING_LOT = "create_parking_lot";
        String DISPLAY = "display";
        String PARK_VEHICLE = "park_vehicle";
        String UNPARK_VEHICLE = "unpark_vehicle";
        String EXIT = "exit";



        System.out.println("Welcome to the Parking Lot");
        ParkingManager parkingManager = new ParkingManager(null);

        Scanner scanner = new Scanner(System.in);

        while(true){
            String command = scanner.nextLine();
            String []commands = command.split(" ");
            String operation = commands[0];

            if(operation.equals(CREATE_PARKING_LOT)){
                String id = commands[1];
                int noOfFloors = Integer.parseInt(commands[2]);
                int noOfSlotsPerFloor = Integer.parseInt(commands[3]);
                parkingManager = new ParkingManager(new ParkingLot(noOfFloors, noOfSlotsPerFloor, id));
                parkingManager.createParkingLot(id, noOfFloors, noOfSlotsPerFloor);

            } else if(operation.equals(DISPLAY)){
                String commandType = commands[1];
                String vehicleType = commands[2];
                parkingManager.display(commandType, vehicleType);
            } else if(operation.equals(PARK_VEHICLE)){

                String vehicleType = commands[1];
                String regNo = commands[2];
                String color = commands[3];

                Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
                parkingManager.parkVehicle(vehicle);

            } else if(operation.equals(UNPARK_VEHICLE)){
                String ticketNo = commands[1];
                parkingManager.unParkVehicle(ticketNo);

            } else if(operation.equals(EXIT)){
                break;
            }
        }
    }
}
