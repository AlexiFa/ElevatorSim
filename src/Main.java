import java.util.ArrayList;
import java.util.List;

public class Main {
    // CONSTANTS
    private static final int[] FLOORS = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};

    // Initialize the floors from a list of integers ex: (-2, -1, 0, 1, 2, 3, 4, 5, 6, 7)
    void initFloors(){
        for(int i : FLOORS){
            Floor floor = new Floor(i);
            Floor.addFloor(i);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initFloors();
        System.out.println("Floors: " + Floor.getFloors());
    }
}