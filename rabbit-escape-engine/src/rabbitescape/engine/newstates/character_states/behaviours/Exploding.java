package rabbitescape.engine.newstates.character_states.behaviours;

import static rabbitescape.engine.things.items.ItemType.*;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterBehaviourStates;
import rabbitescape.engine.newstates.character_states.behaviours.exploding.*;
import rabbitescape.engine.things.Character;

public class Exploding extends CharacterBehaviourStates {

    private IExplodingState explodingState;

    public Exploding() {
        setExplodingState(new NotExploding());
    }

    public void setExplodingState(IExplodingState explodingState) {
        this.explodingState = explodingState;
    }

    @Override
    public void cancel() {
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        BehaviourTools t = new BehaviourTools(character, world);
        return t.pickUpToken(explode, true);
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (triggered) {
            setExplodingState(new ExplodingNormal());
        }

        return explodingState.getState();
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return explodingState.behave(world, character);
    }

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState) {
        return behave(world, character, state);
    }
}
