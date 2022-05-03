package FlightControl.logic;

import java.util.HashMap;

import FlightControl.domain.Airplane;
import FlightControl.domain.Airport;
import FlightControl.domain.Flight;

public class FlightControl {
    private HashMap<String, Airplane> planes;
    private HashMap<String, Airport> airports;
    private HashMap<String, Flight> flights;

    public FlightControl() {
        this.planes = new HashMap<>();
        this.airports = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public void addPlane(String id, int capacity) {
        this.planes.putIfAbsent(id, (new Airplane(id, capacity)));
    };

    public void addFlight(String planeId, String airportDep, String airportArr) {
        this.airports.putIfAbsent(airportDep, new Airport(airportDep));
        this.airports.putIfAbsent(airportArr, new Airport(airportArr));
        Flight aFlight = new Flight(this.airports.get(airportDep), this.airports.get(airportArr), this.planes.get(planeId));
        this.flights.putIfAbsent(aFlight.toString(), aFlight);
    }

    public void printPlanes() {
        this.planes.forEach((key, plane) -> {
            System.out.println(plane.toString());
        });
    }

    public void printFlights() {
        this.flights.forEach((key, flight) -> {
            System.out.println(flight.toString());
        });
    }

    public void printOnePlane(String myPlane) {
        // System.out.println("in print one plane");
        // ;
        System.out.println(planes.get(myPlane).toString());
        // Airplane plano = planes.get(myPlane);
        // plano.toString();

    }



    
}
