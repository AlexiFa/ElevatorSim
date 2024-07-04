

/**
 * Class Button
 */
abstract public class Button {

  //
  // Fields
  //

  private Boolean isPressed = false;
  
  //
  // Constructors
  //
  public Button () { }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of isPressed
   * @param newVar the new value of isPressed
   */
  public void setIsPressed (Boolean newVar) {
    isPressed = newVar;
  }

  /**
   * Get the value of isPressed
   * @return the value of isPressed
   */
  public Boolean getIsPressed () {
    return isPressed;
  }

  //
  // Other methods
  //

  /**
   */
  public void press()
  {
  }


}
