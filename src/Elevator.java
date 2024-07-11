import java.util.*;
import java.util.logging.*;

interface Door {
    void open();
    void close();
}

class ElevatorDoor implements Door {
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

interface Floor {
    int getNumber();
}

class BuildingFloor implements Floor {
    private int number;

    public BuildingFloor(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}

public class Elevator {
    private static final Logger logger = Logger.getLogger(Elevator.class.getName());
    private Floor actualFloor;
    private Door door;
    private int isMoving = 0;
    private Queue<Integer> upRequests = new PriorityQueue<>();
    private Queue<Integer> downRequests = new PriorityQueue<>(Collections.reverseOrder());

    public Elevator(Floor actualFloor, Door door) {
        this.actualFloor = actualFloor;
        this.door = door;
    }

    public int getIsMoving() {
        return isMoving;
    }

    public void requestFloor(int floorNumber, String direction) {
        logger.info("Floor request received: floor " + floorNumber + ", direction " + direction);
        if (direction.equals("up")) {
            upRequests.add(floorNumber);
        } else {
            downRequests.add(floorNumber);
        }
        processNextRequest();
    }

    private void processNextRequest() {
        if (isMoving == 0) {
            Integer nextFloor = null;
            if (!upRequests.isEmpty()) {
                nextFloor = upRequests.poll();
            } else if (!downRequests.isEmpty()) {
                nextFloor = downRequests.poll();
            }

            if (nextFloor != null) {
                changeFloor(nextFloor);
            }
        }
    }

    private void changeFloor(int nbFloor) {
        isMoving = 1;
        logger.info("Elevator is moving from floor " + actualFloor.getNumber() + " to floor " + nbFloor);

        int currentFloor = actualFloor.getNumber();
        while (currentFloor != nbFloor) {
            currentFloor += (currentFloor < nbFloor) ? 1 : -1;
            logger.info("Elevator is moving to floor " + currentFloor);

            try {
                // Check if somebody is waiting here and go in the same direction
                if (upRequests.contains(currentFloor)) {
                    logger.info("Elevator is stopping at floor " + currentFloor + " to pick up a client");
                    upRequests.remove(currentFloor);
                }
                if (downRequests.contains(currentFloor)) {
                    logger.info("Elevator is stopping at floor " + currentFloor + " to pick up a client");
                    downRequests.remove(currentFloor);
                }
                Thread.sleep(1000); // Wait for 1 second to simulate elevator moving
            } catch (InterruptedException e) {
                logger.severe("Interrupted while moving: " + e.getMessage());
            }
        }

        actualFloor = new BuildingFloor(nbFloor); // Simulate changing floor
        logger.info("Elevator arrived at floor " + actualFloor.getNumber());
        door.open();
        // Simulate door open and close time
        try {
            Thread.sleep(1000); // Wait for 1 second to simulate door operation
        } catch (InterruptedException e) {
            logger.severe("Interrupted while operating door: " + e.getMessage());
        }
        door.close();
        isMoving = 0;
        processNextRequest();
    }
}
