import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AnimationArea extends JPanel {

    private int height;  // dot's position
    private int width;

    // constructor for AnimationArea objects
    public AnimationArea() {
        super();    // constructor for JPanel
       this.height = 800;
       this.width = 600;
       this.setSize(this.height, this.width);
    }

    // animate() is called as separate thread
    //    via AnimationThread object
    public void animate() {

        this.setVisible(true);
        Battle.moveWarriors();
        this.repaint();

    } // end animate() method

    // paint() is called automatically by the JVM
    public void paint(Graphics g) {
        g.clearRect(0,0, Main.SIZE, Main.SIZE);
        // clear the background
        Battle.drawArmy(g);

    } // end paint()

} // end AnimationArea class
