import java.awt.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
public class Battle {

    private Battle(Warrior allies, Warrior axis){

    }

    private static int detectEnemy(Warrior attacker, Army defenders){
        int index = -1;
        double minimumDistance = 1000;
        Vector330Class calcVector = new Vector330Class();
        for (int j = 0; j < defenders.soldiers.size(); j++) {
            if(defenders.soldiers.get(j).isAlive()){
                calcVector.setX(defenders.soldiers.get(j).getxPos()-attacker.getxPos());
                calcVector.setY(defenders.soldiers.get(j).getyPos()-attacker.getyPos());
                if(calcVector.magnitude() < minimumDistance){
                    minimumDistance = calcVector.magnitude();
                    index = j;
                }
            }
        }
        return index;
    }

    static boolean outOfBounds(Warrior attacker){
        if(attacker.getxPos() > Main.SIZE || attacker.getyPos() > Main.SIZE || attacker.getxPos() < 0 || attacker.getyPos() < 0){
            return true;
        }
        else{
            return false;
        }
    }

    static void moveWarriors(Army axis, Army allies){
        Random rand = new Random();
        for (int i = 0; i < allies.soldiers.size(); i++) {
            if(allies.soldiers.get(i).isAlive() && allies.soldiers.get(i).isMoving()) {
                if (outOfBounds(allies.soldiers.get(i))) {
                    allies.soldiers.get(i).setAlive(false);
                } else {
                    int index = detectEnemy(allies.soldiers.get(i), axis);
                    try {
                        if (index == -1) {
                            throw new Exception("That does not exist.");
                        }
                    } catch (Exception e) {
                        System.out.println("An index of the nearest soldier was not found");
                        break;
                    }
                    int cowardice = 100 * (1 - allies.soldiers.get(i).getCourage());
                    if(rand.nextInt(100) <= cowardice ){
                        allies.soldiers.get(i).move(-(axis.soldiers.get(index).getxPos()), (-(axis.soldiers.get(index).getyPos())));

                    }
                    else{
                        allies.soldiers.get(i).move(axis.soldiers.get(index).getxPos(), axis.soldiers.get(index).getyPos());

                    }
                }
            }
        }


        for (int i = 0; i < axis.soldiers.size(); i++) {
            if(axis.soldiers.get(i).isAlive() && axis.soldiers.get(i).isMoving()) {
                if (outOfBounds(axis.soldiers.get(i))) {
                    axis.soldiers.get(i).setAlive(false);
                } else {
                    int index = detectEnemy(axis.soldiers.get(i), allies);
                    try {
                        if (index == -1) {
                            throw new Exception("That does not exist.");
                        }
                    } catch (Exception e) {
                        System.out.println("An index of the nearest soldier was not found");
                        break;
                    }
                    int cowardice = (100 - axis.soldiers.get(i).getCourage());
                    if(rand.nextInt(100) <= cowardice ){
                        axis.soldiers.get(i).move(-(allies.soldiers.get(index).getxPos()), (-(allies.soldiers.get(index).getyPos())));

                    }
                    else{
                        axis.soldiers.get(i).move(allies.soldiers.get(index).getxPos(), allies.soldiers.get(index).getyPos());
                    }
                }
            }
        }
    }
    static void drawWarriors(Graphics2D g, Army axis, Army allies) {

        for (int i = 0; i < allies.soldiers.size(); i++) {
            if(allies.soldiers.get(i).isAlive()){
                allies.soldiers.get(i).draw(g);
            }
        }


        for (int i = 0; i < axis.soldiers.size(); i++) {
            if(axis.soldiers.get(i).isAlive()){
                axis.soldiers.get(i).draw(g);
            }
        }
    }

    public static void attackWarriors(Army axis, Army allies) {
        for (int i = 0; i < allies.soldiers.size(); i++) {
            //get the index of the closest enemy
            if(allies.soldiers.get(i).isAlive()) {
                int index = detectEnemy(allies.soldiers.get(i), axis);
                try{
                    if (index == -1){
                        throw new Exception("That does not exist.");
                    }
                }
                catch (Exception e){
                    System.out.println("An index of the nearest soldier was not found");
                    break;
                }
                //if the closest enemy is in range of the friendly soldier, attack with your attack stat
                if(magnitude(allies.soldiers.get(i), axis, index) <= allies.soldiers.get(i).getRange() && axis.soldiers.get(index).isAlive()){
                    //set the enemy soldiers health to the attack - your prevous health
                    allies.soldiers.get(i).setMoving(false);
                    axis.soldiers.get(index).setHealth(axis.soldiers.get(index).getHealth() - allies.soldiers.get(i).getAttack());
                    if(axis.soldiers.get(index).getHealth() <= 0){
                        axis.soldiers.get(index).setAlive(false);
                    }
                }
                else{
                    allies.soldiers.get(i).setMoving(true);
                }
            }
        }

        for (int i = 0; i < axis.soldiers.size(); i++) {
            //get the index of the closest enemy
            if(axis.soldiers.get(i).isAlive()) {
                int index = detectEnemy(axis.soldiers.get(i), allies);try{
                    if (index == -1){
                        throw new Exception("That does not exist.");
                    }
                }
                catch (Exception e){
                    System.out.println("An index of the nearest soldier was not found");
                    break;
                }
                //if the closest enemy is in range of the friendly soldier, attack with your attack stat
                if(magnitude(axis.soldiers.get(i), allies, index) <= axis.soldiers.get(i).getRange() && allies.soldiers.get(index).isAlive()){
                    //set the enemy soldiers health to the attack - your prevous health
                    axis.soldiers.get(i).setMoving(false);
                    allies.soldiers.get(index).setHealth(allies.soldiers.get(index).getHealth() - axis.soldiers.get(i).getAttack());
                    if(allies.soldiers.get(index).getHealth() <= 0){
                        allies.soldiers.get(index).setAlive(false);
                    }
                }
                else{
                    axis.soldiers.get(i).setMoving(true);
                }
            }
        }
    }

    public static double magnitude(Warrior soldier, Army defender, int index){
        double distance;
        Vector330Class calcVector = new Vector330Class();
        calcVector.setX(soldier.getxPos() - defender.soldiers.get(index).getxPos());
        calcVector.setY(soldier.getyPos() - defender.soldiers.get(index).getyPos());
        distance = calcVector.magnitude();
        return distance;
    }
}
