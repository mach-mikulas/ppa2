public class GenericQueue<T> {
    /** Prvni prvek fronty */
    private GenericLink first;
    /** Posledni prvek fronty */
    private GenericLink last;

    /**
     * Prida volneho operatora na konec fronty
     * @param person prichozi hovor
     */
    public void add(T person) {
        GenericLink nl = new GenericLink<T>();
        nl.data = person;
        if (first == null) {
            first = nl;
            last = nl;
        }
        else {
            last.next = nl;
            last = nl;
        }
    }

    /**
     * Vrati prvni volneho operator nebo null, pokud je fronta prazdna
     * @return prvni volny operator nebo null, pokud je fronta prazdna
     */
    public T get() {
        if (first == null) {
            return null;
        }
        else {
            return (T)first.data;
        }
    }

    /**
     * Odstrani prvniho volneho operatora z fronty, pokud fronta neni prazdna
     */
    public void removeFirst() {
        if (first != null) {
            first = first.next;
        }
        else {
            System.out.println("Remove freeoperator on empty queue. Probably error, continuing...");
        }
    }
}
