import java.util.Random;

/**
 * Tri varianty odstraneni duplicitnich hodnot z pole
 * @author Libor Vasa
 */
public class RemoveDuplicates {

    /**
     * Odstrani z pole prvek na indexu index
     * @param data vstupni pole dat
     * @param index index polozky, ktera se ma odstranit
     * @return vysledne pole bez jedne polozky
     */
    public static int[] removeItem(int[] data, int index) {
        //vysledne pole bude o 1 kratsi
        int[] result = new int[data.length - 1];
        //zkopirujeme prvky az do indexu i
        for (int i = 0; i < index; i++) {
            result[i] = data[i];
        }
        //i-ty prvek preskocime a zkopirujeme vsechny zbyvajici prvky
        for (int i = index + 1; i < data.length; i++) {
            result[i - 1] = data[i];
        }
        return result;
    }

    /**
     * Prochazi vsechny polozky a odstranuje duplikaty metodou removeItem()
     * @param data vstupni pole dat
     * @return vysledna data s odstranenymi duplikaty
     */
    public static int[] removeDuplicates1(int[] data) {
        int[] result = data;
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] == result[i]) {
                    result = removeItem(result, j);
                    j--; // <--------------------------- chyba (j--)
                }
            }
        }
        return result;
    }

    /**
     * Prochazi vsechny polozky a provadi ostraneni vsech duplikatu jedne polozky najednou
     * @param data vstupni pole dat
     * @return vysledna data s odstranenymi duplikaty
     */
    public static int[] removeDuplicates2(int[] data) {
        int[] result = data;
        for(int i = 0; i < result.length; i++){
            //spocteme, kolik ma polozka result[i] duplikatu
            int count = 0; //pocet duplikatu
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] == result[i]) {
                    count++;
                }
            }
            //pokud je alespon jeden duplikat, pak ho odstranime
            if (count > 0) {
                //vysledek bude o count kratsi
                int[] newResult = new int[result.length - count];
                //prvky az do indexu i muzeme jednoduse zkopirovat
                for (int k = 0; k <= i; k++) {
                    newResult[k] = result[k];
                }
                int index = i+1; //index v cilovem poli // <--------------------------- chyba (+1)
                for (int k = i + 1;k < result.length; k++) {
                    if (result[k] != result[i]) { //neni duplikat
                        newResult[index] = result[k];
                        index++;
                    }
                }
                result = newResult;
            }
        }
        return result;
    }

    /**
     * Pouziva redukci pomoci pole zaznamu, zda dane cislo bylo nalezeno v datech ci nikoli
     * @param data vstupni pole dat
     * @return vysledna data s odstranenymi duplikaty
     */
    public static int[] removeDuplicates3(int[] data) {
        //nejdrive jen zjistime, kolik mame unikatnich cisel
        boolean[] encountered = new boolean[1000000];
        int count = 0; //pocet unikatnich cisel
        for (int i = 0; i < data.length; i++) {
            if (!encountered[data[i]]) { //nove objevene cislo
                encountered[data[i]] = true;
                count++; // <--------------------------- chyba (Count -> count)
            }
        }
        //v promenne count je ted pocet unikatnich cisel
        //pole encountered ted pouzijeme jeste jednou stejnym zpusobem
        encountered = new boolean[1000000];
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (!encountered[data[i]]) {
                result[index] = data[i];
                encountered[data[i]] = true;
                index++;
            }
        }
        return result;
    }

    /**
     * Generuje nahodna data v rozsahu do 100 000,
     * cimz se simuluje, ze cca 90% cisel je "neaktivnich"
     * @param count pocet pozadovanych cisel
     * @return pole nahodnych cisel
     */
    public static int[] generateData(int count) {
        int[] result = new int[count];
        Random r = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = r.nextInt(100000);
        }
        return result;
    }

    public static void print(int[] data){
        for (int num : data) {
            System.out.println(num);
        }
        System.out.println();
    }

    public static void timeTest(){

        double timeRD1 = 0;
        int nRD1 = 0;
        double timeRD2 = 0;
        int nRD2 = 0;
        double timeRD3 = 0;
        int nRD3 = 0;

        double timeRD1A[] = new double[10];
        double timeRD2A[] = new double[10];
        double timeRD3A[] = new double[10];

        long currentRD = 0;
        long time1 = 0;
        long time2 = 0;
        int count = 1000;

        while (timeRD1 <= 1000){
            int[] data = generateData(count);

            time1 = System.currentTimeMillis();
            removeDuplicates1(data);
            time2 = System.currentTimeMillis();
            nRD1 = count;

            timeRD1 = time2-time1;
            count *= 1.5;
        }

        System.out.println("Metoda removeDuplicates1 trvala pres 1 sekundu (konkretne " + timeRD1/1000  + "s) pro n = " + nRD1);

            count = 1000;

        while (timeRD2 <= 1000){
            int[] data = generateData(count);


            time1 = System.currentTimeMillis();
            removeDuplicates2(data);
            time2 = System.currentTimeMillis();

            nRD2 = count;

            timeRD2 = time2-time1;
            count *= 1.5;
        }

        System.out.println("Metoda removeDuplicates2 trvala pres 1 sekundu (konkretne " + timeRD2/1000  + "s) pro n = " + nRD2);

        count = 1000;

        while (timeRD3 <= 1000){
            int[] data = generateData(count);

            time1 = System.currentTimeMillis();
            removeDuplicates3(data);
            time2 = System.currentTimeMillis();

            nRD3 = count;

            timeRD3 = time2-time1;
            count *= 1.5;
        }

        count = 1000;


        System.out.println("Metoda removeDuplicates3 trvala pres 1 sekundu (konkretne " + timeRD3/1000  + "s) pro n = " + nRD3);

        while (timeRD1 <= 10000){
            int[] data = generateData(count);

            time1 = System.currentTimeMillis();
            removeDuplicates1(data);
            time2 = System.currentTimeMillis();
            nRD1 = count;

            timeRD1 = time2-time1;
            count *= 1.5;
        }
        count = 1000;
        System.out.println("Metoda removeDuplicates1 trvala pres 10 sekund  (konkretne " + timeRD1/1000  + "s) pro n = " + nRD1);



        int i = 0;

        while (nRD1 < 100000){

            int[] data = generateData(count);


            time1 = System.currentTimeMillis();
            removeDuplicates1(data);
            time2 = System.currentTimeMillis();

            nRD1 = count;

            timeRD1 = time2-time1;

            //System.out.println("n1 " + i + "count " + count);
            timeRD1A[i] = timeRD1;

            count += 11000;
            i++;
        }

        count = 1000;
        i = 0;

        while (nRD2 < 100000){

            int[] data = generateData(count);


            time1 = System.currentTimeMillis();
            removeDuplicates2(data);
            time2 = System.currentTimeMillis();

            nRD2 = count;

            timeRD2 = time2-time1;

            //System.out.println("n2 " + i + "count " + count);
            timeRD2A[i] = timeRD2;

            count += 11000;
            i++;
        }

        count = 1000;
        i = 0;

        while (nRD3 < 100000){

            int[] data = generateData(count);


            time1 = System.currentTimeMillis();
            removeDuplicates3(data);
            time2 = System.currentTimeMillis();

            nRD3 = count;

            timeRD3 = time2-time1;

            //System.out.println("n2 " + i + "count " + count);
            timeRD3A[i] = timeRD3;

            count += 11000;
            i++;
        }

        count = 1000;
        i = 0;

        System.out.println("n\t\tt1\t\tt2\t\tt3");

        int printCount = 1000;

        for (int j = 0; j < 10; j++){
            System.out.println(printCount + "\t" + timeRD1A[j] + " \t" + timeRD2A[j] + " \t" + timeRD3A[j]);
            printCount += 11000;
        }

    }



    public static void main(String[] args) {
        //int count = 30000;
        //int[] data = generateData(count);

        //int[] data = {0,0,1,3,1,5,5,5,0,2,2,0,0}; // O,1,3,5,2

        //int[] reducedData1 = removeDuplicates1(data);
        //int[] reducedData2 = removeDuplicates2(data);
        //int[] reducedData3 = removeDuplicates3(data);
        //System.out.println("All done.");


        //print(reducedData1);
        //print(reducedData2);
        //print(reducedData3);
        timeTest();

    }
}
