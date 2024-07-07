import java.util.List;

public class Floor {
    private int number;
    private List<CallButton> callButtons;
    
    public Floor(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setCallButtons(List<CallButton> callButtons) {
        this.callButtons = callButtons;
    }

    public CallButton getCallButton(String direction) {
        for (CallButton button : callButtons) {
            if (button.getDirection().equals(direction)) {
                return button;
            }
        }
        return null;
    }
}
