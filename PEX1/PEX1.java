
import java.awt.*;
public class PEX1 {

    public static void main(String[] args) {

        DrawingPanel panel = new DrawingPanel(400,300);
        panel.setBackground(Color.white);

        Graphics2D g = panel.getGraphics();

        g.setColor(Color.lightGray);
        g.drawOval(25,25,100,100);
        g.fillOval(275,25,100,100);

        g.setColor(Color.gray);
        g.drawRect(25,175,100,100);
        g.fillRect(275,175,100,100);

        g.setColor(Color.blue);
        g.fillRect(75,75,250,150);

        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD,36));
        g.drwaString("CS330")
    }
}
