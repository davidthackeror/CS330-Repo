import java.awt.*;

/**
 * represents a ball to be drawn and moved about a Graphics2D object
 *
 * @author Steve Hadfield
 * @date   9/3/2018
 */
public class Ball {

    // static attributes

    private static int windowWidth = 400;
    private static int windowHeight = 300;
    private static Graphics2D g = null;

    // instance attributes

    private double x;
    private double y;
    private int radius;
    private java.awt.Color color;
    private double delX;
    private double delY;

    // constructors

    /**
     * creates a new Ball object in the middle of the default window size
     */
    public Ball() {
        this.x = Ball.windowWidth / 2;
        this.y = Ball.windowHeight / 2;
        this.radius = 10;
        this.color = java.awt.Color.BLUE;
        this.delX = 3;
        this.delY = 2;
    }

    /**
     * creates a new Ball object at the given (x, y) position
     * @param x horizonal x position
     * @param y vertical y position
     */
    public Ball( double x, double y ) {
        this.x = x;
        this.y = y;
        this.radius = 10;
        this.color = Color.BLUE;
        this.delX = (10*Math.random()) - 5; // range [-5,5)
        this.delY = (10*Math.random()) - 5;
    }

    // static setter / getter methods

    public static void setWindowWidth( int width ) { Ball.windowWidth = width; }
    public static void setWindowHeight( int height ) { Ball.windowHeight = height; }
    public static void setGraphics2D( Graphics2D g ) { Ball.g = g; }

    public static int getWindowWidth() { return Ball.windowWidth; }
    public static int getWindowHeight() { return Ball.windowHeight; }
    public static Graphics2D getGraphics2D() { return Ball.g; }

    // instance getter methods

    public int getX() { return (int) this.x; }
    public int getY() { return (int) this.y; }
    public boolean infected() { return (this.color == Color.RED); }  // boolean zen

    // instance setter methods

    public void infect() { this.color = Color.RED; }

    // public instance behaviors

    /**
     * draws the ball at its current location on the static Graphics2D attribute
     */
    public void draw() {
        if (Ball.g != null) {
            Ball.g.setColor( this.color );
            Ball.g.fillOval( (this.getX() - this.radius), (this.getY() - this.radius),
                             (2 * this.radius), (2 * this.radius) );
        }
    }  // end of draw() method

    /**
     * moves the ball from its current position with its current velocity.  If it gets within radius of the
     *  window boundary, the appropriate component(s) of its velocity are reversed.
     */
    public void move() {

        this.x += this.delX;
        if ( (this.x > Ball.windowWidth) || (this.x < 0) ) {
            this.delX *= -1;  // reverse x direction
        }

        this.y += this.delY;
        if ( (this.y > Ball.windowHeight) || (this.y < 0) ) {
            this.delY *= -1;  // reverse y direction
        }

    }  // end of move() method

    /**
     * if the distance between this Ball's center point and the other Ball's center point is less than or
     *  equal to the sum of their radii, then the balls are in contact
     * @param other other Ball object
     * @return true/false if this Ball and the other Ball are in contact
     */
    public boolean contact( Ball other ) {
        return (Math.sqrt( Math.pow((this.x-other.x),2) + Math.pow((this.y-other.y),2) ) <= (this.radius+other.radius));
    }

}  // end of Ball class
