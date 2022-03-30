/**
 * Fronta prichozich hovoru
 * @author Libor Vasa
 */
class CallerQueue {
    /** Prvni prvek fronty */
    private Link first;
    /** Posledni prvek fronty */
    private Link last;

    /**
     * Prida prichozi hovor na konec fronty
     * @param call prichozi hovor
     */
    public void add(IncomingCall call) {
        Link nl = new Link();
        nl.data = call;
        if (first == null) {
            first = nl;
            last = nl;
        }
        else {
            last.next = nl;         //chyba - chyběl tento řádek
            last = nl;
        }
    }

    /**
     * Vrati prvni prichozi hovor nebo null, pokud je fronta prazdna
     * @return prvni prichozi hovor nebo null, pokud je fronta prazdna
     */
    public IncomingCall get() {
        if (first == null) {        //chyba
            return null;
        }
        else {
            return first.data;
        }
    }

    /**
     * Odstrani prvni prichozi hovor z fronty, pokud fronta neni prazdna
     */
    public void removeFirst() {
        if (first != null) {
            first = first.next;
        }
        else {
            System.out.println("Remove call on empty queue. Probably error, continuing...");
        }
    }
}
