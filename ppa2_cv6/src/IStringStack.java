/**
 * Zasobnik pro uchovani retezcu
 * @author Libor Vasa
 */
interface IStringStack {
    /**
     * Prida retezec do zasobniku
     * @param s retezec, ktery ma byt pridan do zasobniku
     */
    void add(String s);

    /**
     * Vrati retezec z vrcholu zasobniku
     * @return retezec z vrcholu zasobniku
     */
    String get();

    /**
     * Odstrani prvek z vrcholu zasobniku
     */
    void removeLast();

}
