import java.util.ArrayList;
import java.util.List;

public class Main {
    // CONSTANTS
    private static final int[] FLOORS = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};

    // static variable
    static List<Floor> floors = new ArrayList<Floor>();
    static List<User> users = new ArrayList<User>();

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
        User Client1 = new Client("John");
        User Client2 = new Client("Jane");
        User Client3 = new Client("Jack");
        User Client4 = new Client("Peter");
        User Mg1 = new MaintenanceGuy("Bob");
        users.add(Client1);
        users.add(Client2);
        users.add(Client3);
        users.add(Client4);
        users.add(Mg1);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initFloors();
        main.initUsers();
    }
}