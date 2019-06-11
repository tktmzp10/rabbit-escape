package rabbitescape.engine.new_states.character_states.actions;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.new_states.character_states.CharacterActionStates;
import rabbitescape.engine.new_states.character_states.actions.crashing.CrashingNormal;
import rabbitescape.engine.new_states.character_states.actions.crashing.ICrashingState;
import rabbitescape.engine.new_states.character_states.actions.crashing.NotCrashing;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;
import rabbitescape.engine.things.characters.Rabbot;

public class Crashing extends CharacterActionStates {

    private ICrashingState crashingState;

    public Crashing() {
        setCrashingState(new NotCrashing());
    }

    public void setCrashingState(ICrashingState crashingState) {
        this.crashingState = crashingState;
    }

    @Override
    public void cancel() {
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        if (character instanceof Rabbot) {
            for (Character otherCharacter : world.rabbits) {
                if (otherCharacter instanceof Rabbit &&
                    otherCharacter.x == character.x &&
                    otherCharacter.y == character.y
                ) {
                    world.changes.killRabbit(otherCharacter);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (triggered) {
            setCrashingState(new CrashingNormal());
        }

        return crashingState.getState();
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return crashingState.behave(world, character);
    }

    @Override
    public State getState() {
        return null;
    }
}
