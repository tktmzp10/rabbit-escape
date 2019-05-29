package rabbitescape.engine.behaviours.burning;

import rabbitescape.engine.ChangeDescription.State;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BURNING_ON_SLOPE;

public class BurningOnSlope implements IBurningState
{
    @Override
    public State newState()
    {
        return RABBIT_BURNING_ON_SLOPE;
    }


}
