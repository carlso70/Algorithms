/**
 * Created by jamescarlson on 1/6/17.
 */
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] a = {5,1,24,5,2,14144,44,234,77,88,96,74567,12341234,5134};
        int[] t = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};

        int[] arr = insertionSort(a);
        int[] arr2 = insertionSort(t);
        printArray(arr);
        printArray(arr2);

        int[] b = {4,3,5,2,10,11};
        quickSort(b, 0, b.length-1);

    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        return arr;
    }

    /*
     * Recursive quicksort
     * start index is the start of the array
     * endIndex is the end index of the array
     */

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        int index = partition(arr, startIndex, endIndex);

        // recursively call quicksort with left part of the partitioned array
        if (startIndex < index - 1) {
            quickSort(arr, startIndex, index - 1);
        }

        // recursively call quicksort with the right part of the partitioned array
        if (endIndex > index) {
            quickSort(arr, index, endIndex);
        }

    }

    /*
     * Divides array from pivot, left side contains less than Pivot while right side contain
     * greater than pivot.
     *
     * returns the partition index
     */

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // taking the first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (arr[left] < pivot) {
                left++;
            }
            // searching number which is less than pivot, top down
            while (arr[right] > pivot) {
                right--;
            }

            //swap values
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }



    public static void printArray(int[] arr) {
        for (int a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
