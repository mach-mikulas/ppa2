import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class cv1_cast3 {


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

    static int pocetRadek(String nazevSouboru){

        int pocetRadek = 0;

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(nazevSouboru));

            while(bfr.readLine() != null){
                pocetRadek++;
            }
            bfr.close();
            return pocetRadek;
        }

        catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return pocetRadek;
    }

    static int[] nacteniPosloupnosti(String nazevSouboru){

        int radek;
        String sRadek;
        int i = 0;
        int[] data = new int[pocetRadek(nazevSouboru)];

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(nazevSouboru));
            while((sRadek = bfr.readLine()) != null){
                radek = Integer.parseInt(sRadek);
                data[i] = radek;
                i++;
            }
            bfr.close();
            return data;
        }

        catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return data;
    }

    public static void main(String[] args) {

        Random random = new Random();
        String[] soubory = {"seq1.txt", "seq2.txt", "seq3.txt", "seq4.txt", "seq5.txt", "seq6.txt", "seq7.txt", "seq8.txt", "seq9.txt", "seq10.txt"};

        for(int i = 0; i < soubory.length; i++){
            int[] mnozina = nacteniPosloupnosti(soubory[i]);
            int delkaMnoziny = pocetRadek(soubory[i]);
            long delkaPuleni = 0;
            long delkaSeq = 0;
            int nahodneCislo;


            if(isSorted(mnozina)){
                System.out.println("pocet prvku mnoziny " + soubory[i] + ": " + delkaMnoziny);


                for(int j = 0; j < 10000; j++){
                    long start = System.nanoTime();
                    nahodneCislo = random.nextInt(mnozina[0], mnozina[delkaMnoziny-1]+1);
                    intervalSubdivision(mnozina,nahodneCislo);
                    long stop = System.nanoTime();
                    delkaPuleni += stop - start;
                }

                System.out.println("puleni intervalem trvalo: " + delkaPuleni + "ns");

                for(int j = 0; j < 10000; j++){
                    long start = System.nanoTime();
                    nahodneCislo = random.nextInt(mnozina[0], mnozina[delkaMnoziny-1]+1);
                    sequentialSearch(mnozina, nahodneCislo);
                    long stop = System.nanoTime();
                    delkaSeq += stop - start;
                }

                System.out.println("sekvencni hledani trvalo: " + delkaSeq + "ns");
                System.out.println("puleni intervalem je priblizne " + delkaSeq/delkaPuleni + "krat rychlejsi nez sekvencni hledani");
                System.out.println();
            }
        }
    }


}


