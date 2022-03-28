/**
 * Trida pro numericky vypocet urciteho integralu funkce
 * @author Libor Vasa
 */
class Integrator {
    /** Krok pro vypocet integralu */
    double delta;

    /**
     * Numbericky vypocte a vrati urcity integral zadane fukce
     * @param f funkce, jejiz integral se ma vypocitat
     * @param a pocatek intervalu integrace
     * @param b konec intervalu integrace
     * @return urcity integral zadane funkce
     */
    public double integrate(IFunction f, double a, double b) {
        double result = 0;
        double p = a;
        double v = f.valueAt(p);
        while (p + delta < b) {
            //obdelniky sirky delta
            result += delta * v;
            p += delta;
            v = f.valueAt(p);
        }
        // jeste posledni obdelnik, ktery bude uzsi nez delta
        result += (b - p) * v; //zde
        return result;
    }

    /**
     * Nastavi krok pro vypocet integralu
     * @param d krok pro vypocet integralu
     */
    public void setDelta(double d) {
        this.delta = d;
    }

}