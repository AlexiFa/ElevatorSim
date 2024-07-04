/**
 * Class User
 */
public class User extends Thread{

  private String color;

  //
  // Fields
  //

  static private int id = 0;
  private int userId;
  private String name;
  private int destinationFloor;
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

  public User (String name, Floor actualFloor, int destinationFloor, String printColor) {
    userId = id++;
    this.name = name;
    this.destinationFloor = destinationFloor;
    this.m_actualFloor = actualFloor;
    this.color = printColor;
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
  public void setFirstName(String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getFirstName() {
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
    if (this.m_actualFloor.getNumber() == floorNumber){
      System.out.println(this.color + this.name + " is already on floor " + this.m_actualFloor.getNumber() + Main.ANSI_RESET);
      return;
    }else if (this.m_actualFloor.getNumber() < floorNumber) {
      try{
        CallButton button = m_actualFloor.getCallButton("up");
        System.out.println(this.color + this.name + " pressed the " + button.getDirection() + " button at floor " + this.m_actualFloor.getNumber() + Main.ANSI_RESET);
        button.press();
      }catch (Exception e){
        System.out.println(e);
      }
    }else if (this.m_actualFloor.getNumber() > floorNumber){
      try {
        CallButton button = m_actualFloor.getCallButton("down");
        System.out.println(this.color + this.name + " pressed the " + button.getDirection() + " button at floor " + this.m_actualFloor.getNumber() + Main.ANSI_RESET);
        button.press();
      }catch (Exception e){
        System.out.println(e);
      }
    }
  }

  public void run(){
    System.out.println(this.color + this.name + " is on floor " + this.m_actualFloor.getNumber() + " and wants to go to floor " + this.destinationFloor + Main.ANSI_RESET);
    this.goToFloor(this.destinationFloor);
  }
}
