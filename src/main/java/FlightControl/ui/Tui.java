package FlightControl.ui;

import java.util.Scanner;
import FlightControl.logic.FlightControl;

public class Tui {

    private Scanner scanner;
    
    private FlightControl flightControl;



    public Tui(Scanner scanner, FlightControl flightControl) {
        this.scanner = scanner;
        this.flightControl = flightControl;
    }

    public void start() {
        assetControl();
        flightLoop();
    }


    private void flightLoop() {
        System.out.println("Flight Control");
        while (true) {
            System.out.print("Choose an action:\n[1] Print airplanes\n[2] Print flights\n[3] Print airplane details\n[x] Quit\n> ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                flightControl.printPlanes();
            } else if (choice.equals("2")) {
                flightControl.printFlights();
            } else if (choice.equals("3")) {
                System.out.print("Give the airplane id: ");
                String myPlane = scanner.nextLine();
                flightControl.printOnePlane(myPlane);
            } else if (choice.equals("X") || choice.equals("x")) {
                break;
            }
        }
    }


    public void assetControl() {
        System.out.println("Airport Asset Control");
        while (true) {
            // System.out.print("Choose an action:\n[1] Add an airplane\n[2] Add a flight\n[x] Exit Airport Asset Control\n> ");
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");
            String choice = this.scanner.nextLine();
            if (choice.equals("1")) {
                buildAPlane();
            } else if (choice.equals("2")) {
                buildAFlight();
            } else if (choice.equals("X") || choice.equals("x")) {
                break;
            }
        }
    }

    public void buildAPlane() {
        System.out.print("Give the airplane id: ");
        String planeID = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int planeCapacity = Integer.valueOf(scanner.nextLine());
        flightControl.addPlane(planeID, planeCapacity);
    }

    public void buildAFlight() {
        // Give the airplane id: G-OWAC
        // Give the departure airport id: JFK
        // Give the target airport id: BAL
        System.out.print("Give the airplane id: ");
        String planeID = scanner.nextLine();
        System.out.print("Give the departure airport id: ");
        String departure = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String target = scanner.nextLine();
        flightControl.addFlight(planeID, departure, target);
    }


}
