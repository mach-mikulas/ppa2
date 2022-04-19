import java.io.*;
import java.util.Random;

/**
 * Hlavni trida programu
 * @author Libor Vasa
 */
public class Thumbnails {

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

    static String[] nacteniSouboru(String nazevSouboru){

        String sRadek;
        int i = 0;
        String[] data = new String[pocetRadek(nazevSouboru)];

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(nazevSouboru));
            while((sRadek = bfr.readLine()) != null){
                data[i] = sRadek;
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

    public static void dumbHashTest(int tableLength, String[] pole){
        HashTable table = new HashTable(tableLength);
        int random;
        int dotazy = 0;
        Random rn = new Random();

        long time = 0;
        long timeStart = System.currentTimeMillis();

        while(time < 2000){

            random = rn.nextInt(10000);

            if(table.getDumb(pole[random]) == -1){
                table.addDumb(pole[random], 0);
            }


            time = System.currentTimeMillis() - timeStart;
            dotazy++;
        }

        System.out.println("Pro C = "+ tableLength + " bylo zpracováno " + dotazy  +" dotazů");
    }

    public static void hashTest(int tableLength, String[] pole){
        HashTable table = new HashTable(tableLength);
        int random;
        int dotazy = 0;
        Random rn = new Random();

        long time = 0;
        long timeStart = System.currentTimeMillis();

        while(time < 2000){

            random = rn.nextInt(10000);

            if(table.get(pole[random]) == -1){
                table.add(pole[random], 0);
            }


            time = System.currentTimeMillis() - timeStart;
            dotazy++;
        }

        System.out.println("Pro C = "+ tableLength + " bylo zpracováno " + dotazy  +" dotazů");
    }


    public static void main(String[] args) {

        //Cast ze cviceni
        /*
        HashTable table = new HashTable(101);

        for(int i = 0; i < 1000; i++){
          table.add(randomImageName() , i);
        }

        int celkovyPocet = 0;

        for(Entry index: table.data){
            int pocet = 0;

            if(index != null && index.next!= null) {
                while (index.next != null) {
                    pocet++;
                    index.next = index.next.next;
                }
                celkovyPocet += pocet;
            }

            System.out.println(pocet);
        }
        System.out.println("\n" + celkovyPocet);
         */

       String[] input = nacteniSouboru("ImageNames.txt");

        System.out.println("Počet zpracovaných dotazů za 2 sekundy, hloupá rozptylová funkce:");
        dumbHashTest(1000,input);
        dumbHashTest(1009,input);
        dumbHashTest(30030,input);
        dumbHashTest(100000,input);
        dumbHashTest(100003,input);
        System.out.println("\nPočet zpracovaných dotazů za 2 sekundy, chytrá rozptylová funkce:");
        hashTest(1000,input);
        hashTest(1009,input);
        hashTest(30030,input);
        hashTest(100000, input);
        hashTest(100003, input);

    }

    /**
     * Vygeneruje a vrati nahodny nazev obrazku
     * @return nahodny nazev obrazku
     */
    private static String randomImageName() {
        Random r = new Random();
        int year = 2005 + r.nextInt(13);
        int month = 1 + r.nextInt(12);
        int day = 1 + r.nextInt(28);
        int img = 1 + r.nextInt(9999);
        return String.format("c:\\fotky\\%d-%02d-%02d\\IMG_%04d.CR2", year, month, day, img);
    }
}