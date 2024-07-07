abstract public class Button {
    private Boolean isPressed = false;

    public void setIsPressed(Boolean newVar) {
        isPressed = newVar;
    }

    public Boolean getIsPressed() {
        return isPressed;
    }

    public void press() {
        isPressed = true;
    }
}
