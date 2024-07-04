
import java.util.*;


/**
 * Class DestinationButton
 */
public class DestinationButton extends Button {

  //
  // Fields
  //

  private int number;
  private Elevator elevator;
  
  //
  // Constructors
  //
  public DestinationButton (int nb, Elevator e) {
    number = nb;
    elevator = e;
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of number
   * @param newVar the new value of number
   */
  public void setNumber (int newVar) {
    number = newVar;
  }

  /**
   * Get the value of number
   * @return the value of number
   */
  public int getNumber () {
    return number;
  }

  //
  // Other methods
  //

}
