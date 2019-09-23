import java.awt.*;

class Knight extends Warrior{
    private static String name = "Knight";

    Knight(){
        super();
        this.setColor(Color.yellow);
        this.setxPos(rand.nextInt(400));
        this.setyPos(rand.nextInt(400));
        this.setRange(1);
        this.setHealth(rand.nextInt(knightMaxHealth-knightMinHealth)+knightMinHealth);
        this.setCourage(rand.nextInt(knightMaxCourage-knightMinCourage)+ knightMinCourage);
        this.setAttack(rand.nextInt(knightMaxAttack-knightMinAttack)+knightMinAttack);
        this.setSize(15);
        this.setSpeed(2);
    }

    public String getName() { return Knight.name; }

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
