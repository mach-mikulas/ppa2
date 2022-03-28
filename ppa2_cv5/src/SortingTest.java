import java.util.Arrays;
import java.util.Random;

/**
 * Testovani razeni
 * @author Libor Vasa
 */
public class SortingTest {
    public static void main(String[] args) {

        ISortingAlgorithm[] algorithms = {new InsertSort(), new QuickSort(), new MergeSort(), new JavaSort()};

        for(int i = 0; i < algorithms.length; i++) {
            if (testCorrectness(algorithms[i])) {
                testCounts(algorithms[i]);
            }

            System.out.println();
        }

    }

    /**
     * Otestuje pocty porovani zadaneho razeni
     * @param algorithm testovany algoritmus razeni
     */
    private static void testCounts(ISortingAlgorithm algorithm) {
        int MIN_LENGTH = 100;
        int MAX_LENGTH = 100000;
        int TEST_COUNT = 100;
        long casStart = 0;
        long casKonec = 0;
        long casRandom = 0;
        long casSerazene = 0;

        for (int length = MIN_LENGTH; length < MAX_LENGTH; length *= 2) {
            long minComp = Integer.MAX_VALUE;
            long maxComp = 0;
            for (int test = 0; test < TEST_COUNT; test++) {
                int[] data = generateData(length);
                algorithm.sort(data);
                if (algorithm.comparesInLastSort() > maxComp) {
                    maxComp = algorithm.comparesInLastSort();
                }
                if (algorithm.comparesInLastSort() < minComp) {
                    minComp = algorithm.comparesInLastSort();
                }
            }

            long pocetVSerazene = 0;
            try {
                int[] data = generateData(length);
                Arrays.sort(data);
                algorithm.sort(data);
                pocetVSerazene = algorithm.comparesInLastSort();
            } catch (StackOverflowError error) {
                System.out.println("Pretekl stack kvuli prilis mnoho volani rekurzivni funkce");
            }

            try {
            int[] data = generateData(length);

            casStart = System.nanoTime();
            algorithm.onlySort(data);
            casKonec = System.nanoTime();

            casRandom = casKonec-casStart;

            casStart = System.nanoTime();
            algorithm.onlySort(data);
            casKonec = System.nanoTime();

            casSerazene = casKonec-casStart;

            } catch (StackOverflowError error) {
                System.out.println("Pretekl stack kvuli prilis mnoho volani rekurzivni funkce");
            }

            System.out.println("Length: " + length + ", Min:" + minComp + ", Max:" + maxComp + ", Pocet v serazene: " + pocetVSerazene + ", Cas serazeni random: " + casRandom + "ns, Cas serazeni serazeneho: " + casSerazene + "ns");
        }
    }

    /**
     * Otestuje spravnost zadaneho razeni
     * @param algorithm testovany algoritmus razeni
     */
    private static boolean testCorrectness(ISortingAlgorithm algorithm) {
        for (int i = 0; i < 100; i++) {
            int[] data = generateData(100);
            int[] dataCopy = new int[data.length];
            for (int j = 0; j < data.length; j++) {
                dataCopy[j] = data[j];
            }
            algorithm.sort(data);
            Arrays.sort(dataCopy);

            for (int j = 0; j < data.length; j++) {
                if (data[j] != dataCopy[j]) {
                    System.out.println("Algorithm failed, terminating.");
                    return false;
                }
            }
        }
        System.out.println("Algorithm passed test, continuing.");
        return true;
    }

    /**
     * Vygeneruje pole o zadane velikosti c nahodnych cisel z intervalu <0; c)
     * @param c velikost vygenerovaneho pole a horni hranice generovanych hodnot
     * @return vygenerovane pole nahodnych cisel
     */
    private static int[] generateData(int c) {
        int[] result = new int[c];
        Random rnd = new Random();
        for (int i = 0; i < c; i++) {
            result[i] = rnd.nextInt(c);
        }
        return result;
    }
}