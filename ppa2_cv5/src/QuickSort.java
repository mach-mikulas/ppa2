public class QuickSort implements ISortingAlgorithm {
    int compares = 0;

    @Override
    public void sort(int[] data) {
        compares = 0;
        quickSort(data, 0, data.length - 1);
    }

    public void quickSort(int[] data, int start, int end) {
        if(end <= start) return;
        int i = split(data, start, end);
        quickSort(data, start, i - 1);
        quickSort(data, i + 1, end);
    }

    boolean lessThanPivot(int[] data, int left, int pivot) {
        compares++;
        return data[left] < pivot;
    }

    boolean graterThanPivot(int[] data, int right, int pivot) {
        compares++;
        return data[right] > pivot;
    }

//    data[left] < pivot
//    data[right] > pivot

    public int split(int[] data, int left, int right) {
        int pivot = data[right];
        while (true){
            while ((lessThanPivot(data, left, pivot)) && (left < right)) {
                left++;
            }
            if(left < right) {
                data[right] = data[left];
                right--;
            } else break;
            while ((graterThanPivot(data, right, pivot)) && (left < right)) {
                right--;
            }
            if(left < right) {
                data[left] = data[right];
                left++;
            } else break;
        }
        data[left] = pivot;
        return left;
    }

    @Override
    public long comparesInLastSort() {
        return compares;
    }

    public void quickSortO(int[] data, int start, int end) {
        if(end <= start) return;
        int i = splitO(data, start, end);
        quickSortO(data, start, i - 1);
        quickSortO(data, i + 1, end);
    }

    public int splitO(int[] data, int left, int right) {
        int pivot = data[right];
        while (true){
            while ((data[left]<pivot)&&(left<right))
                left++;
            if (left<right){
                data[right] = data[left];
                right--;
            } else break;
            while ((data[right]>pivot)&&(left<right))
                right--;
            if (left<right){
                data[left] = data[right];
                left++;
            } else break;
        }
        data[left] = pivot;
        return(left);
    }

    @Override
    public void onlySort(int[] data){
        quickSortO(data, 0, data.length - 1);
    }
}