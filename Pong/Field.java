import java.awt.*;
import javax.swing.*;

public class Field extends JPanel
{
    public static Paddle paddle;
    public static Ball ball;
    private Container contentPane;
    
    public Field()
    {
        setBackground(Color.yellow);
        setBounds(0,0,400,400);   
        ball=new Ball();
        paddle=new Paddle(100);
        this.add(ball);
        this.add(paddle);
    }
    
    public void setBallPos(int x, int y)
    {
        ball.setLocation(x,y);
    }
    
    public void setPaddlePos(int x)
    {
        paddle.setLocation(x, this.getHeight()-50);
    }
    
    public Ball getBall()
    {
        return ball;
    }
    
    public Paddle getPaddle()
    {
        return paddle;
    }
    
    public static int[] startPos()
    {
        int x=(int) ball.getLocation().getX();
        int y=(int) ball.getLocation().getY();
        int[] r={x,y};
        return r;
    }
}

