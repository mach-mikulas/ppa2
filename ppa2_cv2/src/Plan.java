public class Plan {

    PlanEvent[] rozvrh;

    public Plan(PlanEvent[] rozvrh){
        this.rozvrh = rozvrh;
    }

    public boolean isConflict(){
        for (int i = 0; i < rozvrh.length-1; i++){
            for (int j = i+1; j < rozvrh.length; j++){
                if(rozvrh[i].isInConflict(rozvrh[j]))
                    return true;
            }
        }
        return false;
    }

    public boolean isOK(){

        if(isConflict()){
            return false;
        }

        int mathCount = 0;
        int computersCount = 0;

        for(int i = 0; i < rozvrh.length; i++){
            if(rozvrh[i].subject == Subject.math){
                mathCount++;
            }

            if(rozvrh[i].subject == Subject.math){
                computersCount++;
            }
        }

        if(mathCount < 3 || computersCount < 2){
            return false;
        }


        for(int i = 0; i < rozvrh.length-1; i++){
            for(int j = i+1; j < rozvrh.length; j++){
                if(rozvrh[i].dayOfWeek == rozvrh[j].dayOfWeek && rozvrh[i].subject == rozvrh[j].subject){
                        return false;
                }
            }
        }
        System.out.println("OK");
        return true;
    }
}
