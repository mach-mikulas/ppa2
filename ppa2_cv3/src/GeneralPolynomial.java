public class GeneralPolynomial extends AbstractFunction{

    double[] coefs;

    public GeneralPolynomial(double[] coefs){
        this.coefs = coefs;
    }

    public double valueAt(double p){

        int stupen = coefs.length;
        double result = 0;
        double mocnina = 1;

        for(int i = stupen - 1; i >= 0; i--){
            result += mocnina * coefs[i];
            mocnina *= p;
        }

        return result;
    }
}
