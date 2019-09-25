/**
 * UseRationalNumber - creates and performs operations with RationalNumber objects
 *
 * @author Steven.Hadfield
 */
public class UseRationalNumber {

    /**
     * main() creates some initial Rational Number objects, does operations with them, reports results
     *
     * @param args command line arguments are not used
     */
    public static void main(String[] args) {

        try {

            // create some RationalNumber objects (instances)

            RationalNumber a = new RationalNumber();    // 0/1
            RationalNumber b = new RationalNumber(2);   // 2/1
            RationalNumber c = new RationalNumber(3, 5);  // 3/5
            RationalNumber d = new RationalNumber(4, 7);  // 4/7
            RationalNumber e = new RationalNumber(5, 0 ); // should throw an exception

            // report the initial values

            System.out.println();
            System.out.println("a is " + a);  // this will implicitly call the toString() method
            System.out.println("b is " + b);
            System.out.println("c is " + c);
            System.out.println("d is " + d);

            // try some calculations

            RationalNumber resultDefaultAdd = a.add(b);
            RationalNumber resultAdd = b.add(c);
            RationalNumber resultSubtract = b.subtract(d);
            RationalNumber resultMultiply = c.multiply(d);
            RationalNumber resultDivide = c.divide(d);
            RationalNumber resultBadDivide = c.divide(a);  // should result in a divide-by-zero error

            // report the results of the calculations

            System.out.println();
            System.out.println("Result: a + b is " + resultDefaultAdd);
            System.out.println("Result: b + c is " + resultAdd);
            System.out.println("Result: b - d is " + resultSubtract);
            System.out.println("Result: c * d is " + resultMultiply);
            System.out.println("Result: c / d is " + resultDivide);

        } catch (Exception e) {
            System.out.println("\nException Occurred:  " + e.getMessage());
        }

    }
}
