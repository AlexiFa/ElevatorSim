public abstract class User implements Runnable {
    protected int userId;
    protected String name;
    protected String color;
    protected Floor currentFloor;
    protected int destinationFloor;

    public User(int userId, String name, String color, Floor currentFloor, int destinationFloor) {
        this.userId = userId;
        this.name = name;
        this.color = color;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    public void goToFloor(int floorNumber) {
        if (this.currentFloor.getNumber() == floorNumber) {
            System.out.println(this.color + this.name + " is already on floor " + this.currentFloor.getNumber() + ".");
            return;
        }

        String direction = this.currentFloor.getNumber() < floorNumber ? "up" : "down";
        CallButton button = this.currentFloor.getCallButton(direction);
        System.out.println(this.color + this.name + " pressed the " + button.getDirection() + " button at floor " + this.currentFloor.getNumber() + ".");
        button.press();

        // Simulate waiting time for the elevator
        try {
            Thread.sleep(1000); // Wait 1 second for simulation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ElevatorSystem.requestFloor(floorNumber, direction);
        this.currentFloor = new BuildingFloor(floorNumber); // Update the current floor after moving
    }

    @Override
    public void run() {
        System.out.println(this.color + this.name + " is on floor " + this.currentFloor.getNumber() + " and wants to go to floor " + this.destinationFloor + ".");
        this.goToFloor(this.destinationFloor);
    }
}
