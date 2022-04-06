import javax.sound.midi.Soundbank;
import java.io.*;

public class CallDispatching {

    public static FileWriter outputFile;
    public static BufferedWriter bfw;

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

    public static void main(String[] args) {
        /*
        Dispatcher d = new Dispatcher();
        d.freeOperator("Tonda", 0);
        d.dispatchCall();
        d.freeOperator("Jarmila", 10);
        d.dispatchCall();
        d.call(608123456, 15);
        d.dispatchCall();
        d.call(723987654, 35);
        d.dispatchCall();
        d.call(602112233, 45);
        d.dispatchCall();
        d.freeOperator("Pepa", 62);
        d.dispatchCall();
        d.call(608987654, 124);
        d.dispatchCall();
        d.freeOperator("Tonda", 240);
        d.dispatchCall();
         */

        Dispatcher d = new Dispatcher();


        try {

            outputFile = new FileWriter("output.txt");
            bfw = new BufferedWriter(outputFile);

            String[] soubor = nacteniSouboru("callCentrum.txt");

            for (String radek : soubor) {

                if (!radek.equals("")) {
                    String[] prvekRadku = radek.split(" ");

                    switch (prvekRadku[0]) {
                        case "O":
                            d.freeOperator(prvekRadku[2], Integer.parseInt(prvekRadku[1]));
                            break;
                        case "C":
                            d.call(Integer.parseInt(prvekRadku[2]), Integer.parseInt(prvekRadku[1]));
                            break;

                    }
                    d.dispatchCall();
                    //System.out.println(prvekRadku[0] + ", " + prvekRadku[1] + ", " + prvekRadku[2]);
                }
            }
            bfw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
