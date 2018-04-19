import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Pong
{
    public Field field;
    private JFrame fenster;
    private Container contentPane;
    private Random random;
    
    public Pong()
    {
        random=new Random();
        fenster=new JFrame("Pong");
        contentPane=fenster.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JButton start=new JButton("Start");
        start.setPreferredSize(new Dimension(400,20));
        contentPane.add(start, BorderLayout.NORTH);
        field=new Field();
        field.setPreferredSize(new Dimension(400,400));
        contentPane.add(field, BorderLayout.CENTER);
        
        fenster.pack();
        fenster.setVisible(true);
    }

    public void init()
    {
        setBallPos(field.getWidth()/2-field.getBall().getWidth()/2,0);
        setPaddlePos(field.getWidth()/2-field.getPaddle().getWidth()/2);
    }
    
    public void setBallPos(int x, int y)
    {
        field.setBallPos(x,y);
    }
    
    public void setPaddlePos(int x)
    {
        field.setPaddlePos(x);
    }
}
