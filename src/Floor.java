
import java.util.*;


/**
 * Class Floor
 */
public class Floor {

  //
  // Fields
  //

  static private List<Integer> floors = new ArrayList<Integer>();

  private int number;

  public Vector<CallButton> callbuttonsVector = new Vector<CallButton>(2);
  
  //
  // Constructors
  //
  public Floor (int nb) {
    number = nb;
    if (nb == floors.getFirst()){
      CallButton up = new CallButton("up");
      up.setFloor(this);
      addCallButtons(up);
    }
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

  /**
   * Add a CallButtons object to the callbuttonsVector List
   */
  private void addCallButtons (CallButton new_object) {
    callbuttonsVector.add(new_object);
  }

  /**
   * Remove a CallButtons object from callbuttonsVector List
   */
  private void removeCallButtons (CallButton new_object)
  {
    callbuttonsVector.remove(new_object);
  }

  /**
   * Get the List of CallButtons objects held by callbuttonsVector
   * @return List of CallButtons objects held by callbuttonsVector
   */
  public Vector<CallButton> getCallButtonsList () {
    return (Vector<CallButton>) callbuttonsVector;
  }

  public static List<Integer> getFloors() {
    return floors;
  }

  public static void addFloor(int floor) {
    floors.add(floor);
  }

  //
  // Other methods
  //

}
