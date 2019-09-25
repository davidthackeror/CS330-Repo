import java.awt.*;

public class DrawingPanelDemo {

    public static void main(String[] args) {

        DrawingPanel panel = new DrawingPanel( 400, 300 );
        panel.setBackground( Color.WHITE );

        Graphics2D g = panel.getGraphics();

        g.setColor( Color.LIGHT_GRAY );
        g.drawOval( 25, 25, 100, 100 );
        g.fillOval( 275, 25, 100, 100 );

        g.setColor( Color.GRAY );
        g.fillRect( 25, 175, 100, 100 );
        g.drawRect( 275, 175, 100, 100 );

        g.setColor( Color.BLUE );
        g.fillRect( 75, 75, 250, 150 );

        g.setColor( Color.WHITE );
        g.setFont( new Font("Serif", Font.ITALIC + Font.BOLD, 36 ) );
        g.drawString( "CS 330", 143, 160 );
        g.drawLine( 143, 170, 268, 170 );

        panel.setWindowTitle("CS 330 DrawingPanel Demo");
        panel.copyGraphicsToScreen();

    }
}
