/**
 * Linerani funkce
 * @author Libor Vasa
 */
class LinearFunction extends AbstractFunction {
    /**
     * Smernice funkce
     */
    double k;
    /**
     * Posun funkce
     */
    double q;

    /**
     * Vytvori novou linearni funkci se zadanymi koeficienty
     *
     * @param k smernice funkce
     * @param q posun funkce
     */
    public LinearFunction(double k, double q) {
        this.k = k;
        this.q = q;
    }

    public double valueAt(double p) { //zde
        return (k * p + q); //zde
    }

    @Override
    public double differentiate(double x){
        return k;
    }
}