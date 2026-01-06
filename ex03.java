/**
 * Numerical Analysis. Exercise 03.
 */
public class ex03 {

    static double errorTolerance = 1e-7;

    public static void main(String[] args) {

        System.out.println();
        System.out.println("f(x) = x^3 -3*x^2 + 2*x - 0.2 = 0");

        new Bisection().solve();
        new Newton().solve();

    }

    static double f(double x) { 
        return x*x*x - 3*x*x + 2*x - 0.2; 
    }
    
    static double fprime(double x) { 
        return 3*x*x - 6*x + 2; 
    }
}

class Bisection {

    void solve() {

        System.out.println();
        System.out.println("Bisection method");

        double xNeg = 1.5;
        double xPos = 3.0;
        double x = 0.0;
        int iteration = 0;

        while (Math.abs(xPos - xNeg) > ex03.errorTolerance) {
            iteration++;
            
            x = (xPos + xNeg) / 2.0;

            if (ex03.f(x) > 0) {
                xPos = x;
            } else {
                xNeg = x;
            }

            System.out.printf("Iteration %d x= %.7f%n", iteration, x);
        }
    }

}

class Newton {

    void solve() {

        System.out.println();
        System.out.println("Newton's method");

        double x0 = 3.0;
        double x1 = 0.0;
        int iteration = 0;
        double diff = ex03.errorTolerance + 1.0; 

        while (diff > ex03.errorTolerance) {
            iteration++;
            
            x1 = x0 - ex03.f(x0) / ex03.fprime(x0);
            
            System.out.printf("Iteration %d x= %.7f%n", iteration, x1);
            
            diff = Math.abs(x1 - x0);
            x0 = x1;
        }
    }

}