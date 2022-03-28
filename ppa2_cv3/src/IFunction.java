/**
 * Obecna matematicka funkce
 * @author Libor Vasa
 */
interface IFunction {
    /**
     * Vypocte a vrati hodnotu funkce v zadanem bode
     * @param p bod, ve kterem ma byt urcena hodnota funkce
     * @return hodnotu funkce v zadanem bode 
     */
    double valueAt(double p);

    /**
     * Vrati derivaci v urcitem bode
     * @param x bod, ve kterem ma byt urcena derivace
     * @return hodnotu derivace v bode x
     */
    double differentiate(double x);
}