public class MaintenanceGuy extends User {
    public MaintenanceGuy(int userId, String name, String color, Floor actualFloor, int destinationFloor) {
        super(userId, name, color, actualFloor, destinationFloor);
    }

    @Override
    public void run() {
        System.out.println(this.color + this.name + " is on floor " + this.m_actualFloor.getNumber() + " and wants to go to floor " + this.destinationFloor + Main.ANSI_RESET);
        this.goToFloor(this.destinationFloor);
    }
}
