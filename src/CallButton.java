public class CallButton extends AbstractButton {
    private String direction;
    private Floor floor;

    public CallButton(String direction, Floor floor) {
        this.direction = direction;
        this.floor = floor;
    }

    public String getDirection() {
        return direction;
    }

    public Floor getFloor() {
        return floor;
    }

    @Override
    public void press() {
        super.press();
        ElevatorSystem.requestFloor(this.floor.getNumber(), direction);
    }
}
