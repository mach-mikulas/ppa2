public class Derivative extends AbstractFunction{

    IFunction funkce;

    public Derivative(IFunction funkce){
        this.funkce = funkce;
    }

    public double valueAt(double p){
        return funkce.differentiate(p);
    }

}
