/**
 * Prvek spojoveho seznamu pro ulozeni sousedu vrcholu grafu
 * @author Libor Vasa
 */
class Link {
    /** Cislo souseda */
    int neighbour;
    /** Odkaz na dalsiho souseda */
    Link next;

    /**
     * Vytvori novy prvek seznamu pro ulozeni souseda vrcholu grafu
     * @param n cislo souseda
     * @param next odkaz na dalsiho souseda
     */
    public Link(int n, Link next) {
        this.neighbour = n;
        this.next = next;       //this
    }
}
