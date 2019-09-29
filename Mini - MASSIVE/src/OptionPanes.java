import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
            setValues(Warrior.archerStats, "Archer");
            setValues(Warrior.knightStats, "Knight");
            setValues(Warrior.dragonStats, "Dragon");
            setValues(Warrior.orcStats, "Orc");
            setValues(Warrior.ogreStats, "Ogre");
        } else { //set defaults for each class to 'balanced' values
            //each warrior has an array set up that gives the max and min values stored in the format shown below
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
        int absValue = 50;
        int numArchers = numClass("archers", allianceNumber, absValue);
        int numKnights = numClass("knights", allianceNumber, absValue);
        int numDragons = numClass("dragons", allianceNumber, absValue);
        int numOrcs = numClass("orcs", allianceNumber, absValue);
        int numOgres = numClass("ogres", allianceNumber, absValue);


        return new Army(allianceNumber, numArchers, numKnights, numDragons, numOrcs, numOgres);
    }

    /**
     * creates a JSlider input for a number of units to be put in an army, an uninitialized value puts 0 of that unit
     * in the game
     * @param name the name of the unit
     * @param allianceNumber the number of the army that that unit would be placed in to
     * @param absValue the absolute number of that unit allowed
     * @return the selected number of that unit
     */
    private static int numClass(String name, int allianceNumber, int absValue){
        //create new pane
        JPanel pane;
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));
        JOptionPane optionPane = new JOptionPane();

        JSlider slider = sliding(optionPane, absValue);
        optionPane.setMessage(new Object[] {"Please enter a number of " + name +  " for army " + allianceNumber, slider});
        optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
        optionPane.setOptionType(JOptionPane.YES_NO_OPTION);
        JDialog dialog = optionPane.createDialog(pane, "Stat Slider");
        //this is depreciated but its staying cause it doesnt break anything and I'm scared that if i remove it it will break
        dialog.show();
        if(optionPane.getInputValue().equals(JOptionPane.UNINITIALIZED_VALUE)){
            //if the user hits no or does not select a value then there is a 0 for that unit
            return 0;
        }
        else{
            //return the selected number of that unit
            return (int) optionPane.getInputValue();
        }
    }

    /**
     * creates a slider for use in java
     * @param optionPane the optionPane to be written to
     * @param maxNum the maximum number allowed on the slider
     * @return the slider reference
     */
    private static JSlider sliding(final JOptionPane optionPane, int maxNum){
        JSlider slider = new JSlider(0, maxNum);
        slider.setMajorTickSpacing(maxNum/10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        //adapt the input based on changes from the user
        ChangeListener changeListener = changeEvent -> {
            JSlider theSlider = (JSlider)changeEvent.getSource();
            if(!theSlider.getValueIsAdjusting()){
                optionPane.setInputValue((int)(theSlider.getValue()));
            }
        };
        slider.addChangeListener(changeListener);
        return slider;
    }

    /**
     * fetch user input from a JSlider and feed it back as a value for an attribute of all warriors of that type
     * @param name the name of the attribute to change
     * @param absValue the max that attribute can be for any unit
     * @return the selected number for that specific attribute from the user
     */
    private static int numAttribute(String name, int absValue, String unit){
        //create new pane
        JPanel pane;
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));
        JOptionPane optionPane = new JOptionPane();

        JSlider slider = sliding(optionPane, absValue);
        optionPane.setMessage(new Object[] {"Please enter a the desired value of " + name + " for " + unit, slider});
        optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
        optionPane.setOptionType(JOptionPane.YES_NO_OPTION);
        JDialog dialog = optionPane.createDialog(pane, "Stat Slider");
        //this is depreciated but its staying cause it doesnt break anything and I'm scared that if i remove it it will break
        dialog.show();
        if(optionPane.getInputValue().equals(JOptionPane.UNINITIALIZED_VALUE)){
            //if the user hits no or does not select a value then there is a 0 for that unit
            return absValue/2;
        }
        else{
            //return the selected number of that unit
            return (int) optionPane.getInputValue();
        }
    }

    /**
     * setValues() prompts the user with a JOptionPane for all the values in a attribute array for a given warrior class
     *
     * @param stats the attribute array to be written to
     * @param name  the name of the warrior class to be written to
     */
    private static void setValues(int[] stats, String name){
        //this could definitely be smaller but im not sure how I would do it.
        int health = numAttribute("health", absHealth, name);
        int minAttack = numAttribute("min Attack", absAttack, name);
        int maxAttack = numAttribute("max Attack", absAttack, name);
        int minSpeed = numAttribute("min Speed", absSpeed, name);
        int maxSpeed = numAttribute("max Speed", absSpeed, name);
        int minCourage = numAttribute("min Courage", absCourage, name);
        int maxCourage = numAttribute("max Courage", absCourage, name);
        int range = numAttribute("range", absRange, name);
        int size = numAttribute("size", absSize, name);

        if(isMinLargerMax(minAttack, maxAttack)){
            int temp = minAttack;
            minAttack = maxAttack;
            maxAttack = temp + 2;
        }
        if(isMinLargerMax(minSpeed, maxSpeed)){
            int temp = minSpeed;
            minSpeed = maxSpeed;
            maxSpeed = temp + 2;
        }
        if(isMinLargerMax(minCourage, maxCourage)){
            int temp = minCourage;
            minCourage = maxCourage;
            maxCourage = temp + 2;
        }
        stats[0] = health;
        stats[1] = minAttack;
        stats[2] = maxAttack;
        stats[3] = minSpeed;
        stats[4] = maxSpeed;
        stats[5] = minCourage;
        stats[6] = maxCourage;
        stats[7] = range;
        stats[8] = size;

    }

    /**
     * isMinLargerMax() determines if a user has mistakenly inserted a value larger than the desired max value
     *
     * @param maybeMin the users supposed min value
     * @param maybeMax the users supposed max value
     * @return a true of the supposed min is larger than the supposed max
     */
    private static boolean isMinLargerMax(int maybeMin, int maybeMax) {
        return maybeMin >= maybeMax;
    }
}