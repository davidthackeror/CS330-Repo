import java.awt.*;

class Orc extends Warrior{
    private static String name = "Orc";

    Orc(int minHealth, int maxHealth, int minSpeed, int maxSpeed, int minCourage, int maxCourage, int size, int minAttack, int maxAttack){
        super();
        this.setColor(Color.black);
        this.setxPos(rand.nextInt(400)+600);
        this.setyPos(rand.nextInt(400)+600);
        this.setRange(1);
        this.setAttack(rand.nextInt(maxAttack-minAttack)+minAttack);
        this.setSpeed(rand.nextInt(maxSpeed-minSpeed)+minSpeed);
        this.setCourage(rand.nextInt(maxCourage-minCourage)+minCourage);
        this.setHealth(rand.nextInt(maxHealth-minHealth)+minHealth);
        this.setSize(size);
    }

    public String getName() { return Orc.name; }

    @Override
    public void move(int xTarget, int yTarget) {
        Vector330Class unitVector = new Vector330Class(xTarget- this.getxPos(), yTarget - this.getyPos());
        Vector330Class unit = unitVector.normalize();
        double xShift = (unit.getX() * this.getSpeed());
        double yShift = (unit.getY() * this.getSpeed());
        this.setxPos((int) (xShift + this.getxPos()));
        this.setyPos( (int) yShift+ this.getyPos());

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
