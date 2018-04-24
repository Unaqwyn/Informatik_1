import java.awt.*;
import javax.swing.*;

public class Tile extends JButton
{
    private boolean flagged=false;
    private int value;
    private boolean flipped=false;
    
    public Tile(int value)
    {
       int x=Const.sizeTiles;
       this.value=value;
       setBackground(Color.gray);
       setBounds(0,0,x,x);
    }
    
    public void flip()
    {
        if(Const.flagging)
        {
            if(flagged&&!flipped)
            {
                flagged=false;
            }
            else if(!flipped)
            {
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
                    System.out.println("lost");
                    setBackground(Color.red);
                }
                else if(value==0)
                {
                    flipped=true;
                    setBackground(Color.blue);
                }
                else if(value>0)
                {
                    setText(""+ value);
                    setBackground(Color.blue);
                    flipped=true;
                }
            }
            else if(value!=-1&&flipped)
            {
            
            }
        }
    }
}
