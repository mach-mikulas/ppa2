import java.util.Random;
import java.util.Scanner;

/**
 * Asistent omezujici prokrastinaci
 * @author Libor Vasa
 */
class ProcrastinationAssistant {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IStringStack stack = new StackArray();
        String line;
        String hlUkol;
        int pocetPridani = 0;

        System.out.println("Co je třeba udělat?");
        hlUkol = sc.nextLine();

        stack.add(hlUkol);

        while(stack.get() != null){
            System.out.println("Aktuální úkol: " + stack.get());
            System.out.println("Co s úkolem? (H = Hotovo, R = Rozdělit)");
            stack.removeLast();
            line = sc.nextLine();

            switch (line){
                case "R":
                    System.out.println("Prosím zadej podúkoly, ukončené prázdným řetězcem");
                    line = sc.nextLine();
                    while(line.length() > 0){
                        stack.add(line);
                        line = sc.nextLine();
                        pocetPridani++;
                    }

                    String[] tempo = new String[pocetPridani];
                    for(int i = 0; pocetPridani > 0;i++){

                        tempo[i] = stack.get();
                        stack.removeLast();
                        pocetPridani--;
                    }

                    for(int j = 0; j < tempo.length; j++){
                        stack.add(tempo[j]);
                    }

                    break;
                case "H":
                    break;
            }

        }

        System.out.println("Hlavní úkol " + hlUkol + " byl splněn");
        /*
        IStringStack stack = new StackArray();
        IStringStack stackSlow = new StackArraySlow();

        long start;
        long end;
        long cas;

        //stack.add("Naucit se hrat na ukulele");
        //stack.add(randomString());

        start = System.currentTimeMillis();
        testStack(stack);
        end = System.currentTimeMillis();
        cas = end - start;

        System.out.println("Cas testovani normálního zásobníku: " + cas + "ms");
        //System.out.println(stack.get());

        start = System.currentTimeMillis();
        testStack(stackSlow);
        end = System.currentTimeMillis();
        cas = end - start;

        System.out.println("Cas testovani pomalého zásobníku: " + cas + "ms");

         */
    }

    /**
     * Vygeneruje a vrati nahodny retezec
     *
     * @return nahodny retezec velkych pismen nahodne delky (5 az 24 znaku)
     */
    public static String randomString() {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < (5 + r.nextInt(20)); i++) {
            sb.append((char) (r.nextInt(24) + 65));
        }
        return (sb.toString());
    }

    public static void testStack(IStringStack stack){

        String[] stringArray = new String[100000];
        //String[] stringArrayFinal = new String[100000];

        for (int i = 0; i < 100000 ; i++){
            stringArray[i] = randomString();
        }

        for (int i = 0; i < 100000 ; i++){
            stack.add(stringArray[i]);
        }

        for (int i = 99999; i >= 0 ; i--){

            //stringArrayFinal[i] = stack.get();

            if(!stringArray[i].equals(stack.get())){
                System.out.println("Pole se neshoduje se zásobníkem");
                return;
            }

            stack.removeLast();
        }

        /*

        for (String prvek: stringArray) {
            System.out.print(prvek + ", ");
        }

        System.out.println();
        for (String prvek: stringArrayFinal) {
            System.out.print(prvek + ", ");
        }
        System.out.println();

         */

        System.out.println("Zásobník funguje správně");
    }
}