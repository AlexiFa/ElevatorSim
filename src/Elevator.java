import java.util.*;

public class Elevator {
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
                changefloor(nextFloor);
            }
        }
    }


    public void changefloor(int nbFloor) {
        isMoving = 1;
        System.out.println("Elevator is moving from floor " + actualFloor.getNumber() + " to floor " + nbFloor);
    
        int currentFloor = actualFloor.getNumber();
        while (currentFloor != nbFloor) {
            currentFloor += (currentFloor < nbFloor) ? 1 : -1;
            System.out.println("Elevator is moving to floor " + currentFloor);
    
            try {
                // Check if somebody is waiting here and go in the same direction
                if (upRequests.contains(currentFloor)) {
                    System.out.println("Elevator is stopping at floor " + currentFloor + " to pick up a client");
                    upRequests.remove(currentFloor);
                }
                if (downRequests.contains(currentFloor)) {
                    System.out.println("Elevator is stopping at floor " + currentFloor + " to pick up a client");
                    downRequests.remove(currentFloor);
                }
                Thread.sleep(1000); // Wait for 1 second to simulate elevator moving
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        actualFloor = new Floor(nbFloor); // Simulate changing floor
        System.out.println("Elevator arrived at floor " + actualFloor.getNumber());
        door.open();
        // Simulate door open and close time
        try {
            Thread.sleep(1000); // Wait for 1 second to simulate door operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        door.close();
        isMoving = 0;
        processNextRequest();
    }
    
    
}
