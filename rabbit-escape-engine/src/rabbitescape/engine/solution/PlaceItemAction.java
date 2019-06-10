package rabbitescape.engine.solution;

public class PlaceItemAction implements CommandAction, TimeStepAction {

    public final int x;
    public final int y;

    public PlaceItemAction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "PlaceItemAction( " + x + ", " + y + " )";
    }

    @Override
    public boolean equals(Object otherObj) {
        if (!(otherObj instanceof PlaceItemAction)) {
            return false;
        }
        PlaceItemAction other = (PlaceItemAction) otherObj;

        return (x == other.x && y == other.y);
    }

    @Override
    public int hashCode() {
        return x + 31 * (x + y);
    }

    @Override
    public void typeSwitch(CommandActionTypeSwitch actionTypeSwitch) {
        actionTypeSwitch.casePlaceItemAction(this);
    }

    @Override
    public void typeSwitch(TimeStepActionTypeSwitch timeStepActionTypeSwitch) {
        timeStepActionTypeSwitch.casePlaceItemAction(this);
    }
}
