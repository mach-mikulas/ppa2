/**
 * Hash tabulka pro uchovani zaznamu s nahledem obrazku
 * @author Libor Vasa
 */
class HashTable {
    /** Zaznamy tabulky */
    Entry[] data;

    /**
     * Vytvori novou hash tabulku se zadanou kapacitou
     * @param capacity kapacita tabulky
     */
    public HashTable(int capacity) {
        this.data = new Entry[capacity];                    //Chybejici radka v konstruktoru
    }

    /**
     * Prida zaznam do has tabulky
     * @param key klic - nazev souboru s obrazkem
     * @param value hodnota - index v databazi nahledu obrazku
     */
    public void add(String key, int value) {
        Entry newEntry = new Entry(key, value);
        int index = getHashCode(key);

        newEntry.next = data[index];                        //prohozeny řádky
        data[index] = newEntry;

    }

    public void addDumb(String key, int value) {
        Entry newEntry = new Entry(key, value);
        int index = getHashCodeDumb(key);

        newEntry.next = data[index];                        //prohozeny řádky
        data[index] = newEntry;

    }

    /**
     * Vypocte a vrati hash kod pro zadany klic
     * @param s klic, pro ktery se ma vypocitat hash kod
     * @return hash kod pro zadany klic
     */
    int getHashCode(String s){

        int result = s.charAt(1);

        for(int i = 1; i < s.length(); i++){
            result = (result * 256 + s.charAt(i)) % data.length;
        }

        return result;
        //return 0;
    }

    int getHashCodeDumb(String s){
        return 0;
    }

    int get(String s){
        int hash = getHashCode(s);
        Entry current = data[hash];
        while(current != null){
            if(current.fileName.equals(s)){
                return current.indexInDatabase;
            }
            current = current.next;
        }
        return -1;
    }

    int getDumb(String s){
        int hash = getHashCodeDumb(s);
        Entry current = data[hash];
        while(current != null){
            if(current.fileName.equals(s)){
                return current.indexInDatabase;
            }
            current = current.next;
        }
        return -1;
    }
}