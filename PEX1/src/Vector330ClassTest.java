import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project: Vector Design
 * @author David Thacker
 * Date: 08 Sept 19
 * Class: CS330
 */
public class Vector330ClassTest {
    private final double EPS = 1.0E-9;
    Vector330Class a;
    Vector330Class b;

    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        Vector330Class a = new Vector330Class(3,4);
        Vector330Class b = new Vector330Class(5,6);
    }
    @org.junit.jupiter.api.AfterEach
    void tearDown(){
        a = null;
        b = null;
    }

    @org.junit.jupiter.api.Test
    void direction() {
        double check = a.direction();
        assert(check <= .92730 + EPS && check >= .92730 - EPS);
    }

    @Test
    void getX() {
    }

    @Test
    void getXInt() {
    }

    @Test
    void getXlong() {
    }

    @Test
    void getY() {
    }

    @Test
    void getYInt() {
    }

    @Test
    void getYlong() {
    }

    @Test
    void scale() {
    }

    @Test
    void setX() {
    }

    @Test
    void setY() {
    }

    @Test
    void testSetX() {
    }

    @Test
    void testSetY() {
    }

    @Test
    void testSetX1() {
    }

    @Test
    void testSetY1() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void add() {
        Vector330Class c = a.add(b);
        assertEquals(c.getX(), 8, EPS);
        assertEquals(c.getY(), 10, EPS);
    }

    @Test
    void subtract() {
        Vector330Class c = a.subtract(b);
        assertEquals(c.getX(), -2, EPS);
        assertEquals(c.getY(), -2, EPS);
    }

    @Test
    void dotProduct() {
        double res = a.dotProduct(b);
        assertEquals(res, 39, EPS);
    }

    @Test
    void magnitude() {
        double res = a.magnitude();
        assertEquals(res, 5, EPS);
    }

    @Test
    void normalize() {
        Vector330Class c = a.normalize();
        assertEquals(c.getX(), 8, EPS);
        assertEquals(c.getY(), 10, EPS);
    }

    @Test
    void testToString() {
        assertEquals(a.toString(), "< 3, 4 >");
    }

    @Test
    void parseVector() {
        Scanner S = new Scanner("< 5.2,  3.1 >");
        Vector330Class res = Vector330Class.parseVector(S);
        assertEquals(res.getX(), 5.2, EPS);
        assertEquals(res.getY(), 3.1, EPS);
    }
}
