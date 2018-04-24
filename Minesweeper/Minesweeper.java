import java.awt.*;
import javax.swing.*;

public class Minesweeper extends JFrame
{
    private BombMap bombMap;
    private Screen screen;
    
    public Minesweeper()
    {
        System.out.print('\u000C');
        bombMap=new BombMap();
        screen=new ScreenDiff();
        add(screen);
        setPreferredSize(Const.prefSize);
        
        
        pack();
        setVisible(true);
    }
    
    public Minesweeper(int screenType)
    {
        bombMap=new BombMap();
        if(screenType==0)
        {
            screen=new ScreenDiff();
        }
        else if(screenType==1)
        {
            screen=new ScreenPlay(bombMap);
        }
        else if(screenType==2)
        {
            screen=new ScreenEnd();
        }
        add(screen);
        setPreferredSize(Const.prefSize);
        
        pack();
        setVisible(true);
    }
}
