public class OperatorQueue{

    /** Prvni prvek fronty */
    private LinkOperator first;
    /** Posledni prvek fronty */
    private LinkOperator last;

    /**
     * Prida volneho operatora na konec fronty
     * @param operator prichozi hovor
     */
    public void add(FreeOperator operator) {
        LinkOperator nl = new LinkOperator();
        nl.data = operator;
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
    public FreeOperator get() {
        if (first == null) {
            return null;
        }
        else {
            return first.data;
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
