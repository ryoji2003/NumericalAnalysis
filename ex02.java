/**
 *  Numerical Analysis. Exercise 02.
 */
public class ex02 {
    public static void main(String[] args) {
	new QuadEquation().evaluate();
    System.out.println();
	new Cancellation().evaluate();
    }
}

class QuadEquation {
    void evaluate() {
        System.out.println("Task 1. Quadratic equation ax^2+bx+c=0");
        System.out.println("-------------------------------");

        float a_f = 1.0f, b_f = -8000.0f, c_f = 1.0f;
        double a_d = 1.0, b_d = -8000.0, c_d = 1.0;

        System.out.println("a = " + a_d + "  b = " + b_d + "  c = " + c_d);

        // single precision
        float det_f = (float)Math.sqrt(b_f * b_f - 4.0f * a_f * c_f);
        float x1_f = (-b_f + det_f) / (2.0f * a_f);
        float x2_f = (-b_f - det_f) / (2.0f * a_f);
        System.out.println("Single precision x1 = " + x1_f + "  x2 = " + x2_f);

        // double precision
        double det_d = Math.sqrt(b_d * b_d - 4.0 * a_d * c_d);
        double x1_d = (-b_d + det_d) / (2.0 * a_d);
        double x2_d = (-b_d - det_d) / (2.0 * a_d);
        System.out.println("Double precision x1 = " + x1_d + "  x2 = " + x2_d);

        // to improve precision of the result for single precision
        float x2_f_improved = c_f / (a_f * x1_f);
        System.out.println("Improved single precision x2 = " + x2_f_improved);
    }
}

class Cancellation {
    void evaluate(){
        System.out.println("Task 2. Cancellation");
        System.out.println("------------");

        // (a) ln(x+1) - ln(x) for x >> 1
        double x_a = 1.0e12;
        double val_a_bad = Math.log(x_a + 1.0) - Math.log(x_a);

        // In(1 + 1/x)
        double val_a_good = Math.log(1.0 + 1.0 / x_a);

        System.out.println("ln(x+1)-ln(x),     x = " + x_a + " : " + val_a_bad);
        System.out.println("  Improved: " + val_a_good);
        System.out.println();

        // (b) sqrt(x^2+1) - x for x >> 1
        double x_b = 1.0e9;
        double val_b_bad = Math.sqrt(x_b * x_b + 1.0) - x_b;
        
        // 1 / (sqrt(x^2+1) + x)
        double val_b_good = 1.0 / (Math.sqrt(x_b * x_b + 1.0) + x_b);

        System.out.println("sqrt(x^2+1)-x,     x = " + x_b + " : " + val_b_bad);
        System.out.println("  Improved: " + val_b_good);
        System.out.println();

        // (c) cos^2(x) - sin^2(x) for x ~ PI/4
        double deg_c = 44.999999999999;
        double rad_c = Math.toRadians(deg_c);
        
        double val_c_bad = Math.pow(Math.cos(rad_c), 2) - Math.pow(Math.sin(rad_c), 2);
        
        // cos(2x)
        double val_c_good = Math.cos(2.0 * rad_c);

        System.out.println("cos^2(x)-sin^2(x),     x = " + deg_c + " : " + val_c_bad);
        System.out.println("  Improved: " + val_c_good);
    }
}
       