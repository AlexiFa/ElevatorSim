
import java.util.*;


/**
 * Class Floor
 */
public class Floor {

  //
  // Fields
  //

  private int number;

  public Vector callbuttonsVector = new Vector();
  
  //
  // Constructors
  //
  public Floor () { };
  
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
  public void addCallButtons (CallButton new_object) {
    callbuttonsVector.add(new_object);
  }

  /**
   * Remove a CallButtons object from callbuttonsVector List
   */
  public void removeCallButtons (CallButton new_object)
  {
    callbuttonsVector.remove(new_object);
  }

  /**
   * Get the List of CallButtons objects held by callbuttonsVector
   * @return List of CallButtons objects held by callbuttonsVector
   */
  public List getCallButtonsList () {
    return (List) callbuttonsVector;
  }


  //
  // Other methods
  //

}
