abstract class AbstractFunction implements IFunction {

    public double h = 0.01;
    public double def_h = h;
    private double epsilon = 0.01;

    abstract public double valueAt(double p);

    public void setEpsilon(double e){
        this.epsilon = e;
    }

    public double differentiate(double x) {
        double derivace1 = ((valueAt(x + h) - valueAt(x)) / h);
        double derivace2 = ((valueAt(x + (h / 2)) - valueAt(x)) / (h/2));
        if (Math.abs(derivace1 - derivace2) > epsilon) {
            this.h = h / 2;
            differentiate(x);
        }
        else{
            h = def_h;
        }
        return derivace2;
    }

}
