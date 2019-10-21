import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AnimationArea extends JPanel {

    private int xPos;  // dot's position
    private int yPos;

    // constructor for AnimationArea objects
    public AnimationArea() {
        super();    // constructor for JPanel
        xPos = 10;  // initialize ball position
        yPos = 10;
    }

    // animate() is called as separate thread
    //    via AnimationThread object
    public void animate() {

        Battle.moveWarriors();

    } // end animate() method

    // paint() is called automatically by the JVM
    public void paint(Graphics g) {

        // clear the background
        Battle.drawArmy(g);
        this.repaint();    // make updated graphics visible

    } // end paint()

} // end AnimationArea class
