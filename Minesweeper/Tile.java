import java.awt.*;
import javax.swing.*;
import javafx.scene.text.Font;

public class Tile extends JButton
{
    private boolean flagged=false;
    private int value;
    private boolean flipped=false;
    private PlayArea playarea;
    private int x;
    private int y;
    
    public Tile(int value, int x, int y, PlayArea playarea)
    {
        this.x=x;
        this.y=y;
        this.playarea=playarea;
       int size=Const.sizeTiles;
       this.value=value;
       setBackground(Color.gray);
       setBounds(0,0,size,size);
       setPreferredSize(Const.prefSizeTile);
       addActionListener(e->flip(false));
       setForeground(Color.white);
      
    }
    
    public void flip(boolean chording)
    {
        if(!Const.firstFlipped)
        {
            playarea.firstFlipped(x,y);
            Const.firstFlipped=true;
            Const.tilesFlipped++;
        }
        else if(flipped&&!chording)
        {
            playarea.chord(x,y);
        }
        if(Const.flagging&&!chording)
        {
            if(flagged&&!flipped)
            {
                setBackground(Color.gray);
                flagged=false;
            }
            else if(!flipped)
            {
                setBackground(Color.black);
                flagged=true;
            }
        }
        else
        {
            if(flagged)
            {
                
            }
            else if(!flipped)
            {
                if(value==-1)
                {
                    flipped=true;
                    setBackground(Color.red);
                    playarea.end(false);
                }
                else if(value==0)
                {
                    flipped=true;
                    setBackground(Color.blue);
                    playarea.chord(x,y);
                    Const.tilesFlipped++;
                }
                else if(value>0)
                {
                    setText(""+ value);
                    setBackground(Color.blue);
                    flipped=true;
                    Const.tilesFlipped++;
                }
            }
        }
        if(Const.winCon==Const.tilesFlipped)
        {
            playarea.end(true);
        }
    }
    
    public void setValue(int val)
    {
        value=val;
    }
    
    
}
