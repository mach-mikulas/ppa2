/**
 * Zaznam hash tabulky s nahledy obrazku
 * @author Libor Vasa
 */
class Entry{
    /** Nazev souboru s obrazkem */
    public String fileName;
    /** Index v databazi nahledu obrazku */
    int indexInDatabase;
    /** Dalsi zaznam (pro potreby hash tabulky) */
    public Entry next;

    /**
     * Vyvtori novy zaznam se zadanym nazvem souboru a indexem do databaze
     * @param fn nazev souboru s obrazkem
     * @param index index v databazi nahledu obrazku
     */
    public Entry (String fn, int index) {
        this.fileName = fn;
        this.indexInDatabase = index;
    }
}
