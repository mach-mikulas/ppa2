public class MyIterator {
    Link current;
    LinkList list;

    public MyIterator(LinkList list){
        this.current = null;
        this.list = list;
    }

    void insert(char letter) throws Exception {
        Link newLink = new Link();
        newLink.data = letter;
        if (current == null) {
            newLink.next = list.first;
            list.first = newLink;
            printList();
        }
        else {
            newLink.next = current.next;
            current.next = newLink;             //Vyměniné řádky
            printList();
        }
    }

    /**
     * Posune aktualni prvek na dalsi v seznamu
     * @throws Exception pokud zadny dalsi prvek neni
     */
    void next() throws Exception {
        if (list.first == null) {
            throw new Exception();
        }
        if (current == null) {
            current = list.first;
        }
        else {
            current = current.next;
            if (current == null) {
                throw new Exception();
            }
        }
    }

    /**
     * Vrati znak v aktualnim prvku seznamu
     * @return znak v aktualnim prvku seznamu
     */
    char get() throws Exception {
        if (list.first == null) {
            throw new Exception();
        }
        if (current == null) {
            return list.first.data;
        }
        if (current.next != null) {
            return current.next.data;
        }
        else {
            throw new Exception();
        }
    }

    /**
     * Zmeni aktualni prvek na prvni prvek seznamu
     */
    void moveToFirst() {
        current = null;
    }

    boolean hasNext() {
        if (current == null) {
            if (list.first != null) {
                return true;
            }
            else {
                return false;
            }
        }
        if (current.next != null) {
            return true;
        }
        else {
            return false;
        }
    }

    void remove() throws Exception {
        if (list.first == null){
            throw new Exception();
        }
        if(current == null){
            list.first = list.first.next;
            printList();
        }
        else if(current.next == null){
            throw new Exception();
        }
        else{
            current.next = current.next.next;
            printList();
        }

    }

    void printList() throws Exception {

        Link buff = current;
        moveToFirst();

        while(hasNext()){
            System.out.print(get());
            next();
        }

        System.out.println();

        current = buff;
    }
}
