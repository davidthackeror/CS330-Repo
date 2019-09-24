import java.awt.*;

class Ogre extends Warrior{

    private static String name = "Ogre";
    private int ogreMult = 2;
    Ogre(int minHealth, int maxHealth, int minSpeed, int maxSpeed, int minCourage, int maxCourage, int size, int minAttack, int maxAttack){
        super();
        this.setRange(1);
        this.setAttack(ogreMult * rand.nextInt(maxAttack-minAttack)+minAttack);
        this.setSpeed((rand.nextInt(maxSpeed-minSpeed)+minSpeed)/ ogreMult);
        this.setCourage(rand.nextInt(maxCourage-minCourage)+minCourage);
        this.setHealth(ogreMult * (rand.nextInt(maxHealth-minHealth)+minHealth));
        this.setSize(ogreMult * size);
    }

    public String getName() { return Orc.name; }

    public int getOgreMult(){
        return this.ogreMult;
    }

    public void setOgreMult(int ogreMult){
        this.ogreMult = ogreMult;
    }

    @Override
    public void move(int xTarget, int yTarget) {
        Vector330Class unitVector = new Vector330Class(xTarget- this.getxPos(), yTarget - this.getyPos());
        Vector330Class unit = unitVector.normalize();
        double xShift = (unit.getX() * this.getSpeed());
        double yShift = (unit.getY() * this.getSpeed());
        this.setxPos((int) (xShift + this.getxPos()));
        this.setyPos((int) (yShift+ this.getyPos()));

    }

    @Override
    public void draw(Graphics2D g) {
        {

            g.setColor(this.getColor());
            g.fillOval(this.getxPos()-this.getSize(), this.getyPos()-this.getSize(),
                    this.getSize()*2, this.getSize()*2);
        }
    }
}
