
import java.util.*;


/**
 * Class User
 */
public class User {

  //
  // Fields
  //

  static private int id = 0;
  private int userId;
  private String name;

  public Floor m_actualFloor;
  
  //
  // Constructors
  //
  public User () {
    userId = id++;
    for (Floor f : Main.floors){
      if (f.getNumber() == 0){
        this.m_actualFloor = f;
      }
    }
  }

  public User (String name) {
    userId = id++;
    this.name = name;
    for (Floor f : Main.floors){
      if (f.getNumber() == 0){
        this.m_actualFloor = f;
      }
    }
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of userId
   * @param newVar the new value of userId
   */
  public void setUserId (int newVar) {
    userId = newVar;
  }

  /**
   * Get the value of userId
   * @return the value of userId
   */
  public int getUserId () {
    return userId;
  }

  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  /**
   * Set the value of m_actualFloor
   * @param newVar the new value of m_actualFloor
   */
  public void setActualFloor (Floor newVar) {
    m_actualFloor = newVar;
  }

  /**
   * Get the value of m_actualFloor
   * @return the value of m_actualFloor
   */
  public Floor getActualFloor () {
    return m_actualFloor;
  }

  //
  // Other methods
  //

  /**
   * call all the functions to go to the requested floor
   * @param floorNumber the number of the floor the user wants to go to
   */
  public void goToFloor(int floorNumber)
  {
  }


}
