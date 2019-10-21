import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleGUI {
    private JPanel battlePanel;
    private JPanel Hello;
    private JButton pauseOrStart;


    private AnimationThread animationThread;
    private Battle battle;
    private AnimationArea animationArea;

    public BattleGUI() {
        pauseOrStart.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                animationThread.toggleAnimation();
            }
        });
    }

    private void createUIComponents() {
        this.battlePanel = new AnimationArea();
        this.animationArea = (AnimationArea) this.battlePanel;

    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public JPanel getHello() {
        return Hello;
    }

    public AnimationArea getAnimationArea() {
        return animationArea;
    }

    public AnimationThread getAnimationThread() {
        return animationThread;
    }

    public void setAnimationThread(AnimationThread animationThread) {
        this.animationThread = animationThread;
    }
}
