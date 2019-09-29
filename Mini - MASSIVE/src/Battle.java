import javax.sound.sampled.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.io.*;

/**
 * Project: Mini - MASSIVE
 * : Controls execution of the battle
 *
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */
class Battle {
    static String fileName = "Mini - MASSIVE/src/Minecraft-death-sound.wav";

    Battle(Graphics2D g, Army allies, Army axis) {
        attackWarriors(axis, allies);
        moveWarriors(axis, allies);
        Battle.drawWarriors(g, axis, allies);

    }

    /**
     * detectEnemy() uses the Vector330Class to determine the enemy closest to a selected warrior
     *
     * @param attacker  the specific warrior to detect the closest enemy for
     * @param defenders the entire enemy army
     * @return the index of the closest enemy to that soldier
     */
    private static int detectEnemy(Warrior attacker, Army defenders) {
        int index = -1;
        double minimumDistance = 1000;
        Vector330Class calcVector = new Vector330Class();
        //for every defender in the army check to see their distance
        for (int j = 0; j < defenders.soldiers.size(); j++) {
            //check to see if that selected soldier is alive
            if (defenders.soldiers.get(j).isAlive()) {
                //calculate a vector for the difference in positions between the warrior and the selected defender
                calcVector.setX(defenders.soldiers.get(j).getxPos() - attacker.getxPos());
                calcVector.setY(defenders.soldiers.get(j).getyPos() - attacker.getyPos());
                //check to see if that magnitude is the smallest yet
                if (calcVector.magnitude() < minimumDistance) {
                    minimumDistance = calcVector.magnitude();
                    index = j;
                }
            }
        }
        return index;
    }

    /**
     * outOfBounds() detects if a specific warrior is out of the bounds of the graphics window
     *
     * @param attacker the warrior to check its position
     * @return a true if out of bounds
     */
    private static boolean outOfBounds(Warrior attacker) {
        return attacker.getxPos() > Main.SIZE || attacker.getyPos() > Main.SIZE || attacker.getxPos() < 0 || attacker.getyPos() < 0;
    }

    /**
     * moveWarriors() will move all warriors of the respective armies closer to closest enemy detected
     *
     * @param axis   a army containing warriors
     * @param allies a army containing warriors
     */
    private static void moveWarriors(Army axis, Army allies) {
        Random rand = new Random();


        for (int i = 0; i < allies.soldiers.size(); i++) {
            //if the selected soldier is alive and can move
            if (allies.soldiers.get(i).isAlive() && allies.soldiers.get(i).isMoving()) {
                //are they out of bounds now? if so kill them.
                if (outOfBounds(allies.soldiers.get(i))) {
                    allies.soldiers.get(i).setAlive(false);
                } else {
                    //get the closest enemy
                    int index = detectEnemy(allies.soldiers.get(i), axis);

                    //if detectEnemy comes back with a -1 then there are no more alive enemies
                    try {
                        if (index == -1) {
                            throw new Exception("That does not exist.");
                        }
                    } catch (Exception e) {
                        System.out.println("An index of the nearest soldier was not found");
                        break;
                    }

                    //calculate the cowardice which is 1 - a soldiers courage. if a random roll between 1-100 generates a number <= then they run away for a tick
                    int cowardice = 100 * (1 - allies.soldiers.get(i).getCourage());
                    if (rand.nextInt(100) <= cowardice) {
                        //invert the vector to run on
                        allies.soldiers.get(i).move(-(axis.soldiers.get(index).getxPos()), (-(axis.soldiers.get(index).getyPos())));

                    } else {
                        //move the soldier towards their target
                        allies.soldiers.get(i).move(axis.soldiers.get(index).getxPos(), axis.soldiers.get(index).getyPos());

                    }
                }
            }
        }


        for (int i = 0; i < axis.soldiers.size(); i++) {
            if (axis.soldiers.get(i).isAlive() && axis.soldiers.get(i).isMoving()) {
                if (outOfBounds(axis.soldiers.get(i))) {
                    axis.soldiers.get(i).setAlive(false);
                } else {
                    int index = detectEnemy(axis.soldiers.get(i), allies);
                    //if detectEnemy comes back with a -1 then there are no more alive enemies
                    try {
                        if (index == -1) {
                            throw new Exception("That does not exist.");
                        }
                    } catch (Exception e) {
                        System.out.println("An index of the nearest soldier was not found");
                        break;
                    }

                    //calculate the cowardice which is 1 - a soldiers courage. if a random roll between 1-100 generates a number <= then they run away for a tick
                    int cowardice = (100 - axis.soldiers.get(i).getCourage());
                    if (rand.nextInt(100) <= cowardice) {
                        //invert the vector to run on
                        axis.soldiers.get(i).move(-(allies.soldiers.get(index).getxPos()), (-(allies.soldiers.get(index).getyPos())));
                    } else {
                        //move the soldier towards their target
                        axis.soldiers.get(i).move(allies.soldiers.get(index).getxPos(), allies.soldiers.get(index).getyPos());
                    }
                }
            }
        }
    }

