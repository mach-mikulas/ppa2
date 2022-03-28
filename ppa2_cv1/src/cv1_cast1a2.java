import java.util.Random;
import java.util.Scanner;

public class cv1_cast1a2 {


    /**
     * Metoda rozhoduje, zda se predana hodnota x nachazi v predanem serazenem poli
     * @param data vstupni pole serazenych hodnot od nejmensi po nejvetsi
     * @param x hledana hodnota
     * @return true, kdyz se x nachazi v poli data, jinak false
     */
    static boolean intervalSubdivision(int[] data, int x) {
        int left = 0; //leva hranice intervalu
        int right = data.length-1; //prava hranice intervalu
        int mid = (left + right) / 2; //index uprostred intervalu
        while (data[mid] != x) {
            if (left >= right) {
                return false;
            }
            //nyni zmensime interval
            if (data[mid] > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return true;
    }

    static boolean sequentialSearch(int[] data, int x){
        for(int i = 0; i < data.length; i++){
            if(data[i] == x){
                return true;
            }
        }
        return false;
    }

    static int[] vygenerunPosloupnost(int l){

        int[] data = new int[l];
        int nahodneCislo;
        Random rand = new Random();

        data[0] = rand.nextInt(100);
        int predchoziCislo = data[0];

        for(int i = 1; i < data.length;){
            nahodneCislo = predchoziCislo + rand.nextInt(100);
            if(nahodneCislo > predchoziCislo){
                data[i] = nahodneCislo;
                predchoziCislo = nahodneCislo;
                i++;
            }
        }
        return data;
    }

    static boolean isSorted(int[] data){

        int predchoziPrvek = data[0];

        for(int i = 1; i < data.length; i++){
            if(predchoziPrvek > data[i]){
                return false;
            }
            predchoziPrvek = data[i];
        }
        return true;
    }

    /*static int[] nacteniPosloupnosti(){
        Scanner sc = new Scanner(System.in);

        //TO DO
    }
*/
    public static void main(String[] args) {
        Random rando = new Random();
        //int[] data = new int[]{1, 3, 5, 41, 48, 52, 63, 71, 78};
        //long start = System.nanoTime();
        //boolean found = intervalSubdivision(data, 53);
        //long stop = System.nanoTime();
        //System.out.println("Interval subdivision finished in " + (stop - start) + " ns");
        //System.out.println("Number found: " + found);


        //for (int i = 0; i < test.length; i++) {
        //    System.out.print(test[i] + " ");
        //}

        /*
        for (int j = 0; j < 1000; j++) {

            int l = rando.nextInt(100000-10001)+10001;
            int[] test = vygenerunPosloupnost(l);

            for (int i = 0; i < 1000; i++) {
                int nahodneX = rando.nextInt(((test[test.length-1])-test[0]))+test[0];

                long start = System.nanoTime();
                boolean found = intervalSubdivision(test, nahodneX);
                long stop = System.nanoTime();

                System.out.println("Interval subdivision finished in " + (stop - start) + " ns");
                System.out.println("Number found: " + found);

                long start2 = System.nanoTime();
                boolean found2 = sequentialSearch(test, nahodneX);
                long stop2 = System.nanoTime();

                System.out.println("Interval subdivision finished in " + (stop2 - start2) + " ns");
                System.out.println("Number found: " + found2);
            }
        }

        */
    }


}


