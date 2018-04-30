import java.awt.*;
import javax.swing.*;

public class ScreenPlay extends Screen
{
    private PlayArea playarea;
    private PlayUI ui;
    
    public ScreenPlay(BombMap bombMap, Minesweeper minesweeper)
    {
        playarea=new PlayArea(bombMap, minesweeper);
        ui=new PlayUI(minesweeper);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(ui);
        add(playarea);
        
    }

}
