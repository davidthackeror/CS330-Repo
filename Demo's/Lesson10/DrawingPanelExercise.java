import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.*;

/**
 * Simulation of a number of user-placed balls with one infected where the balls move in random directions
 *      bouncing off the sides and infecting each other when they touch.
 * @author  Steve Hadfield
 * @date    3 Sep 2018
 */
public class DrawingPanelExercise {

    private static final int NUM_BALLS = 10;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int TIME_STEP = 50;

    /**
     * Creates a bevy of balls based upon when the user clicks.  Balls then move randomly about the graphics
     *      window bouncing off the walls.  One ball is infected (shows as red).  When an infected ball hits
     *      another ball, the other ball becomes infected as well.  The animation continues until the user hits
     *      any key.
     * @param args unused
     */
    public static void main(String[] args) {

        Ball[] bevyOfBalls = new Ball[ NUM_BALLS ];  // instantiate array for the bevy of balls

        // set up the DrawingPanel and Graphics2D objects

        DrawingPanel panel = new DrawingPanel( WINDOW_WIDTH, WINDOW_HEIGHT );
        panel.setWindowTitle("CS330 Lsn11 - Bevy of Bouncing Balls");

        Graphics2D g = panel.getGraphics();
        panel.setBackground( Color.LIGHT_GRAY );
        panel.copyGraphicsToScreen();

        // set the static Ball attributes for our graphics window

        Ball.setWindowWidth( WINDOW_WIDTH );
        Ball.setWindowHeight( WINDOW_HEIGHT );
        Ball.setGraphics2D( g );

        // prompt the user to place the balls

        JOptionPane.showMessageDialog( null, "Left click " + NUM_BALLS +
                " times to place the balls.", "User Input Required", INFORMATION_MESSAGE );

        // place balls where the user clicks

        for (int i=0; i < NUM_BALLS; i++ ) {
            panel.waitForMouseClick(DrawingPanel.LEFT_BUTTON);
            int ballX = panel.getMouseClickX(DrawingPanel.LEFT_BUTTON);
            int ballY = panel.getMouseClickY(DrawingPanel.LEFT_BUTTON);
            bevyOfBalls[i] = new Ball( ballX, ballY );
            bevyOfBalls[i].draw();
            panel.copyGraphicsToScreen();
        }

        // TBD2: infect the first ball

        // notify user that the animation will now commence

        JOptionPane.showMessageDialog( null, "All " + NUM_BALLS +
                " balls are placed.\nAnimation will now commence.\nHit any key to end.",
                "User Notification", INFORMATION_MESSAGE );

        panel.setWindowTitle("CS330 Lsn11 - Bevy of Bouncing Balls (Hit any key to end)");

        // animate movement of the bevy of balls

        while( !panel.keyHasBeenHit( DrawingPanel.ANY_KEY) ) {
            // TBD1: clear the current drawing
            // TBD1: move and draw all the Balls in bevyOfBalls array
            // TBD2: spread the infection

            panel.sleep( TIME_STEP ); // pause to pace the animation
            panel.copyGraphicsToScreen();
        }
        panel.closeWindow();
    } // end main() method

    /**
     * checks each Ball object in bevy against each other.  If two balls are in contact and one is infected,
     *      then the other becomes infected.
     * @param bevy array of the Ball objects
     */
    private static void spreadInfection( Ball[] bevy ) {

        // TBD2:  add code to check each ball against each other.  If they are in contact and one is infected
        //          have the other become infected
    }

}  // end Main() class
