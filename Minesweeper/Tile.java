import java.awt.*;
import javax.swing.*;
import javafx.scene.text.Font;

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
       setPreferredSize(Const.prefSizeTile);
       addActionListener(e->flip());
      
    }
    
    public int flip()
    {
        if(Const.flagging)
        {
            if(flagged&&!flipped)
            {
                setBackground(Color.gray);
                flagged=false;
                return -2;
            }
            else if(!flipped)
            {
                setBackground(Color.black);
                flagged=true;
                return -2;
            }
        }
        else
        {
            if(flagged)
            {
                return -2;
            }
            else if(!Const.firstFlipped)
            {
                Const.firstFlipped=true;
                return -3;
            }
            else if(!flipped)
            {
                if(value==-1)
                {
                    System.out.println("lost");
                    setBackground(Color.red);
                    return value;
                }
                else if(value==0)
                {
                    flipped=true;
                    setBackground(Color.blue);
                    return value;
                }
                else if(value>0)
                {
                    setText(""+ value);
                    setBackground(Color.blue);
                    flipped=true;
                    return value;
                }
            }
        }
        return -2;
    }
    
    
    
    
}
