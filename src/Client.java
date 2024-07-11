public class Client extends User {
    public Client(int userId, String name, String color, Floor currentFloor, int destinationFloor) {
        super(userId, name, color, currentFloor, destinationFloor);
    }

    @Override
    public void run() {
        super.run();
    }
}
