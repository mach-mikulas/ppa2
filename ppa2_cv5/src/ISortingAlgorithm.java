/**
 * Rozhrani pro radici algoritmy
 * @author Libor Vasa
 */
interface ISortingAlgorithm {

    /**
     * Seradi zadane pole
     * @param data pole, ktere se ma seradit
     */
    public void sort(int[] data);

    /**
     * Vrati pocet porovnani v poslednim provedem razeni.
     * Pokud dosud zadne razeni nebylo provedeno, vrati 0.
     * @return pocet porovnani v poslednim provedenem razeni
     */
    public long comparesInLastSort();

    public void onlySort(int[] data);
}
