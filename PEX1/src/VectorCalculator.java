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
    public static void main(java.lang.String[] args) {
        Pattern startTokens = Pattern.compile("exit|<|[0-9]+[.[0-9]+]?|\\||dir|unit");
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
                    parseExpression(cmdLineScanner);
                }
            }
            else{
                System.out.println("Malformed Request");
            }
        }
        System.out.println("Exiting Vector Calc");

    }

    /**
     * parseDirectionExpression() - parses vector expression provided by scanner
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseDirectionExpression(java.util.Scanner s){
        s.hasNext("dir ");
        s.next("dir");
        System.out.println((Vector330Class.parseVector(s)).direction());
    }

    /**
     * parseExpression() - parses vector expression provided by the Scanner s.
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseExpression(java.util.Scanner s){
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
    private static void parseNormalizeExpression(java.util.Scanner s){
        s.hasNext("unit ");
        s.next("unit");
        System.out.println((Vector330Class.parseVector(s)).normalize());
    }

    /**
     * parseNormExpression() - parses expression with a "|" indicated a normalized vector
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseNormExpression(java.util.Scanner s){
        s.hasNext("\\|");
        s.next("\\|");
//        s.hasNext("| ");
//        s.next("|");
        System.out.println((Vector330Class.parseVector(s)).magnitude());
    }

    /**
     * parseScaleExpression() - parses expression with a scalar-vector multiplication
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseScaleExpression(java.util.Scanner s){
        s.hasNextDouble();
        double mult = s.nextDouble();
        s.hasNext("\\*");
        s.next("\\*");
        System.out.println((Vector330Class.parseVector(s)).scale(mult));
    }

    /**
     * parseVectorExpression() -  parses expression with a vector as the next token. Operations: +, -, dot product
     * @param s - Scanner from which input expressions are taken
     */
    private static void parseVectorExpression(java.util.Scanner s){

    }
}

