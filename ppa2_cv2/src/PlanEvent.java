import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Doucovane predmety
 * @author Libor Vasa
 */
enum Subject {math, computers}

/**
 * Nabidka tutora na doucovani
 * @author Libor Vasa
 */
public class PlanEvent {
    /** Jmeno tutora */
    public String tutor;
    /** Hodina pocatku doucovani (10 = 10:00 atd.) */
    public int start;
    /** Hodina konce doucovani (10 = 10:00 atd.) */
    public int end;
    /** Den tydne doucovani (0 = Pondeli, 1 = Utery atd.) */
    public int dayOfWeek;
    /** Doucovany predmet */
    public Subject subject;
    /** Pocet OK rozvrzu */
    public static int okRozvrhy = 0;
    /**
     * Vytvori novou nabidku tutora na doucovani
     */
    public PlanEvent(String tutor, int start, int end, int dayOfWeek, Subject subject) {
        this.tutor = tutor;
        this.start = start;
        this.end = end;
        this.dayOfWeek = dayOfWeek;
        this.subject = subject;
    }

    /**
     * Vrati true, pokud se tato udalost prekryva se zadanou udalosti, jinak vrati false
     * @param other udalost, ktera se muze prekryvat s touto udalosti
     * @return true, pokud se tato udalost prekryva se zadanou udalosti, jinak vrati false
     */
    public boolean isInConflict(PlanEvent other) {
        if (this.dayOfWeek != other.dayOfWeek) {
            return false;
        }
        if (this.end <= other.start) {
            return false;
        }
        if (other.end <= this.start) {
            return false;
        }
        return true;
    }


    /**
     * spocita kolik ma soubor radek a vrati int
     * @param nazevSouboru nazev souboru
     * @return pocet radek v souboru
     */
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

    /**
     * Nacte ze souboru 5 radku ze kterych vytvori objekt a ulozi jej do pole, opakuje se dokud jsou v souboru radky
     * @param nazevSouboru soubor ze ktereho se nacita
     * @return pole PlanEventu
     */

    static PlanEvent[] nacteniPosloupnosti(String nazevSouboru){

        int i = 0;
        int numberOfObjects = pocetRadek(nazevSouboru)/5;
        PlanEvent[] data = new PlanEvent[numberOfObjects];

        String tutor;
        int start;
        int end;
        int dayOfWeek;
        Subject subject;

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(nazevSouboru));
            while((tutor = bfr.readLine()) != null){

                if(bfr.readLine().equals("computers")){
                    subject = Subject.computers;
                }
                else{
                    subject = Subject.math;
                }
                dayOfWeek = Integer.parseInt(bfr.readLine());
                start = Integer.parseInt(bfr.readLine());
                end = Integer.parseInt(bfr.readLine());

                data[i] = new PlanEvent(tutor,start,end,dayOfWeek,subject);
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

    /**
     * Kombinace pomoci rekurze, nevraci nic, kdyz vytvori jeden prvek kombinace rovnou ho otestuje metodou isOK a vypise
     * @param arr vstupni pole
     * @param data podmnozina
     * @param start prvni element
     * @param end posledni element
     * @param index aktualni element
     * @param r jak velky bude jeden prvek
     */
    public static void kombinace(PlanEvent[] arr, PlanEvent[] data, int start, int end, int index, int r) {
        if (index == r) {
            Plan rozvrh = new Plan(data);
            if(rozvrh.isOK()){
                for (PlanEvent e: data) {
                    e.vypisEvent();
                }
                okRozvrhy++;
            }
        } else {
            for (int i=start; i <= end && end-i+1 >= r-index; i++) {
                data[index] = arr[i];
                kombinace(arr, data, i+1, end, index+1, r);
            }
        }
    }

    /** Vypise do cmd jeden PlanEvent */
    public void vypisEvent(){
        System.out.println("Vyucujici: " + this.tutor + ", predmet: " + this.subject + ", start: " + this.start + ", konec: " + this.end + ", den: " + this.dayOfWeek);
    }

    public static void main(String[] args) {
        /*
        PlanEvent event1 = new PlanEvent("František Vonásek", 10, 13, 1, Subject.math);
        PlanEvent event2 = new PlanEvent("Čeněk Landsmann", 9, 12, 1, Subject.computers);
        PlanEvent event3 = new PlanEvent("Hubert Zámožný", 11, 14, 1, Subject.math);
        PlanEvent event4 = new PlanEvent("Dobromila Musilová-Wébrová", 9, 14, 1, Subject.computers);
        PlanEvent event5 = new PlanEvent("Sisoj Psoič Rispoloženskyj", 11, 12, 1, Subject.math);
        PlanEvent event6 = new PlanEvent("Billy Blaze", 8, 10, 1, Subject.computers);
        PlanEvent event7 = new PlanEvent("Flynn Taggart", 13, 15, 1, Subject.math);
        System.out.println(event1.isInConflict(event2));
        System.out.println(event1.isInConflict(event3));
        System.out.println(event1.isInConflict(event4));
        System.out.println(event1.isInConflict(event5));
        System.out.println(event1.isInConflict(event6));
        System.out.println(event1.isInConflict(event7));
         */


        /*
        System.out.println(pocetRadek("ssc.txt"));
        PlanEvent[] data = nacteniPosloupnosti("ssc.txt");
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i].subject);
        }
         */

        PlanEvent[] data = nacteniPosloupnosti("sscUTF8.txt");

        int r = 5; // jak je veliky jeden prvek kombinace
        int n = data.length;

        PlanEvent[] podmnozina = new PlanEvent[r];

        kombinace(data, podmnozina, 0, n-1, 0, r);
        System.out.println("Pocet okRozvrhu: " + okRozvrhy);
    }
}
