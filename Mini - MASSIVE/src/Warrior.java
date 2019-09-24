import java.awt.*;
import java.util.Random;
/**
 * Project: Mini - MASSIVE
 * @author David Thacker
 * Date: 22 Sept 19
 * Class: CS330
 */

public abstract class Warrior {

    Random rand = new Random();
    int archerMinCourage = 10;
    int archerMaxCourage = 30;
    int archerMinAttack = 10;
    int archerMaxAttack = 20;
    int knightMinCourage = 45;
    int knightMaxCourage = 75;
    int knightMinAttack = 40;
    int knightMaxAttack = 60;
    int knightMinHealth = 100;
    int knightMaxHealth = 150;

    private int range;
    private boolean isMoving;
    private boolean isAlive;
    private int xPos;
    private int yPos;
    private int health;
    private int attack;
    private int courage;
    private int speed;
    private int size;
    private Color color;

    Warrior() {
        this.xPos = 0;
        this.yPos = 0;
        this.health = 0;
        this.attack = 0;
        this.courage = 0;
        this.speed = 0;
        this.size = 0;
        this.color = color;
        this.isMoving = true;
        this.isAlive = true;
    }

    public Warrior(int xPos, int yPos, int health, int attack, int courage, int speed, int size, Color color, boolean isMoving, boolean isAlive){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.attack = attack;
        this.courage = courage;
        this.speed = speed;
        this.size = size;
        this.color = color;
        this.isMoving = isMoving;
        this.isAlive = isAlive;

    }

    //getter and setter methods
    public abstract String getName();

    public abstract void move(int xTarget, int yTarget);


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

    public abstract void draw(Graphics2D g);

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}

