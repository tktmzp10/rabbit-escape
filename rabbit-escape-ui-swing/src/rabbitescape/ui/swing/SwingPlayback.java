package rabbitescape.ui.swing;

import rabbitescape.engine.solution.PlaceItemAction;
import rabbitescape.engine.solution.SelectAction;
import rabbitescape.engine.solution.UiPlayback;

public class SwingPlayback implements UiPlayback
{
    final private SwingGameLaunch launch;

    public SwingPlayback( SwingGameLaunch launch )
    {
        this.launch = launch;
    }

    @Override
    public void selectItem( SelectAction selectAction )
    {
        launch.solutionRecorder.append( selectAction );
        launch.getUi().chooseAbility( selectAction.type );
    }

    @Override
    public void placeItem( PlaceItemAction placeItemAction)
    {
        launch.getUi().addItem( placeItemAction.x, placeItemAction.y );
    }



}
