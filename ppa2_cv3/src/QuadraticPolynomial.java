public class QuadraticPolynomial extends AbstractFunction{
    double a;
    double b;
    double c;

    public QuadraticPolynomial(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double valueAt(double p){
        return (a*(p*p) + b*p + c);
    }
}
