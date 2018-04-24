import java.awt.*;
import javax.swing.*;

public class ScreenPlay extends Screen
{
    private PlayArea playarea;
    private PlayUI ui;
    
    public ScreenPlay(BombMap bombMap)
    {
        playarea=new PlayArea(bombMap);
        ui=new PlayUI();
    }

}
