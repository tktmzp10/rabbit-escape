package rabbitescape.engine;

import java.util.Map;

public abstract class NewStates
{
    public abstract void calcNewState( World world );

    public abstract void step( World world );

    public abstract Map<String, String> saveState( boolean runtimeMeta );

    public abstract void restoreFromState( Map<String, String> state );

    public abstract String overlayText();
}
