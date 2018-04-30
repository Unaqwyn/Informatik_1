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
        screen=new ScreenDiff(this);
        add(screen);
        setPreferredSize(Const.prefSize);
        
        
        pack();
        setVisible(true);
    }
    
    public Minesweeper(int screenType)
    {
        System.out.print('\u000C');
        bombMap=new BombMap();
        if(screenType==0)
        {
            screen=new ScreenDiff(this);
        }
        else if(screenType==1)
        {
            screen=new ScreenPlay(bombMap, this);
        }
        else if(screenType==2)
        {
            screen=new ScreenEnd(this);
        }
        add(screen);
        setPreferredSize(Const.prefSize);
        
        pack();
        setVisible(true);
    }
    
    public void setScreen(int screenType)
    {
        remove(screen);
        if(screenType==0)
        {
            screen=new ScreenDiff(this);
        }
        else if(screenType==1)
        {
            bombMap=new BombMap();
            screen=new ScreenPlay(bombMap, this);
        }
        else if(screenType==2)
        {
            screen=new ScreenEnd(this);
        }
        add(screen);
         setPreferredSize(Const.prefSize);
        
        pack();
        setVisible(true);
    }
}
