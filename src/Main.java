import java.util.logging.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        // Configure logger to display logs in the console
        Logger logger = Logger.getLogger(Main.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        
        // Create a door for the elevator
        Door door = new ElevatorDoor();

        // Create floors for the building
        Floor floor1 = new BuildingFloor(1);
        Floor floor2 = new BuildingFloor(2);
        Floor floor3 = new BuildingFloor(3);
        Floor floor4 = new BuildingFloor(4);

        // Create an elevator starting at the first floor
        Elevator elevator = new Elevator(floor1, door);

        // Add the elevator to the elevator system
        ElevatorSystem.addElevator(elevator);

        // Simulate users requesting the elevator
        User user1 = new Client(1, "Alice", "\u001B[34m", floor1, 3); // Alice on floor 1 wants to go to floor 3
        User user2 = new Client(2, "Bob", "\u001B[32m", floor2, 1); // Bob on floor 2 wants to go to floor 1
        User user3 = new Client(3, "Charlie", "\u001B[31m", floor3, 4); // Charlie on floor 3 wants to go to floor 4
        User user4 = new Client(4, "Diana", "\u001B[35m", floor4, 2); // Diana on floor 4 wants to go to floor 2
        User user5 = new MaintenanceGuy(5, "Eve", "\u001B[36m", floor1, 4); // Eve on floor 1 wants to go to floor 4

        // Run the users in separate threads to simulate their actions concurrently
        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);
        Thread thread3 = new Thread(user3);
        Thread thread4 = new Thread(user4);
        Thread thread5 = new Thread(user5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
