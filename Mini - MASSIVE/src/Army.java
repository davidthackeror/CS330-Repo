import java.util.ArrayList;

/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Army{
    private int numWarriors;
    private int allianceNum;
    private int numArchers;
    private int numKnights;
    private int numDragons;
    private int numOrcs;

    ArrayList<Warrior> soldiers = new ArrayList<Warrior>();

    public Army(){
        this.numWarriors = 0;
        this.allianceNum = 0;
        this.numArchers = 0;
        this.numKnights = 0;
    }

    public Army(int numWarriors, int allianceNum, int numArchers, int numKnights, int numDragons, int numOrcs, int numOgres){
        this.numWarriors = numWarriors;
        this.allianceNum = allianceNum;
        for (int i = 0; i < numArchers; i++) {
            soldiers.add(new Archer());

        }
        for (int i = 0; i < numKnights; i++) {
            soldiers.add(new Knight());
        }
        for (int i = 0; i < numOrcs; i++) {
            soldiers.add(new Orc(50,150,3,5,10,20,20,40,50));
        }
        for (int i = 0; i < numOgres; i++) {
            soldiers.add(new Ogre(50,150,3,5,10,20,20,40,50));
        }
        for (int i = 0; i < numDragons; i++) {
            soldiers.add(new Dragon());
        }
    }

    public int getNumWarriors(){
        return numWarriors;
    }

    public int getAllianceNum() {
        return allianceNum;
    }

    public void setAllianceNum(int allianceNum) {
        this.allianceNum = allianceNum;
    }

    public void setNumWarriors(int numWarriors) {
        this.numWarriors = numWarriors;
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


    public int getNumOrcs() {
        return numOrcs;
    }

    public void setNumOrcs(int numOrcs) {
        this.numOrcs = numOrcs;
    }
}
