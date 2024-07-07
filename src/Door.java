public class Door {
    private boolean isOpen = false;

    public void open() {
        isOpen = true;
        System.out.println("Door is opened.");
    }

    public void close() {
        isOpen = false;
        System.out.println("Door is closed.");
    }
}
