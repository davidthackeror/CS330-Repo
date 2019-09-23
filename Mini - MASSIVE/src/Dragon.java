class Dragon extends Warrior{
    private static String name = "Dragon";

    private int luckyArrow = 0;

    Dragon(){
        super();
        this.setxPos(rand.nextInt(400)+600);
        this.setyPos(rand.nextInt(400)+600);
        this.setHealth(500);
        this.setRange(9);
        this.setCourage(100);
        this.setAttack(100);
        this.setSize(75);
        this.setSpeed(6);
    }


    public int getLuckyArrow() {
        return luckyArrow;
    }

    public void setLuckyArrow(int luckyArrow) {
        this.luckyArrow = luckyArrow;
    }

    public String getName() { return Dragon.name; }

    @Override
    public void move() {

    }

}
