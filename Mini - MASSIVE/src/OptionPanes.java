import javax.swing.*;
import java.awt.*;

/**
 * Project: Mini - MASSIVE
 * : Displays to the user the starting JOptionPanes
 *
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
class OptionPanes {
    //These are the absolute maximums for each stat in the game
    /**
     * the maximum allowed health in the game regardless of user inputs
     */
    private static final int absHealth = 1000;
    /**
     * the maximum allowed attack in the game regardless of user inputs
     */
    private static final int absAttack = 100;
    /**
     * the maximum allowed speed in the game regardless of user inputs
     */
    private static final int absSpeed = 100;
    /**
     * the maximum allowed courage in the game regardless of user inputs
     */
    private static final int absCourage = 100;
    /**
     * the maximum allowed size in the game regardless of user inputs
     */
    private static final int absSize = 100;
    /**
     * the maximum allowed range in the game regardless of user inputs
     */
    private static final int absRange = 100;
    //these are checked against user input values in setValues below


    /**
     * optionPanes() generates the starting JOptionPanes for attributes or default values.
     */
    static void optionPanes() {
        //create a JOptionPane to see if the user wants to select default attributes or make their own for each class
        int reply = JOptionPane.showConfirmDialog(null, "Would you like to select your own attributes",
                "Accept Defaults", JOptionPane.YES_NO_OPTION);


        if (reply == JOptionPane.YES_OPTION) { //have the user generate their own
            //TODO elaborate on error checking
            setValues(Warrior.archerStats, "Archer");
            setValues(Warrior.knightStats, "Knight");
            setValues(Warrior.dragonStats, "Dragon");
            setValues(Warrior.orcStats, "Orc");
            setValues(Warrior.ogreStats, "Ogre");
        } else { //set defaults for each class to 'balanced' values
            Warrior.archerStats[0] = 50;//health
            Warrior.archerStats[1] = 10;//minAttack
            Warrior.archerStats[2] = 20;//maxAttack
            Warrior.archerStats[3] = 4;//minSpeed
            Warrior.archerStats[4] = 6;//maxSpeed
            Warrior.archerStats[5] = 10;//minCourage
            Warrior.archerStats[6] = 30;//maxCourage
            Warrior.archerStats[7] = 10;//Size
            Warrior.archerStats[8] = 10;//Range

            Warrior.knightStats[0] = 100;//health
            Warrior.knightStats[1] = 25;//minAttack
            Warrior.knightStats[2] = 45;//maxAttack
            Warrior.knightStats[3] = 4;//minSpeed
            Warrior.knightStats[4] = 8;//maxSpeed
            Warrior.knightStats[5] = 30;//minCourage
            Warrior.knightStats[6] = 60;//maxCourage
            Warrior.knightStats[7] = 15;//Size
            Warrior.knightStats[8] = 1;//Range

            Warrior.dragonStats[0] = 750;//health
            Warrior.dragonStats[1] = 30;//minAttack
            Warrior.dragonStats[2] = 75;//maxAttack
            Warrior.dragonStats[3] = 4;//minSpeed
            Warrior.dragonStats[4] = 6;//maxSpeed
            Warrior.dragonStats[5] = 90;//minCourage
            Warrior.dragonStats[6] = 100;//maxCourage
            Warrior.dragonStats[7] = 25;//Size
            Warrior.dragonStats[8] = 10;//Range

            Warrior.orcStats[0] = 75;//health
            Warrior.orcStats[1] = 10;//minAttack
            Warrior.orcStats[2] = 20;//maxAttack
            Warrior.orcStats[3] = 4;//minSpeed
            Warrior.orcStats[4] = 6;//maxSpeed
            Warrior.orcStats[5] = 25;//minCourage
            Warrior.orcStats[6] = 75;//maxCourage
            Warrior.orcStats[7] = 10;//Size
            Warrior.orcStats[8] = 1;//Range

            Warrior.ogreStats[0] = 150;//health
            Warrior.ogreStats[1] = 30;//minAttack
            Warrior.ogreStats[2] = 50;//maxAttack
            Warrior.ogreStats[3] = 2;//minSpeed
            Warrior.ogreStats[4] = 5;//maxSpeed
            Warrior.ogreStats[5] = 50;//minCourage
            Warrior.ogreStats[6] = 70;//maxCourage
            Warrior.ogreStats[7] = 20;//Size
            Warrior.ogreStats[8] = 3;//Range
        }
    }

    /**
     * armySize() prompts the user to input how many of each unit they would like in an army
     *
     * @param allianceNumber the alliance number of the generated army
     * @return a army containing the selected number of soldiers
     */
    static Army armySize(int allianceNumber) {
        //initalize JFrame values for each variable
        JFrame frame;
        frame = new JFrame();
        JPanel pane;
        JTextField numArchers;
        JTextField numKnights;
        JTextField numDragons;
        JTextField numOrcs;
        JTextField numOgres;

        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        numArchers = new JTextField(5);
        numKnights = new JTextField(5);
        numDragons = new JTextField(5);
        numOrcs = new JTextField(5);
        numOgres = new JTextField(5);

        pane.add(new JLabel("Please enter the number of archers in this army."));
        pane.add(numArchers);

        pane.add(new JLabel("Please enter the number of knights in this army."));
        pane.add(numKnights);

        pane.add(new JLabel("Please enter the number of dragons in this army."));
        pane.add(numDragons);

        pane.add(new JLabel("Please enter the number of orcs in this army."));
        pane.add(numOrcs);

        pane.add(new JLabel("Please enter the number of ogres in this army."));
        pane.add(numOgres);

        int option = JOptionPane.showConfirmDialog(frame, pane, "Please fill all the fields for army #" + allianceNumber, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        //convert the input from a string into a int
        String numArchersInput = numArchers.getText();
        int fNumArchers = Integer.parseInt(numArchersInput);
        //check to ensure the user hasn't done a negative and if so set that # of unit to 0
        if (fNumArchers < 0) {
            fNumArchers = 0;
        }

        String numKnightsInput = numKnights.getText();
        int fNumKnights = Integer.parseInt(numKnightsInput);
        if (fNumKnights < 0) {
            fNumKnights = 0;
        }

        String numDragonsInput = numDragons.getText();
        int fNumDragons = Integer.parseInt(numDragonsInput);
        if (fNumDragons < 0) {
            fNumDragons = 0;
        }

        String numOrcsInput = numOrcs.getText();
        int fNumOrcs = Integer.parseInt(numOrcsInput);
        if (fNumOrcs < 0) {
            fNumOrcs = 0;
        }

        String numOgresInput = numOgres.getText();
        int fNumOgres = Integer.parseInt(numOgresInput);
        if (fNumOgres < 0) {
            fNumOgres = 0;
        }
        return new Army(allianceNumber, fNumArchers, fNumKnights, fNumDragons, fNumOrcs, fNumOgres);
    }

    /**
     * setValues() prompts the user with a JOptionPane for all the values in a attribute array for a given warrior class
     *
     * @param stats the attribute array to be written to
     * @param name  the name of the warrior class to be written to
     */
    private static void setValues(int[] stats, String name) {
        //initalize JFrame values for each variable

        JFrame frame;
        JPanel pane;
        JTextField health;
        JTextField minAttack;
        JTextField maxAttack;
        JTextField minSpeed;
        JTextField maxSpeed;
        JTextField minCourage;
        JTextField maxCourage;
        JTextField size;
        JTextField range;


        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        health = new JTextField(5);
        minAttack = new JTextField(5);
        maxAttack = new JTextField(5);
        minSpeed = new JTextField(5);
        maxSpeed = new JTextField(5);
        minCourage = new JTextField(5);
        maxCourage = new JTextField(5);
        size = new JTextField(5);
        range = new JTextField(5);


        pane.add(new JLabel("Please enter a desired health for this unit."));
        pane.add(health);

        pane.add(new JLabel("Please enter a minimum attack for this unit."));
        pane.add(minAttack);

        pane.add(new JLabel("Please enter a maximum attack for this unit."));
        pane.add(maxAttack);

        pane.add(new JLabel("Please enter a minimum speed for this unit."));
        pane.add(minSpeed);

        pane.add(new JLabel("Please enter a maximum speed for this unit."));
        pane.add(maxSpeed);

        pane.add(new JLabel("Please enter a minimum courage for this unit."));
        pane.add(minCourage);

        pane.add(new JLabel("Please enter a maximum courage for this unit."));
        pane.add(maxCourage);

        pane.add(new JLabel("Please enter a desired size for this unit."));
        pane.add(size);

        pane.add(new JLabel("Please enter a desired range for this unit."));
        pane.add(range);

        frame = new JFrame();


        int option = JOptionPane.showConfirmDialog(frame, pane, "Please fill all the fields for " + name, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            String healthInput = health.getText();
            stats[0] = Integer.parseInt(healthInput);
            //check to see if the user value is greater than the max
            if (stats[1] > absHealth) {
                //if so set it equal to the max
                stats[1] = absHealth;
            }
            if (stats[1] < 0) {
                //if its less than 0 set it equal to 1
                stats[1] = 1;
            }

            String minAttackInput = minAttack.getText();
            String maxAttackInput = maxAttack.getText();
            stats[1] = Integer.parseInt(minAttackInput);
            stats[2] = Integer.parseInt(maxAttackInput);
            //check to see if the user has put in a value for the min greater than the max
            if (isMinLargerMax(stats[1], stats[2])) {
                //if so swap it
                int temp = stats[1] + 1;
                stats[1] = stats[2] - 1;
                stats[2] = temp;
                //check to see if the user value is greater than the max
                if (stats[2] > absAttack) {
                    //if so set it equal to the max
                    stats[2] = absAttack;
                }
                if (stats[1] < 0) {
                    //if its less than 0 set it equal to 1
                    stats[1] = 1;
                }
            }

            String minSpeedInput = minSpeed.getText();
            String maxSpeedInput = maxSpeed.getText();
            stats[3] = Integer.parseInt(minSpeedInput);
            stats[4] = Integer.parseInt(maxSpeedInput);
            //check to see if the user has put in a value for the min greater than the max
            if (isMinLargerMax(stats[3], stats[4])) {
                //if so swap it
                int temp = stats[3] + 1;
                stats[3] = stats[4] - 1;
                stats[4] = temp;
                //check to see if the user value is greater than the max
                if (stats[4] > absSpeed) {
                    //if so set it equal to the max
                    stats[4] = absSpeed;
                }
                if (stats[4] < 0) {
                    //if its less than 0 set it equal to 1
                    stats[4] = 1;
                }
            }

            String minCourageInput = minCourage.getText();
            String maxCourageInput = maxCourage.getText();
            stats[5] = Integer.parseInt(minCourageInput);
            stats[6] = Integer.parseInt(maxCourageInput);
            //check to see if the user has put in a value for the min greater than the max
            if (isMinLargerMax(stats[5], stats[6])) {
                //if so swap it
                int temp = stats[5] + 1;
                stats[5] = stats[6] - 1;
                stats[6] = temp;
                //check to see if the user value is greater than the max
                if (stats[6] > absCourage) {
                    //if so set it equal to the max
                    stats[6] = absCourage;
                }
                if (stats[6] < 0) {
                    //if its less than 0 set it equal to 1
                    stats[6] = 1;
                }
            }

            String sizeInput = size.getText();
            stats[7] = Integer.parseInt(sizeInput);
            //check to see if the user value is greater than the max
            if (stats[7] > absSize) {
                //if so set it equal to the max
                stats[7] = absSize;
            }
            if (stats[7] < 0) {
                //if its less than 0 set it equal to 1
                stats[7] = 1;
            }

            String rangeInput = range.getText();
            stats[8] = Integer.parseInt(rangeInput);
            //check to see if the user value is greater than the max
            if (stats[8] > absRange) {
                //if so set it equal to the max
                stats[8] = absRange;
            }
            if (stats[8] < 0) {
                //if its less than 0 set it equal to 1
                stats[8] = 1;
            }


        } else {
            //if the user has decided not to enter anything kick them back to the start pane
            optionPanes();
        }
    }

    /**
     * isMinLargerMax() determines if a user has mistakenly inserted a value larger than the desired max value
     *
     * @param maybeMin the users supposed min value
     * @param maybeMax the users supposed max value
     * @return a true of the supposed min is larger than the supposed max
     */
    private static boolean isMinLargerMax(int maybeMin, int maybeMax) {
        return maybeMin > maybeMax;
    }
}


