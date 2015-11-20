package rabbitescape.engine.solution;

import rabbitescape.engine.Token;

public class SelectAction implements CommandAction, TimeStepAction
{
    public final Token.Type type;

    public SelectAction( Token.Type type )
    {
        this.type = type;
    }

    @Override
    public String relFormat( boolean firstInCommand )
    {
        if ( firstInCommand )
        {
            return type.name();
        }
        return SolutionParser.ACTION_DELIMITER + type.name();
    }

    @Override
    public String toString()
    {
        return "SelectAction( " + type.name() + " )";
    }

    @Override
    public boolean equals( Object otherObj )
    {
        if ( ! ( otherObj instanceof SelectAction ) )
        {
            return false;
        }
        SelectAction other = (SelectAction)otherObj;

        return ( type == other.type );
    }

    @Override
    public int hashCode()
    {
        return type.hashCode();
    }

    @Override
    public void typeSwitch( CommandActionTypeSwitch actionTypeSwitch )
    {
        actionTypeSwitch.caseSelectAction( this );
    }

    @Override
    public void typeSwitch( TimeStepActionTypeSwitch timeStepActionTypeSwitch )
    {
        timeStepActionTypeSwitch.caseSelectAction( this );
    }
}
