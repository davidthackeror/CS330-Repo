import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Project: Mini - MASSIVE
 *
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Main {
    //determines the size of the graphics display window
    static final int SIZE = 1000;
    //the time to wait between drawing on screen and moving to next tick
    private static final int TIME_STEP = 100;

    public static void main(String[] args) {

        //call for preset values or not user selected values for each warrior class
        OptionPanes.optionPanes();

        //generate two armies from user input
        Army allies = OptionPanes.armySize(0);
        Army axis = OptionPanes.armySize(1);
        ArrayList<Army> armies = new ArrayList<>();
        armies.add(allies);
        armies.add(axis);

        //create a new frame to prompt the user later on to stat the sim
        JFrame frame = new JFrame();
        //open a drawing panel
        DrawingPanel panel = new DrawingPanel(SIZE, SIZE);
        panel.setBackground(Color.lightGray);
        Graphics2D g = panel.getGraphics();
        //define what the window title is
        panel.setWindowTitle("CS330 Mini Massive: " +
                (allies.numAlive() + axis.numAlive()) + " soldiers alive");

        panel.setBackground(Color.WHITE);  // clear old display
        //begin the first moves, attacks, and drawings of the game
        new Battle(g, armies);
        panel.copyGraphicsToScreen();  // update display
        panel.sleep(TIME_STEP);  // delay for time step

        //create a JOption prompt to start the simulation
        JOptionPane.showMessageDialog(frame, "Hello, Please click to begin simulation. Please turn your sound on.");


        //while the user has not left clicked on the simulation
        while (!panel.mouseClickHasOccurred(DrawingPanel.LEFT_BUTTON)) {
            if (panel.keyHasBeenHit(DrawingPanel.SPACE_KEY)) {
                g.drawString("Game has been paused", SIZE / 2, SIZE / 2);
                panel.copyGraphicsToScreen();  // update display
                while (true) {
                    panel.waitForKey();
                    int keyCode = panel.getKeyHitCode();
                    if (keyCode == DrawingPanel.SPACE_KEY) {
                        break;
                    }
                }

            }

            //define what the window title is and update it with live losses
            panel.setWindowTitle("CS330 Mini Massive: " +
                    (allies.numAlive() + axis.numAlive()) + " soldiers alive");

            panel.setBackground(Color.lightGray);
            //move, attack, and draw the battle
            new Battle(g, armies);

            //create the live army status counters
            g.setColor(Color.black);
            g.drawString("Number of Axis left alive: " + axis.numAlive(), 0, 10);
            g.drawString("Number of Allies left alive: " + allies.numAlive(), 0, 20);

            panel.copyGraphicsToScreen();  // update display
            panel.sleep(TIME_STEP);  // delay for time step

            //check to see if the axis have won
            if (axis.numAlive() == 0) {
                panel.setWindowTitle("CS330 Mini Massive: Allies have won");
                JOptionPane.showMessageDialog(frame, "Allies have won");
                break;
            }

            //check to see if the allies have won
            if (allies.numAlive() == 0) {
                panel.setWindowTitle("CS330 Mini Massive: Axis have won");
                JOptionPane.showMessageDialog(frame, "Axis have won");
                break;
            }

        } // end of animation while loop

        panel.closeWindow();  // all done

    }

}

