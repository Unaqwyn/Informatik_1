import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.Random;

public class Ball extends JPanel
{
    public int vx=0;
    public int vy=0;
    public int x;
    public int y;
    
    public Ball()
    {
        setBackground(Color.black);
        setBounds(200,0,20,20);
        setPreferredSize(new Dimension(20,20));
    }

    public void getStartPos()
    {
        int[] r=Field.startPos();
        x=r[0];
        y=r[1];
    }
    
    public void changeXPDir()
    {
        
    }
    
    public void changeYDir()
    {
        
    }
    
    public void setStartSpeed()
    {
       Random random=new Random();
       while(vx==0)
       {
           vx=random.nextInt(21);
           vx-=10;
       }
       vy=random.nextInt(10); 
       ++vy;
    }
}
