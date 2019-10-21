import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ListenerDemo extends JFrame {

    private JPanel contentPane;
    private JPanel displayPanel;
    private JLabel lblReportLabel;
    private JButton btnDemoButton;

    AnimationThread animation;

    //////////////////// special keyboard dispatcher //////////////////////
    // obtained from:
    //    http://stackoverflow.com/questions/286727

    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                lblReportLabel.setText("Key pressed: " + e.getKeyChar());
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                lblReportLabel.setText("Key released: " + e.getKeyChar());
            } else if (e.getID() == KeyEvent.KEY_TYPED) {
                lblReportLabel.setText("Key typed: " + e.getKeyChar());
            }
            return false;
        }
    }
    ////////////////// end of special keyboard dispatcher /////////////////

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // anonymous launch
            public void run() {
                try {
                    ListenerDemo frame = new ListenerDemo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ListenerDemo() {
        setTitle("PEX 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        new Battle();
		setBounds(10, 10, Main.SIZE, Main.SIZE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getDisplayPanel());
        contentPane.add(getLblReportLabel());
        contentPane.add(getBtnDemoButton());
        /////////// special keyboard handling //////////////////
        KeyboardFocusManager manager =
                KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        /////////// end of special added code //////////////////

    }

    private JPanel getDisplayPanel() {
        if (displayPanel == null) {

            ///////////////
            displayPanel = new AnimationArea(); // subclass of JPanel();
            ///////////////

            displayPanel.addMouseListener(new DisplayPanelMouseListener());
            displayPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
            displayPanel.setBackground(Color.WHITE);
			displayPanel.setBounds(10, 10, Main.SIZE, Main.SIZE);
            displayPanel.setLayout(null);

            ///////////////
            animation = new AnimationThread((AnimationArea) displayPanel);
            animation.start();
            ///////////////

        }
        return displayPanel;
    }

    private JLabel getLblReportLabel() {
        if (lblReportLabel == null) {
            lblReportLabel = new JLabel("This is where feedback goes...");
			lblReportLabel.setBounds(10, Main.SIZE - Main.SIZE / 10, 206, 29);
        }
        return lblReportLabel;
    }

    private JButton getBtnDemoButton() {
        if (btnDemoButton == null) {
            btnDemoButton = new JButton("Demo Button");
            btnDemoButton.addMouseListener(new BtnDemoButtonMouseListener());
			btnDemoButton.setBounds(226, Main.SIZE - Main.SIZE / 10, 198, 29);
        }
        return btnDemoButton;
    }

    private class DisplayPanelMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            lblReportLabel.setText("Mouse clicked at (" + mouseEvent.getX() +
                    ", " + mouseEvent.getY() + ")");
            animation.toggleAnimation();
        }
    }

    private class BtnDemoButtonMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            lblReportLabel.setText("Demo Button was pressed");
        }
    }
}
