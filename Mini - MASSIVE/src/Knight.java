import java.awt.*;

class Knight extends Warrior{
    private static String name = "Knight";

    Knight(){
        super();

        this.setRange(1);
        this.setHealth(rand.nextInt(knightMaxHealth-knightMinHealth)+knightMinHealth);
        this.setCourage(rand.nextInt(knightMaxCourage-knightMinCourage)+ knightMinCourage);
        this.setAttack(rand.nextInt(knightMaxAttack-knightMinAttack)+knightMinAttack);
        this.setSize(15);
        this.setSpeed(2);
    }

    public String getName() { return Knight.name; }

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
