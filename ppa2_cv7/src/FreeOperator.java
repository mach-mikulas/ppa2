/**
 * Operator odpovidajici na IncomingCall
 * @author Mikulas Mach
 */
class FreeOperator{
    /** Jmeno operatora */
    public String name;
    /** Cas jak dlouho od zacatku smeny ceka operator na hovor */
    public int time;

    public FreeOperator(String name, int time){
        this.name = name;
        this.time = time;
    }
}