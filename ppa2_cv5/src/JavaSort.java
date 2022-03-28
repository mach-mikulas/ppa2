import java.util.Arrays;

public class JavaSort implements ISortingAlgorithm{

    public void sort(int[] data){
        Arrays.sort(data);
    }

    public long comparesInLastSort(){
        return 0;
    }

    public void onlySort(int[] data){
        Arrays.sort(data);
    }

}
