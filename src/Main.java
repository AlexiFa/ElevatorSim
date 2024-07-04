import java.util.ArrayList;
import java.util.List;

public class Main {
    // ANSI COLORS (for the console output)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    // CONSTANTS
    public static final int[] FLOORS = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};

    // static variable
    static List<Floor> floors = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static Elevator elevator;

    // Initialize the floors from a list of integers ex: (-2, -1, 0, 1, 2, 3, 4, 5, 6, 7)
    void initFloors(){

        for(int i : FLOORS){
            Floor.addFloor(i);
        }
        for (int f : Floor.getFloors()){
            Floor floor = new Floor(f);
            floors.add(floor);
        }
    }

    // Initialize users
    void initUsers() {
        User client1 = new Client("ERIC", floors.get(3), 5, ANSI_RED);
        User client2 = new Client("JANE", floors.get(0), 3, ANSI_GREEN);
        User client3 = new Client("BART", floors.get(2), -2, ANSI_YELLOW);
        User client4 = new Client("Peter", floors.get(1), 7, ANSI_BLUE);
        User mg1 = new MaintenanceGuy("Bob", floors.get(0), 0, ANSI_PURPLE);
        users.add(client1);
        users.add(client2);
        users.add(client3);
        users.add(client4);
        users.add(mg1);
    }

    public static void main(String[] args) {
        // init environment (floors, users, elevator)
        Main main = new Main();
        main.initFloors();
        main.initUsers();
        elevator = new Elevator();
        System.out.println("Elevator is at floor " + elevator.getActualFloor() + " and is stopped.");

        // set names of threads
        for (User u : users){
            u.setName(u.getFirstName());
        }
        new Thread(users.get(0), users.get(0).getFirstName()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(users.get(1), users.get(1).getFirstName()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(users.get(2), users.get(2).getFirstName()).start();
    }
}