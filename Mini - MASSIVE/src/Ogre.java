import java.awt.*;

/**
 * Project: Mini - MASSIVE
 * : The Ogre Soldier Sub-Class
 *
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */

class Ogre extends Warrior{

    private static String name = "Ogre";

    Ogre(int minHealth, int maxHealth, int minSpeed, int maxSpeed, int minCourage, int maxCourage, int size, int minAttack, int maxAttack){
        super();
        this.setxPos(1);
        this.setyPos(1);
        this.setHealth(ogreStats[0]);
        this.setAttack(Army.getRandomNumberInRange(ogreStats[1], ogreStats[2]));
        this.setSpeed(Army.getRandomNumberInRange(ogreStats[3], ogreStats[4]));
        this.setCourage(Army.getRandomNumberInRange(ogreStats[5], ogreStats[6]));
        this.setSize(ogreStats[7]);
        this.setRange(ogreStats[8]);
    }

    /**
     * getName()
     *
     * @return name of the warrior generated by this subclass
     */
    public String getName() { return Orc.name;
    }

    /**
     * move() - Moves the warrior in the direction of the target x and y in proportion to it's speed
     *
     * @param xTarget The x coordinate of the target enemy soldier
     * @param yTarget The y coordinate of the target enemy soldier
     */
    @Override
    public void move(int xTarget, int yTarget) {
        Vector330Class unitVector = new Vector330Class(xTarget- this.getxPos(), yTarget - this.getyPos());
        Vector330Class unit = unitVector.normalize();
        double xShift = (unit.getX() * this.getSpeed());
        double yShift = (unit.getY() * this.getSpeed());
        this.setxPos((int) (xShift + this.getxPos()));
        this.setyPos((int) (yShift+ this.getyPos()));

    }

    /**
     * draw() - puts the selected warrior on the screen with its assigned x, y, size, and color
     * @param g The graphics window to be written to
     */
    @Override
    public void draw(Graphics2D g) {
        {

            g.setColor(this.getColor());
            g.fillOval(this.getxPos()-this.getSize(), this.getyPos()-this.getSize(),
                    this.getSize()*2, this.getSize()*2);
            g.setColor(Color.magenta);

            g.drawString("Ogre", this.getxPos(), this.getyPos());
        }
    }
}