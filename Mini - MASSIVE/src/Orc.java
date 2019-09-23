class Orc extends Warrior{
    private static String name = "Orc";

    Orc(int minHealth, int maxHealth, int minSpeed, int maxSpeed, int minCourage, int maxCourage, int size, int minAttack, int maxAttack){
        super();
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
    public void move() {

    }

}
