package rabbitescape.engine.newstates.characterstates.actions.bridging.bridging3;

import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.actions.Bridging.*;
import rabbitescape.engine.newstates.characterstates.actions.bridging.IBridgingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Block.Shape.BRIDGE_UP_LEFT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_LEFT_3;

public class BridgingInCornerLeft3 implements IBridgingState
{
    @Override
    public State newState()
    {
        return RABBIT_BRIDGING_IN_CORNER_LEFT_3;
    }

    @Override
    public boolean behave(
        World world, Character character, BridgeType bridgeType
    )
    {
        character.onSlope = true;
        world.changes.addBlock(
            new Block(
                character.x,
                character.y,
                EARTH,
                BRIDGE_UP_LEFT,
                0
            )
        );
        return true;
    }
}