package rabbitescape.engine.new_states.character_states.actions;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.new_states.character_states.CharacterActionStates;
import rabbitescape.engine.new_states.character_states.actions.waiting.IWaitingState;
import rabbitescape.engine.new_states.character_states.actions.waiting.NotWaiting;
import rabbitescape.engine.new_states.character_states.actions.waiting.WaitingLeft;
import rabbitescape.engine.new_states.character_states.actions.waiting.WaitingRight;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;
import rabbitescape.engine.things.characters.Rabbot;

import static rabbitescape.engine.Direction.RIGHT;

public class Waiting extends CharacterActionStates {

    private IWaitingState waitingState;

    public Waiting() {
        setWaitingState(new NotWaiting());
    }

    public void setWaitingState(IWaitingState waitingState) {
        this.waitingState = waitingState;
    }

    public void setWaitingState(
        IWaitingState right,
        IWaitingState left,
        Character character
    ) {
        if (character.dir == RIGHT) {
            setWaitingState(right);
        } else {
            setWaitingState(left);
        }
    }

    private boolean within1Vertically(Character otherRabbit, Character rabbit) {
        return (Math.abs(otherRabbit.y - rabbit.y) < 2);
    }

    private boolean noseToNose(Character otherRabbit, Character rabbit) {
        if (
            otherRabbit.x == rabbit.x - 1 &&
                otherRabbit.dir == RIGHT &&
                rabbit.dir == Direction.LEFT
        ) {
            return true;
        } else if (
            otherRabbit.x == rabbit.x + 1 &&
                otherRabbit.dir == Direction.LEFT &&
                rabbit.dir == RIGHT
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void cancel() {
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        if (
            character instanceof Rabbot &&
                !Blocking.isBlocking(character.state) &&
                !Digging.isDigging(character.state)
        ) {
            for (Character otherCharacter : world.rabbits) {
                if (
                    otherCharacter instanceof Rabbit &&
                        within1Vertically(otherCharacter, character) &&
                        noseToNose(otherCharacter, character) &&
                        !Blocking.isBlocking(otherCharacter.state)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (triggered) {
            setWaitingState(
                new WaitingRight(),
                new WaitingLeft(),
                t.character
            );
        }

        return waitingState.newState();
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return waitingState.behave(world, character);
    }
}
