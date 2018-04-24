import java.awt.*;
import javax.swing.*;

public class Minesweeper extends JFrame
{
    private BombMap bombMap;
    private Screen screen;
    
    public Minesweeper()
    {
        bombMap=new BombMap();
        screen=new ScreenDiff();
        
        
        
        pack();
        setVisible(true);
    }
    
    
}
