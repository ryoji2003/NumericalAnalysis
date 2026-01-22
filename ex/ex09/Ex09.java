/**
 * Numerical Analysis. Exercise 09
 * ODE: Solve dy/dx = xy using Euler and RK4 methods.
 */
public class Ex09 {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("dy/dx = xy, a=0, b=1, y(a) = 1");
        System.out.println();

        Ex09 e = new Ex09();
        e.Euler(0.1);
        e.RungeKutta(0.1);
        e.Euler(0.01);
        e.RungeKutta(0.01);
    }

    static double f(double x, double y) { return x*y; }

    static double a = 0, b = 1, ya = 1;
    
    // y = exp(0.5 * x^2)
    static double theoretical(double x) {
        return Math.exp(0.5 * x * x);
    }

    void Euler(double h) {
        double x = a;
        double y = ya;
        
        // (b - a) の区間の長さをhで割り、計算回数（ステップ数）を決定。
        int steps = (int) Math.round((b - a) / h);

        for (int i = 0; i < steps; i++) {
            // y_(n+1) = y_n + h * f(x_n, y_n)
            y = y + h * f(x, y);
            x = x + h;
        }

        printResult("Euler:     ", h, x, y);
    }

    void RungeKutta(double h) {
        double x = a;
        double y = ya;

        // (b - a) の区間の長さをhで割り、計算回数（ステップ数）を決定。
        int steps = (int) Math.round((b - a) / h);

        for (int i = 0; i < steps; i++) {
            double k1 = h * f(x, y);
            double k2 = h * f(x + h / 2.0, y + k1 / 2.0);
            double k3 = h * f(x + h / 2.0, y + k2 / 2.0);
            double k4 = h * f(x + h, y + k3);

            // y_(n+1) = y_n + 1/6 (k_1 + 2k_2 + 2k_3 + k_4)
            y = y + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
            x = x + h;
        }

        printResult("Runge-Kutta:", h, x, y);
    }

    void printResult(String method, double h, double x, double y) {
        double exact = theoretical(x);
        double error = y - exact;

        System.out.printf("%s h=%.3f\tx=%.3f\ty=%.8f\tError=%.4e%n", 
                          method, h, x, y, error);
    }
}