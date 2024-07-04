
import java.util.*;


/**
 * Class Elevator
 */
public class Elevator {

  //
  // Fields
  //

  private int actualFloor;
  private List<DestinationButton> buttons = new ArrayList<>();
  /**
   * 1 up
   * 0 stop
   * -1 down   */
  private int isMoving;
  private Door door;

  private final Vector<Floor> floorsVector = new Vector<>();
  
  //
  // Constructors
  //
  public Elevator () {
    isMoving = 0;
    actualFloor = 0;
    door = new Door();
    floorsVector.addAll(Main.floors);
    for (Floor f: floorsVector){
      DestinationButton button = new DestinationButton(f.getNumber(), this);
      buttons.add(button);
    }
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of actualFloor
   * @param newVar the new value of actualFloor
   */
  public void setActualFloor (int newVar) {
    actualFloor = newVar;
  }

  /**
   * Get the value of actualFloor
   * @return the value of actualFloor
   */
  public int getActualFloor () {
    return actualFloor;
  }

  /**
   * Set the value of buttons
   * @param newVar the new value of buttons
   */
  public void setButtons (List<DestinationButton> newVar) {
    buttons = newVar;
  }

  /**
   * Get the value of buttons
   * @return the value of buttons
   */
  public List<DestinationButton> getButtons () {
    return buttons;
  }

  /**
   * Set the value of isMoving
   * 1 up
   * 0 stop
   * -1 down
   * @param newVar the new value of isMoving
   */
  public void setIsMoving (int newVar) {
    isMoving = newVar;
  }

  /**
   * Get the value of isMoving
   * 1 up
   * 0 stop
   * -1 down
   * @return the value of isMoving
   */
  public int getIsMoving () {
    return isMoving;
  }

  /**
   * Set the value of door
   * @param newVar the new value of door
   */
  public void setDoor (Door newVar) {
    door = newVar;
  }

  /**
   * Get the value of door
   * @return the value of door
   */
  public Door getDoor () {
    return door;
  }

  /**
   * Add a Floors object to the floorsVector List
   */
  public void addFloors (Floor new_object) {
    floorsVector.add(new_object);
  }

  /**
   * Remove a Floors object from floorsVector List
   */
  public void removeFloors (Floor new_object)
  {
    floorsVector.remove(new_object);
  }

  /**
   * Get the List of Floors objects held by floorsVector
   * @return List of Floors objects held by floorsVector
   */
  public List getFloorsList () {
    return (List) floorsVector;
  }


  //
  // Other methods
  //

  /**
   * @param        nbFloor
   */
  public void changefloor(int nbFloor)
  {
  }


}
