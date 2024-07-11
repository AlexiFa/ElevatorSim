public class DestinationButton extends AbstractButton {
    private int number;

    public DestinationButton(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void press() {
        super.press();
        System.out.println("Destination button for floor " + number + " pressed.");
    }
}
