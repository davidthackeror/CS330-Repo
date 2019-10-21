import javax.swing.*;

// AnimationThread - subclass of Thread to run the animation
public class AnimationThread extends Thread {

    private AnimationArea animationArea;  // points to JPanel subclass object
    private boolean stopper = false;    // toggles animation on and off

    // constructor for AnimationThread
    public AnimationThread(AnimationArea animationPanel) {
        animationArea = animationPanel;
    }

    // toggleAnimation() - toggles animation on and off
    public void toggleAnimation() {
        this.stopper = !this.stopper;  // flip the stopper attribute
    }

    // run() method is invoked automatically by the Java VM
    public void run() {
        while (true) {
            if (!stopper) {  // for toggling on/off the animation
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        animationArea.animate();  // runs the animation
                    } // end of run() method
                });
            }
            try {
                sleep(100);  // pause between thread launches
            } catch (InterruptedException e) {
            }
        } // end of while loop

    } // end of run() method

} // end AnimationThread
