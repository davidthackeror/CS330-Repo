import java.util.Scanner;

/**
 * Project: Vector Design
 * @author David Thacker
 * Date: 08 Sept 19
 * Class: CS330
 */

public class VectorCalculator {

    /**
     * main() - reads and processes inputs until exit is entered
     * @param args - unused
     */
    public static void main(java.lang.String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner
        System.out.println("Enter vector");
        Vector330Class newVector = Vector330Class.parseVector(myObj);
        System.out.println(newVector.getX());
        System.out.println(newVector.getY());

    }

    /**
     * parseDirectionExpression() - parses vector expression provided by scanner
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseDirectionExpression(java.util.Scanner s){

    }

    /**
     * parseExpression() - parses vector expression provided by the Scanner s.
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseExpression(java.util.Scanner s){

    }

    /**
     * parseNormalizeExpression() - parses expression to compute a normalized vector; that is, a vector with same direction as input but with magnitude of 1
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseNormalizeExpression(java.util.Scanner s){

    }

    /**
     * parseNormExpression() - parses expression with a "|" indicated a normalized vector
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseNormExpression(java.util.Scanner s){

    }

    /**
     * parseScaleExpression() - parses expression with a scalar-vector multiplication
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseScaleExpression(java.util.Scanner s){

    }

    /**
     * parseVectorExpression() -  parses expression with a vector as the next token. Operations: +, -, dot product
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseVectorExpression(java.util.Scanner s){

    }
}

