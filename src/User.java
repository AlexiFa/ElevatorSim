public abstract class User implements Runnable {
  protected int userId;
  protected String name;
  protected String color;
  protected Floor m_actualFloor;
  protected int destinationFloor;

  public User(int userId, String name, String color, Floor actualFloor, int destinationFloor) {
      this.userId = userId;
      this.name = name;
      this.color = color;
      this.m_actualFloor = actualFloor;
      this.destinationFloor = destinationFloor;
  }

  public void goToFloor(int floorNumber) {
      if (this.m_actualFloor.getNumber() == floorNumber) {
          System.out.println(this.color + this.name + " is already on floor " + this.m_actualFloor.getNumber() + Main.ANSI_RESET);
          return;
      } else if (this.m_actualFloor.getNumber() < floorNumber) {
          CallButton button = m_actualFloor.getCallButton("up");
          System.out.println(this.color + this.name + " pressed the " + button.getDirection() + " button at floor " + this.m_actualFloor.getNumber() + Main.ANSI_RESET);
          button.press();
      } else if (this.m_actualFloor.getNumber() > floorNumber) {
          CallButton button = m_actualFloor.getCallButton("down");
          System.out.println(this.color + this.name + " pressed the " + button.getDirection() + " button at floor " + this.m_actualFloor.getNumber() + Main.ANSI_RESET);
          button.press();
      }

      // Simuler le temps d'attente pour l'ascenseur
      try {
          Thread.sleep(1000); // Attendre 1 seconde pour la simulation
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      Main.elevator.requestFloor(floorNumber, (this.m_actualFloor.getNumber() < floorNumber) ? "up" : "down");
      this.m_actualFloor = new Floor(floorNumber); // Mise à jour de l'étage actuel après déplacement
  }

  @Override
  public void run() {
      System.out.println(this.color + this.name + " is on floor " + this.m_actualFloor.getNumber() + " and wants to go to floor " + this.destinationFloor + Main.ANSI_RESET);
      this.goToFloor(this.destinationFloor);
  }
}
