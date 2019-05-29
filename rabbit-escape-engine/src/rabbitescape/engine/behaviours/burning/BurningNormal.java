package rabbitescape.engine.behaviours.burning;

import rabbitescape.engine.ChangeDescription.State;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BURNING;

public class BurningNormal implements IBurningState
{
    @Override
    public State newState()
    {
        return RABBIT_BURNING;
    }


}
