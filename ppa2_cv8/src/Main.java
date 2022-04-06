public class Main {
    public static void main(String[] args) throws Exception {
        LinkList myList = new LinkList();
        MyIterator it = new MyIterator(myList);

        it.insert('a');
        it.insert('k');
        it.insert('l');
        it.next();
        it.insert('a');
        it.next();
        it.insert('s');

        //it.printList();

        it.moveToFirst();
        it.insert('v');
        it.insert('i');
        it.insert('p');
        it.next();
        it.next();
        it.next();
        it.remove();
        it.remove();
        it.remove();
        it.remove();
        it.insert('o');
        it.next();
        it.remove();

        //it.printList();




    }
}
