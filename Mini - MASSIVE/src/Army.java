import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Army{

    private int allianceNum;
    private int numArchers;
    private int numKnights;
    private int numDragons;
    private int numOrcs;

    ArrayList<Warrior> soldiers = new ArrayList<Warrior>();

    public Army(){
        this.allianceNum = 0;
        this.numArchers = 0;
        this.numKnights = 0;
    }

    public Army(int allianceNum, int numArchers, int numKnights, int numDragons, int numOrcs, int numOgres){
        this.allianceNum = allianceNum;
        for (int i = 0; i < numArchers; i++) {
            soldiers.add(new Archer());
            soldiers.get(i).setxPos(generateX(allianceNum));
            soldiers.get(i).setyPos(generateY(allianceNum));
        }
        for (int i = 0; i < numKnights; i++) {
            soldiers.add(new Knight());
            soldiers.get(i).setxPos(generateX(allianceNum));
            soldiers.get(i).setyPos(generateY(allianceNum));
        }
        for (int i = 0; i < numOrcs; i++) {
            soldiers.add(new Orc(50,200,3,6,10,20,20,40,50));
            soldiers.get(i).setxPos(generateX(allianceNum));
            soldiers.get(i).setyPos(generateY(allianceNum));
        }
        for (int i = 0; i < numOgres; i++) {
            soldiers.add(new Ogre(100,200,3,12,10,20,20,40,50));
            soldiers.get(i).setxPos(generateX(allianceNum));
            soldiers.get(i).setyPos(generateY(allianceNum));
        }
        for (int i = 0; i < numDragons; i++) {
            soldiers.add(new Dragon());
            soldiers.get(i).setxPos(generateX(allianceNum));
            soldiers.get(i).setyPos(generateY(allianceNum));
        }
        setAllianceColor(allianceNum, soldiers);

    }
    private static void setAllianceColor(int allianceNum, ArrayList<Warrior> soldiers){
        switch (allianceNum) {
            case 0:
                for (Warrior warrior : soldiers) {
                    warrior.setColor(Color.BLACK);
                }
                break;
            case 2:
                for (Warrior soldier : soldiers) {
                    soldier.setColor(Color.BLUE);
                }
                break;
            case 1:
                for (Warrior warrior : soldiers) {
                    warrior.setColor(Color.YELLOW);
                }
                break;
            case 3:
                for (Warrior warrior : soldiers) {
                    warrior.setColor(Color.RED);
                }
                break;
            default:
                for (Warrior warrior : soldiers) {
                    warrior.setColor(Color.GREEN);
                }
                break;
        }
    }
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public int generateX(int allianceNum){
        Random rand = new Random();
        switch (allianceNum) {
            case 0:
            case 2:
                return getRandomNumberInRange(0,Main.SIZE);
            case 1:
            case 3:
                return getRandomNumberInRange(Main.SIZE /2, Main.SIZE);
            default:
                return 0;
        }

    }

    public int generateY(int allianceNum){
            Random rand = new Random();
            switch (allianceNum) {
                case 0:
                case 3:
                    return getRandomNumberInRange(0,Main.SIZE);
                case 1:
                case 2:
                    return getRandomNumberInRange(Main.SIZE /2, Main.SIZE);
                default:
                    return 0;
            }
    }

    public int getAllianceNum() {
        return allianceNum;
    }

    public void setAllianceNum(int allianceNum) {
        this.allianceNum = allianceNum;
    }

    public int getNumArchers() {
        return numArchers;
    }

    public void setNumArchers(int numArchers) {
        this.numArchers = numArchers;
    }

    public int getNumKnights() {
        return numKnights;
    }

    public void setNumKnights(int numKnights) {
        this.numKnights = numKnights;
    }

    public int getNumDragons() {
        return numDragons;
    }

    public void setNumDragons(int numDragons) {
        this.numDragons = numDragons;
    }

    public int numAlive(){
        int numAlive = 0;
        for (int i = 0; i < soldiers.size(); i++) {
            if(soldiers.get(i).isAlive()){
                numAlive++;
            }
        }
        return numAlive;
    }

    public int getNumOrcs() {
        return numOrcs;
    }

    public void setNumOrcs(int numOrcs) {
        this.numOrcs = numOrcs;
    }
}
