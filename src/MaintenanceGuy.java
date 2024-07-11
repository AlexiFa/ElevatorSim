public class MaintenanceGuy extends User {
    public MaintenanceGuy(int userId, String name, String color, Floor currentFloor, int destinationFloor) {
        super(userId, name, color, currentFloor, destinationFloor);
    }

    @Override
    public void run() {
        System.out.println(this.color + this.name + " is on floor " + this.currentFloor.getNumber() + " and wants to go to floor " + this.destinationFloor + Main.ANSI_RESET);
        this.goToFloor(this.destinationFloor);
    }
}
