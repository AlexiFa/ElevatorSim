public abstract class AbstractButton {
    private boolean isPressed = false;

    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public void press() {
        isPressed = true;
    }
}
