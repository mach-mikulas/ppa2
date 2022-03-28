/**
 * Hlavni trida programu pro numericky vypocet urciteho integralu
 * @author Libor Vasa
 */
public class Exercise03 {
    public static void main(String[] args) {
        /*
        LinearFunction lf = new LinearFunction(0, 1);
        QuadraticPolynomial qp = new QuadraticPolynomial(1, 1,1);
        Integrator integrator = new Integrator();
        integrator.setDelta(0.001);
        //double integral = integrator.integrate(lf, 0, 10);
        double integral = integrator.integrate(qp, 0, 10);
        System.out.println(integral);
        System.out.println(qp.differentiate(2));
        System.out.println(qp.differentiate(2));

         */

        IFunction myPolynomial = new GeneralPolynomial(new double[] {7,-5,3,-15});
        IFunction firstDerivative = new Derivative(myPolynomial);
        IFunction secondDerivative = new Derivative(firstDerivative);
        IFunction thirdDerivative = new Derivative(secondDerivative);

        for (double x = 0;x<10.1;x+=0.2) {
            System.out.println(thirdDerivative.valueAt(x));
        }

        System.out.println();

        IFunction sin = new Sine();
        IFunction cos = new Derivative(sin);
        System.out.println("Cosinus");
        for (double x = 0;x<Math.PI*2;x+=0.3) {
            System.out.println(cos.valueAt(x));
        }

    }
}

