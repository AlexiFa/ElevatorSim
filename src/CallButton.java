
import java.util.*;


/**
 * Class CallButton
 */
public class CallButton extends Button {

  //
  // Fields
  //

  private String direction;

  public Floor m_floor;
  
  //
  // Constructors
  //
  public CallButton (String dir, Floor floor) {
    direction = dir;
    this.m_floor = floor;
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of direction
   * @param newVar the new value of direction
   */
  // public void setDirection (String newVar) {direction = newVar;}

  /**
   * Get the value of direction
   * @return the value of direction
   */
  public String getDirection () {
    return direction;
  }

  /**
   * Set the value of m_floor
   * @param newVar the new value of m_floor
   */
  // public void setFloor (Floor newVar) {m_floor = newVar;}

  /**
   * Get the value of m_floor
   * @return the value of m_floor
   */
  public Floor getFloor() {
    return m_floor;
  }

  //
  // Other methods
  //

  public void press()
  {
    super.press();
    if (Main.elevator.getIsMoving() == 0) {
      Main.elevator.changefloor(this.m_floor.getNumber());
    }
  }

}
