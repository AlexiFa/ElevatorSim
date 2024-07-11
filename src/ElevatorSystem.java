import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private static List<Elevator> elevators = new ArrayList<>();

    public static void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public static void requestFloor(int floorNumber, String direction) {
        // Logic to handle floor requests across multiple elevators
        for (Elevator elevator : elevators) {
            elevator.requestFloor(floorNumber, direction);
        }
    }
}
