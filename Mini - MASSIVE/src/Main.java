import java.awt.*;

/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Main
{
    private static final int SIZE = 1000;
    private static final int TIME_STEP = 100;

    public static void main(String[] args){
        Army allies = new Army(15,0, 10 ,5,0,0,0);

        for (int i = 0; i < allies.getNumWarriors(); i++) {
            System.out.println("Allegiance of " + i + " is " + allies.getAllianceNum());
            System.out.println("xPos & yPos of " + i + " is " + allies.soldiers.get(i).getxPos() + " " + allies.soldiers.get(i).getyPos());
            System.out.println("Health of " + i + " is " + allies.soldiers.get(i).getHealth());
            System.out.println("Courage of " + i + " is " + allies.soldiers.get(i).getCourage());
            System.out.println("Size of " + i + " is " + allies.soldiers.get(i).getSize());
            System.out.println("Attack of " + i + " is " + allies.soldiers.get(i).getAttack());
            System.out.println("Speed of " + i + " is " + allies.soldiers.get(i).getSpeed());
            System.out.println();
        }

        Army axis = new Army(16,1,0,0,1,10,5);

        for (int i = 0; i < axis.getNumWarriors(); i++) {
            System.out.println("Allegiance of " + i + " is " + axis.getAllianceNum());
            System.out.println("xPos & yPos of " + i + " is " + axis.soldiers.get(i).getxPos() + " " + axis.soldiers.get(i).getyPos());
            System.out.println("Health of " + i + " is " + axis.soldiers.get(i).getHealth());
            System.out.println("Courage of " + i + " is " + axis.soldiers.get(i).getCourage());
            System.out.println("Size of " + i + " is " + axis.soldiers.get(i).getSize());
            System.out.println("Attack of " + i + " is " + axis.soldiers.get(i).getAttack());
            System.out.println("Speed of " + i + " is " + axis.soldiers.get(i).getSpeed());
            System.out.println();
        }

        DrawingPanel panel = new DrawingPanel(SIZE, SIZE);
        panel.setBackground(Color.WHITE);
        Graphics2D g = panel.getGraphics();

        while (!panel.mouseClickHasOccurred(DrawingPanel.LEFT_BUTTON)) {

            panel.setWindowTitle("CS330 Mini Massive: " +
                    (allies.getNumWarriors() + axis.getNumWarriors())  + " soldiers alive");

            panel.setBackground(Color.WHITE);  // clear old display
//            Battle.attackWarriors(axis, allies);
            Battle.moveWarriors(axis, allies);
            Battle.drawWarriors(g, axis, allies);

            panel.copyGraphicsToScreen();  // update display
            panel.sleep(TIME_STEP);  // delay for time step

        } // end of animation while loop

        panel.closeWindow();  // all done



    }


}
