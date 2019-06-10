package rabbitescape.engine.new_states.character_states.actions.bridging.bridging3;

import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.new_states.character_states.actions.bridging.IBridgingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Block.Shape.BRIDGE_UP_RIGHT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_3;

public class BridgingInCornerUpRight3 implements IBridgingState {

    @Override
    public State getState() {
        return RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_3;
    }

    @Override
    public boolean behave(World world, Character character, Bridging bridging) {
        character.onSlope = true;
        character.y--;
        world.changes.addBlock(
            new Block(
                character.x,
                character.y,
                EARTH,
                BRIDGE_UP_RIGHT,
                0
            )
        );
        return true;
    }
}
