/**
 * Implementace zasobniku retezcu pomoci pole
 * @author Libor Vasa
 */
class StackArray implements IStringStack {
    /** Data v zasobniku */
    protected String[] data;
    /** Index pozice, na kterou se vlozi novy prvek */
    protected int freeIndex;

    /**
     * Vytvori novy prazdny zasobnik
     */
    public StackArray() {
        data = new String[5];
        freeIndex = 0;
    }

    public void add(String s) {

        if(freeIndex >= data.length){
            expandArray();
        }

        data[freeIndex] = s;
        freeIndex++;
    }

    public String get() {
        if(freeIndex > 0) {
            return data[freeIndex - 1];
        }
        return null;
    }

    public void removeLast() {
        if(freeIndex > 0){
            freeIndex--;
            data[freeIndex] = null;
        }
        else {
            System.out.println("Zásobník je prázdný");
        }
    }

    public void expandArray(){

        String[] newData = new String[data.length * 2];

        for(int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }

        data = newData;
    }

}