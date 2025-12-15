/**
 *  Numerical Analysis. Exercise 01.
 */

public class compPrec {

    /** Radix used by floating-point numbers    */
    static private int fRadix = 2;

    /** Largest positive value which, when subtracted to 1.0, yields 0.0   */
    static private double negativeMachinePrecision = 0;

    /** Largest possible number   */
    static private double largestNumber = 0;

    /** Smallest number different from zero     */
    //    static private double smallestNumber = 0;


    public static double getNegativeMachinePrecision() {
        double epsilon =  1.0;

        while ((1.0 - epsilon) != 1.0){
            epsilon = epsilon / 2.0;
        }

        negativeMachinePrecision = epsilon;

	    return negativeMachinePrecision;
    }


    public static double getLargestNumber() {
        double max = 1.0;
        double recognizableEps= negativeMachinePrecision * fRadix; 
        
        //maxでfを定義
        max = 1.0 - recognizableEps;

        while(!Double.isInfinite(max * fRadix)){
            max = max * fRadix;
        }
        largestNumber = max;

	    return largestNumber;
    }


    public static void printParameters() {

	System.out.println( "Floating-point machine parameters");
	System.out.println( "---------------------------------");
	System.out.println( " ");
	System.out.println( "Negative machine precision = "
			    + getNegativeMachinePrecision());
	System.out.println( "Largest number = "+ getLargestNumber());
	//	System.out.println( "Smallest number = "+ getSmallestNumber());
	return;
    }


    public static void main(String[] args) {

	compPrec cp = new compPrec();

	cp.printParameters();

    }

}