    /**
     * drawWarriors() puts the alive warriors of each army on screen in accordance with their x and y positions
     *
     * @param g      the graphics window to draw to
     * @param axis   a army containing warriors
     * @param allies a army containing warriors
     */
    private static void drawWarriors(Graphics2D g, Army axis, Army allies) {

        for (int i = 0; i < allies.soldiers.size(); i++) {
            if (allies.soldiers.get(i).isAlive()) {
                allies.soldiers.get(i).draw(g);
            }
        }


        for (int i = 0; i < axis.soldiers.size(); i++) {
            if (axis.soldiers.get(i).isAlive()) {
                axis.soldiers.get(i).draw(g);
            }
        }
    }

    /**
     * runs through an army array and calculates damage given if possible for each attacker v one enemy
     *
     * @param Attackers the army doing the attacking at that point
     * @param Defenders the army doing the defending at that point
     */
    private static void warriorDamage(Army Attackers, Army Defenders) {
        Random rand = new Random();
        for (int i = 0; i < Attackers.soldiers.size(); i++) {
            //get the index of the closest enemy
            if (Attackers.soldiers.get(i).isAlive()) {
                int index = detectEnemy(Attackers.soldiers.get(i), Defenders);
                try {
                    if (index == -1) {
                        throw new Exception("That does not exist.");
                    }
                } catch (Exception e) {
                    System.out.println("An index of the nearest soldier was not found");
                    break;
                }
                //if the closest enemy is in range of the friendly soldier, attack with your attack stat
                if (magnitude(Attackers.soldiers.get(i), Defenders, index) <= Attackers.soldiers.get(i).getRange() + Attackers.soldiers.get(i).getSize() && Defenders.soldiers.get(index).isAlive()) {
                    //determine if attacker has missed the defender
                    if (!(rand.nextInt(100) <= 100 * Attackers.soldiers.get(i).getAttack() / (Attackers.soldiers.get(i).getAttack() + Defenders.soldiers.get(index).getAttack()))) {
                        //stop them from moving so that they can shoot or attack
                        Attackers.soldiers.get(i).setMoving(false);
                        Defenders.soldiers.get(index).setHealth(Defenders.soldiers.get(index).getHealth() - Attackers.soldiers.get(i).getAttack());

                        //show how much damage was done
                        System.out.println(Attackers.soldiers.get(i).getName() + " just dealt " + (Attackers.soldiers.get(i).getAttack()) +
                                " damage to " + Defenders.soldiers.get(index).getName());

                        if (Defenders.soldiers.get(index).getHealth() <= 0) {
                            //creates a noise when a warrior dies
                            try{
                                File soundFile = new File(fileName);
                                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioStream);
                                clip.start();
                            } catch (UnsupportedAudioFileException e) {
                                System.out.println("Audio file not supported, make sure its a wav");
                            } catch (IOException e) {
                                System.out.println("IO exception");
                            } catch (LineUnavailableException e) {
                                e.printStackTrace();
                            } finally {
                                Defenders.soldiers.get(index).setAlive(false);
                                System.out.println(Attackers.soldiers.get(i).getName() + " " + i + " just killed " + Defenders.soldiers.get(index).getName() + " " + index);
                            }

                        }
                    } else {
                        //print out a missed message
                        System.out.println(Attackers.soldiers.get(i).getName() + " has just missed " + Defenders.soldiers.get(index).getName());
                    }
                } else {
                    Attackers.soldiers.get(i).setMoving(true);
                }
            }
        }
    }


    /**
     * attackWarriors() determines which warriors can and do deal damage to the closest enemy unit in range
     *
     * @param axis   a army containing warriors
     * @param allies a army containing warriors
     */
    private static void attackWarriors(Army axis, Army allies) {
        warriorDamage(allies, axis);
        warriorDamage(axis, allies);
    }

    /**
     * magnitude() calculates the distance from a selected soldier to the closest enemy
     *
     * @param soldier  the selected warrior to compare its distance from a selected enemy
     * @param defender an army containing enemy warriors
     * @param index    the location of the closest enemy to the selected warrior
     * @return the distance between a warrior and a selected enemy
     */
    private static double magnitude(Warrior soldier, Army defender, int index) {
        double distance;
        Vector330Class calcVector = new Vector330Class();
        calcVector.setX(soldier.getxPos() - defender.soldiers.get(index).getxPos());
        calcVector.setY(soldier.getyPos() - defender.soldiers.get(index).getyPos());
        distance = calcVector.magnitude();
        return distance;
    }
}