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
    Vector330Class a = new Vector330Class(3,4);
    Vector330Class b = new Vector330Class(5,6);

    @org.junit.jupiter.api.Test
    void direction() {
        double check = a.direction();
        assertEquals(check, 0.9272952180016122, EPS);
    }

    @Test
    void getX() {
        assertEquals(a.getX(), 3, EPS);
    }

    @Test
    void getXInt() {
        assertEquals(a.getX(), 3, EPS);
    }

    @Test
    void getXlong() {
        assertEquals(a.getX(), 3, EPS);
    }

    @Test
    void getY() {
        assertEquals(a.getX(), 3, EPS);
    }

    @Test
    void getYInt() {
        assertEquals(a.getX(), 3, EPS);
    }

    @Test
    void getYlong() {
        assertEquals(a.getX(), 3, EPS);
    }

    @Test
    void scale() {
        Vector330Class c = a.scale(3);
        assertEquals(c.getX(), 9, EPS);
        assertEquals(c.getY(), 12, EPS);

    }

    @Test
    void testEquals() {
        Vector330Class c = new Vector330Class(a.getX(), a.getY());
        assert(c.equals(a));
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
        assertEquals(c.getX(), 0.6000000000000001, EPS);
        assertEquals(c.getY(), 0.8, EPS);
    }

    @Test
    void testToString() {
        assertEquals(a.toString(), "< 3.0, 4.0 >");
    }

    @Test
    void parseVector() throws Exception {
        Scanner S = new Scanner("< 5.2,  3.1 >");
        Vector330Class res = Vector330Class.parseVector(S);
        assertEquals(res.getX(), 5.2, EPS);
        assertEquals(res.getY(), 3.1, EPS);
    }

    @Test
    void testSetX() {
        a.setX(5);
        assertEquals(a.getX(),5, EPS);
    }

    @Test
    void testSetY() {
        a.setY(5);
        assertEquals(a.getY(),5, EPS);
    }

}
