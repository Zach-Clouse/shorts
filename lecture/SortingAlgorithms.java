
public class SortingAlgorithms {
    
    private static <T> void display(T arr[]) {
        String result = "{}";
        if (arr.length != 0) {
            result = "{";
            for (T e : arr) {
                result += e + ", ";
            }
            
            result = result.substring(0, result.length() - 2) + "}";
        }
        
        System.out.printf("%s\n", result);
    }
    
    private static <T> void swap(T arr[], final int index1, final int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    private static <T extends Comparable<T>>
        int findMinIndex(T arr[], final int start) {
        int minIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[minIndex]) < 0) {
                minIndex = i;
            }
        }
        
        return minIndex;
    }
    
    public static <T extends Comparable<T>>
        void selectionSort(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = findMinIndex(arr, i);
            swap(arr, i, minIndex);
        }
    }
    
    private static <T extends Comparable<T>>
        int partition(T arr[], final int min, final int max) {
        
        T pivot = arr[min];
        int left = min;
        int right = max;
        
        while (left < right) {
            while (left < right && arr[left].compareTo(pivot) <= 0) {
                left++;
            }
            while (arr[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
            
        }
        swap(arr, min, right);
        
        return right;
    }
    
    private static <T extends Comparable<T>>
        void quickSort(T arr[], final int left, final int right) {
        
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
        
    }
    
    public static <T extends Comparable<T>>
        void quickSort(T arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }
    
 // Main Method
    public static void main(String[] args) {
        Integer arrInt[] = {0, 10, 3, -4, 45, -82, -8, 17, 0, 62}; 
        String arrS[] = {"dsfsd", "1231", "aaa", "b", "F"};
        
        display(arrInt);
        quickSort(arrInt);
        display(arrInt);
        
        display(arrS);
        quickSort(arrS);
        display(arrS);
    }

}
