import java.util.regex.Pattern;

/**
 * Project: Vector Design
 *
 * @author David Thacker
 * Date: 08 Sept 19
 * Class: CS330
 */


public class Vector330Class {
    //Tolerance for equality between two vectors
    private static double TOLERANCE = 0.000000001;
    private double x;
    private double y;

    public Vector330Class() {
        this.x = 0;
        this.y = 0;
    }

    public Vector330Class(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector330Class(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector330Class(long x, long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Direction
     *
     * @return angle of the vector in radians
     */
    public double direction() {
        return Math.atan2(this.y, this.x);
    }

    /**
     * getX
     *
     * @return value of x as a double
     */
    public double getX() {
        return this.x;
    }

    /**
     * getXInt
     *
     * @return value of x as an int
     */
    public int getXInt() {
        return (int) this.x;
    }

    /**
     * getXlong
     *
     * @return value of x as a long
     */
    public long getXlong() {
        return (long) this.x;
    }

    /**
     * getY
     *
     * @return value of y as a double
     */
    public double getY() {
        return this.y;
    }

    /**
     * getYint
     *
     * @return value of y as a int
     */
    public int getYInt() {
        return (int) this.y;
    }

    /**
     * getYlong
     *
     * @return value of y as a long
     */
    public long getYlong() {
        return (long) this.y;
    }

    /**
     * scale - does a scalar vector mult of the vector with double passed in
     *
     * @param s - value to scale the vector by
     * @return the scaled vector
     */
    public Vector330Class scale(double s) {
        return new Vector330Class(this.x * s, this.y * s);
    }

    /**
     * setX
     *
     * @param x - new value of x as a double
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * setY
     *
     * @param y - new value of x as a double
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * setX
     *
     * @param x - new value of x as a int
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setY
     *
     * @param y - new value of y as a int
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * setX
     *
     * @param x - new value of x as a long
     */
    public void setX(long x) {
        this.x = x;
    }

    /**
     * setX
     *
     * @param y - new value of y as a long
     */
    public void setY(long y) {
        this.y = y;
    }

    /**
     * equals - checks for vector equality if the selected vectors have components within the margin of error
     *
     * @param v - the other vector to be compared against
     * @return boolean true if close enough and boolean false if not
     */
    public boolean equals(Vector330Class v) {
        return (v.getX() <= this.x + TOLERANCE && v.getX() >= this.x - TOLERANCE) && (v.getY() <= this.y + TOLERANCE && v.getY() >= this.y - TOLERANCE);
    }

    /**
     * add - does the vector addition of this vector plus the one passed in
     *
     * @param v - the vector to be added
     * @return vector sum of this and the other vector
     */
    public Vector330Class add(Vector330Class v) {
        return new Vector330Class(this.x + v.getX(), this.y + v.getY());
    }

    /**
     * subtract - does the vector subtraction of this vector plus the one passed in
     *
     * @param v - the vector to be subtracted
     * @return vector difference of this and the other vector
     */
    public Vector330Class subtract(Vector330Class v) {
        return new Vector330Class(this.x + (-1 * v.getX()), this.y + (-1 * v.getY()));
    }

    /**
     * dotProduct - does the vector dot product of this vector plus the one passed in
     *
     * @param v - the vector to do the dot product to
     * @return vector scalar of this and the other vector
     */
    public double dotProduct(Vector330Class v) {
        return ((this.x * v.getX()) + (this.y * v.getY()));
    }

    /**
     * magnitude - computes the magnitude of this vector
     *
     * @return magnitude of the vector
     */
    public double magnitude() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    /**
     * normalize - creates a normalized (a vector of length one) in the same direction as the OG one
     *
     * @return the normalized vector
     */
    public Vector330Class normalize() {
        if (this.magnitude() <= TOLERANCE) {
            return new Vector330Class(0, 0);
        } else {
            return new Vector330Class((this.x * (1 / this.magnitude())), this.y * (1 / this.magnitude()));
        }
    }

    /**
     * toString() - override the default toString() method in java to produce an angle bracket version of vector
     *
     * @return string representation of the vector in the form of <x,y>
     */
    public java.lang.String toString() {
        return "< " + this.x + ", " + this.y + " >";
    }

    /**
     * parseVector() - inputs a scanner object which it reads and parses the string representing the vector with the form
     * of < x, y >
     *
     * @param s - the scanner object from which to read the string
     * @return a new Vector330Class object based on the provided input
     */
    public static Vector330Class parseVector(java.util.Scanner s) throws Exception {
        double x;
        double y;
        Pattern ogPattern = s.delimiter();
        s.useDelimiter("[" + ogPattern + ",]");
        if (s.hasNext("<")) {
            s.next("<");
            if (s.hasNextDouble()) {
                x = s.nextDouble();
                s.useDelimiter(ogPattern);
                if (s.hasNext(",")) {
                    s.next(",");
                    if(s.hasNextDouble()){
                        y = s.nextDouble();
                        if (s.hasNext(">")){
                            s.hasNext(">");
                            return new Vector330Class(x, y);
                        }
                        else{
                            throw new Exception("PARSE ERROR: Missing '>' to terminate vector");
                        }
                    }
                    else{
                        throw new Exception("PARSE ERROR: Missing Y coord in vector");
                    }
                } else {
                    throw new Exception("PARSE ERROR: Missing ',' coord in vector");
                }
            } else {
                throw new Exception("PARSE ERROR: Missing X coord in vector");
            }
        } else {
            throw new Exception("PARSE ERROR: Missing '<' in vector");
        }
    }

}
