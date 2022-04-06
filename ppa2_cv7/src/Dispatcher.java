import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Odbavovani prichozich hovoru pomoci operatoru
 * @author Libor Vasa
 */
class Dispatcher {
    /** Fronta prichozich hovoru */
    //private CallerQueue callerQueue;
    private GenericQueue<IncomingCall> callerQueue;
    /** Fronta operatoru */
    //private OperatorQueue operatorQueue;
    private GenericQueue<FreeOperator> operatorQueue;

    /**
     * Vytvori novou instanci s prazdnymi frontami
     */
    public Dispatcher() {
        //this.callerQueue = new CallerQueue();
        //this.operatorQueue = new OperatorQueue();
        this.callerQueue = new GenericQueue<IncomingCall>();
        this.operatorQueue = new GenericQueue<FreeOperator>();
    }

    /**
     * Zaradi prichozi hovor do fronty
     * @param number telefonni cislo prichoziho hvoru
     * @param time cas zacatku hovoru (v sekundach od zacatku smeny)
     */
    public void call(int number, int time) {
        IncomingCall call = new IncomingCall();
        call.callingNumber = number;
        call.time = time;
        callerQueue.add(call);
    }

    /**
     * Zaradi volneho operatora do fronty
     * @param name jmeno volneho operatora
     * @param time cas zarazeni volneho operatora do fronty (v sekundach od zacatku smeny)
     */
    public void freeOperator(String name, int time) {
        operatorQueue.add(new FreeOperator(name, time)); // operator name se time sekund od zacatku smeny prihlasil jako dostupny
    }

    /**
     * Priradi nejdele cekajici hovor z fronty nejdele cekajicimu operatorovi z fronty
     */
    public void dispatchCall() {
        if(operatorQueue.get() != null && callerQueue.get() != null){
            assignCall(callerQueue.get(), operatorQueue.get());
            callerQueue.removeFirst();
            operatorQueue.removeFirst();
        }

        else {
            //System.out.println("Operator or IncomingCall queue is empty");
        }
    }

    /**
     * Priradi zadany prichozi hovor zadanemu volnemu operatorovi
     * @param call prichozi hovor
     * @param operator volny operator
     */
    private void assignCall(IncomingCall call, FreeOperator operator) {
        System.out.println(operator.name + " is answering call from +420 " + call.callingNumber);
        System.out.println("The caller has waited for " + Math.max(0, operator.time - call.time) + " seconds.");

        int callWait = Math.max(0, operator.time - call.time);

        try{
            CallDispatching.bfw.append(operator.name + " is answering call from +420 " + call.callingNumber + "\n");
            CallDispatching.bfw.append("The caller has waited for " + callWait + " seconds.\n");
        }


        catch (IOException e){
            e.printStackTrace();
        }


    }
}