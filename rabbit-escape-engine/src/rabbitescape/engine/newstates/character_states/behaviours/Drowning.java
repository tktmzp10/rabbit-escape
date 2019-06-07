package rabbitescape.engine.newstates.character_states.behaviours;

import static rabbitescape.engine.CellularDirection.*;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterBehaviourStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.newstates.character_states.behaviours.drowning.*;
import rabbitescape.engine.things.characters.Rabbot;
import rabbitescape.engine.things.environment.WaterRegion;

public class Drowning extends CharacterBehaviourStates {

    private IDrowningState drowningState;

    public Drowning() {
        setDrowningState(new NotDrowning());
    }

    public void setDrowningState(IDrowningState drowningState) {
        this.drowningState = drowningState;
    }

    @Override
    public void cancel() {
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        //TODO: Don't include Exiting to Rabbot.
        if (character instanceof Rabbot) {
            return false;  // Rabbots don't drown
        }

        int yCoordinate = character.y;
        CellularDirection directionToCheck = UP;
        if (character.onSlope) {
            // The character's head is at the bottom of the cell above.
            yCoordinate = character.y - 1;
            directionToCheck = DOWN;
        }
        // TODO Find out why the character's y coordinate is allowed to be
        // larger than the size of the world (see solution for easy-12).
        if (yCoordinate < 0 || yCoordinate >= world.size.height) {
            return false;
        }
        for (WaterRegion waterRegion :
            world.waterTable.getItemsAt(character.x, yCoordinate)) {
            if (waterRegion.isConnected(directionToCheck)) {
                return (waterRegion.getContents() >= waterRegion.capacity);
            }
        }
        return false;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (triggered) {
            setDrowningState(new DrowningNormal());
        }

        return drowningState.getState();
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return drowningState.behave(world, character);
    }

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState) {
        return behave(world, character, state);
    }

    @Override
    public State getState() {
        return null;
    }
}
