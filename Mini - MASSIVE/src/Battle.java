import java.awt.*;

/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Battle {

    private static void Battle(Warrior allies, Warrior axis){
        for (int i = 0; i < allies.getSize() + axis.getSize(); i++) {

        }
    }

    private static int detectEnemy(Warrior attacker, Army defenders){
        int index = 0;
        double minimumDistance = 1000;
        Vector330Class calcVector = new Vector330Class();
        for (int j = 0; j < defenders.soldiers.size(); j++) {
            calcVector.setX(defenders.soldiers.get(j).getxPos()-attacker.getxPos());
            calcVector.setY(defenders.soldiers.get(j).getyPos()-attacker.getyPos());
            if(calcVector.magnitude() < minimumDistance){
                minimumDistance = calcVector.magnitude();
                index = j;
            }
        }
        return index;
    }

    static void moveWarriors(Army axis, Army allies){
        for (int i = 0; i < allies.getNumWarriors(); i++) {
            int index = detectEnemy(allies.soldiers.get(i), axis);

            allies.soldiers.get(i).move(axis.soldiers.get(index).getxPos(),axis.soldiers.get(index).getyPos());
        }


        for (int i = 0; i < axis.getNumWarriors(); i++) {
            int index = detectEnemy(axis.soldiers.get(i), allies);

            axis.soldiers.get(i).move(allies.soldiers.get(index).getxPos(),allies.soldiers.get(index).getyPos());
        }
    }
    static void drawWarriors(Graphics2D g, Army axis, Army allies) {

        for (int i = 0; i < allies.getNumWarriors(); i++) {
            allies.soldiers.get(i).draw(g);
        }


        for (int i = 0; i < axis.getNumWarriors(); i++) {
            axis.soldiers.get(i).draw(g);

        }
    }

    public static void attackWarriors(Army axis, Army allies) {

    }
}
