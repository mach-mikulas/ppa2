public class MergeSort implements ISortingAlgorithm{
    long compares = 0;

    boolean greaterThan(int[] data, int i, int v) {
        compares++;
        return data[i] < data[v];
    }

    void mergeSort(int[] data, int start, int end){
        if (end==start)
            return;
        int mid = (start + end)/2;
        mergeSort(data, start, mid);
        mergeSort(data, mid+1, end);
        int[] temp = bitonic(data, start, mid, end);
        mergeBitonic(data, start, temp);
    }

    void mergeBitonic(int[] data, int start, int[] bitonic){
        int i = 0;
        int j = bitonic.length-1;
        for (int k = 0;k<bitonic.length;k++) {
        data[start + k] = bitonic[i] < bitonic[j] ? bitonic[i++] : bitonic[j--];
        compares++;
        }
    }

    int[] bitonic(int[] data, int start, int mid, int end){
        int[] result = new int[end-start+1];
        for (int i = start;i<=mid;i++)
            result[i-start] = data[i];
        for (int i = mid+1;i<=end;i++)
            result[end - start + mid + 1 - i] = data[i];
        return result;
    }


    public void sort(int[] data){
        compares = 0;
        mergeSort(data,0,data.length-1);
    }

    public long comparesInLastSort(){
        return compares;
    }

    void mergeSortO(int[] data, int start, int end){
        if (end==start)
            return;
        int mid = (start + end)/2;
        mergeSortO(data, start, mid);
        mergeSortO(data, mid+1, end);
        int[] temp = bitonic(data, start, mid, end);
        mergeBitonicO(data, start, temp);
    }

    void mergeBitonicO(int[] data, int start, int[] bitonic){
        int i = 0;
        int j = bitonic.length-1;
        for (int k = 0;k<bitonic.length;k++) {
            data[start + k] = bitonic[i] < bitonic[j] ? bitonic[i++] : bitonic[j--];
        }
    }

    @Override
    public void onlySort(int[] data){
        mergeSortO(data,0,data.length-1);
    }
}
