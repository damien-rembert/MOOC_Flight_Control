package FlightControl.domain;

public class Flight {

    private Airport departureAirport;
    private Airport arrivalAirport;
    private Airplane plane;

    public Flight(Airport departureAirport, Airport arrivalAirport, Airplane plane) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.plane = plane;
    }

    public String toString() {
        return (plane + " (" + departureAirport + "-" + arrivalAirport + ")");
    }

    
}
