/**
 * RationalNumber provides a very basic class for rational numbers
 *
 * @author Steven.Hadfield
 */
public class RationalNumber {

    // attributes

    private int numerator;
    private int denominator;

    // constructors

    /**
     * zero-argument constructor, sets new rational number to 0/1
     */
    public RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * single augument constructor, set new rational number to number / 1
     *
     * @param number integer equivalent of the new rational number
     */
    public RationalNumber( int number ) {
        this.numerator = number;
        this.denominator = 1;
    }

    /**
     * two argument constructor, sets new rational number to numerator / denominator
     *
     * @param numerator - numerator of the new rational number
     * @param denominator - denominator of the new rational number
     */
    public RationalNumber( int numerator, int denominator ) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new ArithmeticException("Cannot set RationalNumber denominator to zero");
        } else {
            this.denominator = denominator;
        }
    }

    // setter (mutator) methods

    /**
     * sets the numerator to the value of the numerator parameter
     *
     * @param numerator - new numerator for the rational number
     */
    public void setNumerator( int numerator ) {
        this.numerator = numerator;
    }

    /**
     * set the denominator to the value of the denominator parameter, unless the new denominator is zero
     * in which case an exception is raised
     *
     * @param denominator
     */
    public void setDenominator( int denominator ) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot set RationalNumber denominator to zero");
        } else {
            this.denominator = denominator;
        }
    }

    // getter (accessor) methods

    /**
     * returns the integer value of the numerator
     *
     * @return - value of the rational number's numerator
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * returns the integer value of the denominator
     *
     * @return - value of the rational number's denominator
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * returns a double (floating point format) version of the rational number
     *
     * @return - double version of the rational number's value
     */
    public double getDouble() {
        return (double) this.getNumerator() / (double) this.getDenominator();
    }

    // arithmetic operations

    /**
     * add - adds the current (this) rational number to the other rational number passed in
     *
     * @param other - other rational number to add to the current one
     * @return returns a new RationalNumber object containing the sum of this and other
     */
    public RationalNumber add( RationalNumber other ) {
        return new RationalNumber(
                ( (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator()) ),
                ( this.getDenominator() * other.getDenominator() ) );
    }

    /**
     * subtract - subtracts the value in other to the current rational number
     *
     * @param other - the rational number to subtract from the current (this) rational number
     * @return returns a new RationalNumber object containing the difference of this minus other
     */
    public RationalNumber subtract( RationalNumber other ) {
        return new RationalNumber(
                ( (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * this.getDenominator()) ),
                ( this.getDenominator() * other.getDenominator() ) );
    }

    /**
     * multiply - multiplies the current rational number (this) times the other rational number
     *
     * @param other - rational number to multiply by the current one
     * @return returns a new RationalNumber with the product of this and other
     */
    public RationalNumber multiply( RationalNumber other ) {
        return new RationalNumber(
                (this.getNumerator() * other.getNumerator() ),
                (this.getDenominator() * other.getDenominator()) );
    }

    /**
     * divide - divides this rational number by the other rational number, raising an arithmetic exception if
     *      a zero denominator results
     *
     * @param other - the divisor rational number
     * @return returns a new RationalNumber with this divided by other
     */
    public RationalNumber divide( RationalNumber other ) {
        return new RationalNumber(
                (this.getNumerator() * other.getDenominator() ),
                (this.getDenominator() * other.getNumerator()) );
    }

    // utility method(s) overwritten from Object class

    /**
     * toString() overrides the default toString() from the Object class
     * @return string with the value of the denominator / numerator (ex: 3/5)
     */
    public String toString() {
        return new String( "" + this.getNumerator() + "/" + this.getDenominator() );
    }

}
