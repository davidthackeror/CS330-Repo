import java.util.Random;
/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */

public class Warrior {

    Random rand = new Random();
    int archerMinCourage = 10;
    int archerMaxCourage = 30;
    int archerMinAttack = 30;
    int archerMaxAttack = 50;
    int knightMinCourage = 45;
    int knightMaxCourage = 75;
    int knightMinAttack = 40;
    int knightMaxAttack = 60;
    int knightMinHealth = 100;
    int knightMaxHealth = 150;

    private int range;
    private int xPos;
    private int yPos;
    private int health;
    private int attack;
    private int courage;
    private int speed;
    private int size;

    Warrior() {
        this.xPos = 0;
        this.yPos = 0;
        this.health = 0;
        this.attack = 0;
        this.courage = 0;
        this.speed = 0;
        this.size = 0;
    }

    public Warrior(int xPos, int yPos, int health, int attack, int courage, int speed, int size){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.attack = attack;
        this.courage = courage;
        this.speed = speed;
        this.size = size;
    }
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getRange() {
        return this.range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}

class Archer extends Warrior{
    private int range;
    Archer() {
        super();
        this.setHealth(50);
        this.setRange(10);
        this.setCourage(rand.nextInt(archerMaxCourage-archerMinCourage)+ archerMinCourage);
        this.setAttack(rand.nextInt(archerMaxAttack-archerMinAttack)+archerMinAttack);
        this.setSize(10);
        this.setSpeed(4);
    }

}

class Orc extends Warrior{
    Orc(int minHealth, int maxHealth, int minSpeed, int maxSpeed, int minCourage, int maxCourage, int size, int minAttack, int maxAttack){
        super();
        this.setRange(1);
        this.setAttack(rand.nextInt(maxAttack-minAttack)+minAttack);
        this.setSpeed(rand.nextInt(maxSpeed-minSpeed)+minSpeed);
        this.setCourage(rand.nextInt(maxCourage-minCourage)+minCourage);
        this.setHealth(rand.nextInt(maxHealth-minHealth)+minHealth);
        this.setSize(size);
    }
}

class Ogre extends Orc{

    Ogre(int minHealth, int maxHealth, int minSpeed, int maxSpeed, int minCourage, int maxCourage, int size, int minAttack, int maxAttack) {
        super(minHealth*2, maxHealth*2, minSpeed/2, maxSpeed/2, minCourage, maxCourage*2, size*2, minAttack*2, maxAttack*2);
    }
}

class Knight extends Warrior{
    Knight(){
        super();
        this.setRange(1);
        this.setHealth(rand.nextInt(knightMaxHealth-knightMinHealth)+knightMinHealth);
        this.setCourage(rand.nextInt(knightMaxCourage-knightMinCourage)+ knightMinCourage);
        this.setAttack(rand.nextInt(knightMaxAttack-knightMinAttack)+knightMinAttack);
        this.setSize(15);
        this.setSpeed(2);
    }
}

class Dragon extends Warrior{
    private int luckyArrow = 0;

    Dragon(){
        super();
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
}

