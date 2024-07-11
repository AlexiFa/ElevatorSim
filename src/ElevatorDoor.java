import java.util.logging.Logger;

public class ElevatorDoor implements Door {
    private static final Logger logger = Logger.getLogger(ElevatorDoor.class.getName());
    private boolean isOpen = false;

    @Override
    public void open() {
        isOpen = true;
        logger.info("Door is opened.");
    }

    @Override
    public void close() {
        isOpen = false;
        logger.info("Door is closed.");
    }

    public boolean isOpen() {
        return isOpen;
    }
}
