import java.util.Scanner;
import java.util.regex.Pattern;

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
    public static void main(java.lang.String[] args) throws Exception {
        Pattern startTokens = Pattern.compile("exit|<|\\d|\\||dir|unit");
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner
//        Vector330Class newVector = Vector330Class.parseVector(myObj);
//        System.out.println(newVector.getX());
//        System.out.println(newVector.getY());
//        System.out.println(newVector.magnitude());
        boolean done = false;
//        myObj.close();
        Scanner cmdScanner = new Scanner(System.in);
        while(!done){
            System.out.println("Enter vector");
            String cmdString = cmdScanner.nextLine();
            Scanner cmdLineScanner = new Scanner(cmdString);

            if(cmdLineScanner.hasNext(startTokens)){
                if (cmdLineScanner.hasNext("exit")){
                    done = true;
                }
                else{
                    try{
                        parseExpression(cmdLineScanner);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            else{
                System.out.println("Something went wrong, you probably have a malformed string, try again.");
            }
        }
        System.out.println("Exiting Vector Calc.");

    }

    /**
     * parseDirectionExpression() - parses vector expression provided by scanner
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseDirectionExpression(java.util.Scanner s) throws Exception {
        s.hasNext("dir ");
        s.next("dir");
        double radians = (Vector330Class.parseVector(s)).direction();
        System.out.println("Result is " + radians + " radians (" + Math.toDegrees(radians) + " degrees)");
    }

    /**
     * parseExpression() - parses vector expression provided by the Scanner s.
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseExpression(java.util.Scanner s) throws Exception {
        if(s.hasNext("\\|")){
            parseNormExpression(s);
        }
        else if(s.hasNext("dir")){
            parseDirectionExpression(s);
        }
        else if(s.hasNext("unit")){
            parseNormalizeExpression(s);
        }
        else if(s.hasNext("\\d")){
            parseScaleExpression(s);
        }
        else{
            parseVectorExpression(s);
        }
    }

    /**
     * parseNormalizeExpression() - parses expression to compute a normalized vector; that is, a vector with same direction as input but with magnitude of 1
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseNormalizeExpression(java.util.Scanner s) throws Exception {
        s.hasNext("unit ");
        s.next("unit");
        System.out.println("Result is " + (Vector330Class.parseVector(s)).normalize());
    }

    /**
     * parseNormExpression() - parses expression with a "|" indicated a normalized vector
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseNormExpression(java.util.Scanner s) throws Exception {
        s.hasNext("\\|");
        s.next("\\|");
//        s.hasNext("| ");
//        s.next("|");
        System.out.println("Result is " + (Vector330Class.parseVector(s)).magnitude());
    }

    /**
     * parseScaleExpression() - parses expression with a scalar-vector multiplication
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseScaleExpression(java.util.Scanner s) throws Exception {
        s.hasNextDouble();
        double mult = s.nextDouble();
        s.hasNext("\\*");
        s.next("\\*");
        System.out.println("Result is " + (Vector330Class.parseVector(s)).scale(mult));
    }

    /**
     * parseVectorExpression() -  parses expression with a vector as the next token. Operations: +, -, dot product
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseVectorExpression(Scanner s) throws Exception {
        Vector330Class firstVector = Vector330Class.parseVector(s);
        s.next(">");
        if(s.hasNext("[+-.]")){
            String operator = s.next("[+-.]");
            Vector330Class secondVector = Vector330Class.parseVector(s);
            if(operator.equals("+")){
                Vector330Class resultVector = firstVector.add(secondVector);
                System.out.println("Resultant Vector: < " + resultVector.getX() + ", " + resultVector.getY() + " >");
            }
            if(operator.equals("-")){
                Vector330Class resultVector = firstVector.subtract(secondVector);
                System.out.println("Resultant Vector: < " + resultVector.getX() + ", " + resultVector.getY() + " >");
            }
            if(operator.equals(".")){
                System.out.println("Result: " + firstVector.dotProduct(secondVector));
            }
        }
        else{
            throw new Exception("PARSE ERROR: Missing or incorrect operation identifier.");
        }

    }
}

