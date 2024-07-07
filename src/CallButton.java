public class CallButton extends Button {
  private String direction;
  private Floor m_floor;

  public CallButton(String dir, Floor floor) {
      direction = dir;
      this.m_floor = floor;
  }

  public String getDirection() {
      return direction;
  }

  public Floor getFloor() {
      return m_floor;
  }

  public void press() {
      super.press();
      Main.elevator.requestFloor(this.m_floor.getNumber(), direction);
  }
}
