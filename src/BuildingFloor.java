import java.util.HashMap;
import java.util.Map;

public class BuildingFloor implements Floor {
    private int number;
    private Map<String, CallButton> callButtons;

    public BuildingFloor(int number) {
        this.number = number;
        this.callButtons = new HashMap<>();
        this.callButtons.put("up", new CallButton("up", this));
        this.callButtons.put("down", new CallButton("down", this));
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public CallButton getCallButton(String direction) {
        return callButtons.get(direction);
    }
}
