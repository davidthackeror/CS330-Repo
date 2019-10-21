import javax.swing.*;

/**
 * Project: Mini - MASSIVE
 *
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Main {
    //determines the size of the graphics display window
    static final int SIZE = 600;
    //the time to wait between drawing on screen and moving to next tick
    private static final int TIME_STEP = 100;

    public static void main(String[] args) {

        //call for preset values or not user selected values for each warrior class
        OptionPanes.optionPanes();
        Battle battle = new Battle();
        BattleGUI battleGUI = new BattleGUI();
        battleGUI.setBattle(battle);
        JFrame jFrame = new JFrame("This is a battle");
        jFrame.setContentPane(battleGUI.getHello());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        AnimationThread animationThread = new AnimationThread(battleGUI.getAnimationArea());
        animationThread.toggleAnimation();
        animationThread.start();
        battleGUI.setAnimationThread(animationThread);

    }

}

