package rabbitescape.engine.newstates.character_states.actions;

import static rabbitescape.engine.Direction.*;
import static rabbitescape.engine.things.items.ItemType.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterActionStates;
import rabbitescape.engine.newstates.character_states.actions.bashing.*;
import rabbitescape.engine.things.Character;

public class Bashing extends CharacterActionStates {

    private IBashingState bashingState;
    private int stepsOfBashing;

    public Bashing() {
        this.bashingState = new NotBashing();
    }

    @Override
    public State getState() {
        return null;
    }

    public void setBashingState(IBashingState bashingState) {
        this.bashingState = bashingState;
    }

    public void setBashingState(IBashingState right, IBashingState left, Character character ) {
        if (character.dir == RIGHT) {
            setBashingState(right);
        } else {
            setBashingState(left);
        }
    }

    @Override
    public void cancel() {
        stepsOfBashing = 0;
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        BehaviourTools t = new BehaviourTools(character, world);

        return t.pickUpToken(bash);
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (triggered || stepsOfBashing > 0) {
            newStateWhenActive(t, triggered);
        }
        else {
            newStateWhenNotActive();
        }

        return bashingState.newState();
    }

    private void newStateWhenActive(BehaviourTools t, boolean triggered) {
        if (t.isOnUpSlope() && t.blockAboveNext() != null ) {
            if (t.blockAboveNext().material == Block.Material.METAL) {
                stepsOfBashing = 0;
                setBashingState(new BashingUselesslyRightUp(), new BashingUselesslyLeftUp(), t.character);
            }
            else {
                stepsOfBashing = 2;
                setBashingState(new BashingUpRight(), new BashingUpLeft(), t.character);
            }
        }
        else if (t.isOnUpSlope() && t.blockAboveNext() == null && triggered) {
            setBashingState(new BashingUselesslyRightUp(), new BashingUselesslyLeftUp(), t.character);
        }
        else if (t.blockNext() != null) {
            if (t.blockNext().material == Block.Material.METAL) {
                stepsOfBashing = 0;
                setBashingState(new BashingUselesslyRight(), new BashingUselesslyLeft(), t.character);
            }
            else {
                stepsOfBashing = 2;
                setBashingState(new BashingRight(), new BashingLeft(), t.character);
            }
        }
        else if (triggered) {
            setBashingState(new BashingUselesslyRight(), new BashingUselesslyLeft(), t.character);
        }
        else {
            newStateWhenNotActive();
        }
    }

    private void newStateWhenNotActive() {
        setBashingState(new NotBashing());
        --stepsOfBashing;
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return bashingState.behave(world, character);
    }

    public static int destX(Character character) {
        return (character.dir == RIGHT) ? character.x + 1 : character.x - 1;
    }

    @Override
    public void saveState(Map<String, String> saveState) {
        BehaviourState.addToStateIfGtZero(saveState, "Bashing.stepsOfBashing", stepsOfBashing);
    }

    @Override
    public void restoreFromState(Map<String, String> saveState) {
        stepsOfBashing = BehaviourState.restoreFromState(saveState, "Bashing.stepsOfBashing", stepsOfBashing);

        if (stepsOfBashing > 0) {
            ++stepsOfBashing;
        }
    }
}
