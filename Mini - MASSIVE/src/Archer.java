import java.awt.*;

class Archer extends Warrior{
    private static String name = "Archer";
    private int range;

    Archer() {
        super();
        this.setColor(Color.gray);
        this.setxPos(rand.nextInt(400));
        this.setyPos(rand.nextInt(400));
        this.setHealth(50);
        this.setRange(10);
        this.setCourage(rand.nextInt(archerMaxCourage-archerMinCourage)+ archerMinCourage);
        this.setAttack(rand.nextInt(archerMaxAttack-archerMinAttack)+archerMinAttack);
        this.setSize(10);
        this.setSpeed(4);
    }

    public String getName() { return Archer.name; }

    @Override
    public void move() {

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
