import java.util.concurrent.TimeUnit;

/**
 * Class Door
 */
public class Door {

  //
  // Fields
  //

  private Boolean isOpen = false;
  
  //
  // Constructors
  //
  public Door () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of isOpen
   * @param newVar the new value of isOpen
   */
//  public void setIsOpen (Boolean newVar) {
//    isOpen = newVar;
//  }

  /**
   * Get the value of isOpen
   * @return the value of isOpen
   */
  public Boolean getIsOpen () {
    return isOpen;
  }

  //
  // Other methods
  //

  /**
   */
  public void open()
  {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      // e.printStackTrace();
      System.out.println("The door had a problem while opening");
    }
    isOpen = true;
  }


  /**
   */
  public void close()
  {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      // e.printStackTrace();
      System.out.println("The door had a problem while closing");
    }
    isOpen = false;
  }
}
