package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

public class Rabbot extends Character
{

    String name = "rabbot";

    public Rabbot(int x,int y,Direction dir)
    {
        super( x, y, RABBIT_WALKING_LEFT );
        this.dir = dir;
    }
    
    protected int getFatalHeight() { return 5; }

    @Override
    public String stateName()
    {
        String normalName = super.stateName();
        return normalName.replaceFirst("^rabbit", name.toLowerCase() );
    }
}
