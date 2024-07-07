import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static Elevator elevator;
    
    public static void main(String[] args) {
        // Initialisation des étages
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        
        // Initialisation des boutons d'appel
        CallButton callButton1Up = new CallButton("up", floor1);
        CallButton callButton2Up = new CallButton("up", floor2);
        CallButton callButton2Down = new CallButton("down", floor2);
        CallButton callButton3Down = new CallButton("down", floor3);
        
        floor1.setCallButtons(Arrays.asList(callButton1Up));
        floor2.setCallButtons(Arrays.asList(callButton2Up, callButton2Down));
        floor3.setCallButtons(Arrays.asList(callButton3Down));
        
        // Initialisation de l'ascenseur
        Door door = new Door();
        elevator = new Elevator(floor1, door);
        
        // Initialisation des utilisateurs
        List<User> users = Arrays.asList(
            new Client(1, "Alice", ANSI_RED, floor1, 3),
            new Client(2, "Bob", ANSI_GREEN, floor2, 1),
            new MaintenanceGuy(3, "Charlie", ANSI_BLUE, floor3, 2),
            new Client(4, "David", ANSI_YELLOW, floor1, 2),
            new Client(5, "Eva", ANSI_CYAN, floor3, 1)
        );
        
        // Lancement des threads utilisateurs
        for (User user : users) {
            Thread userThread = new Thread(user);
            userThread.start();
            
            try {
                userThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
