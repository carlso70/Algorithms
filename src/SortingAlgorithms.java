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
        System.out.println("Before quicksort = ");
        printArray(b);
        quickSort(b, 0, b.length-1);
        System.out.println("After Quicksort");
        printArray(b);

        int[] z = {9,8,7,6,5,4,3,2,1};
        System.out.println("Before selectionSort = ");
        printArray(z);
        System.out.println("After selectionSort = ");
        printArray(selectionSort(z));

        int[] bub = {9,8,7,6,5,4,3,2,1};
        System.out.println("Before bubbleSort = ");
        printArray(bub);
        System.out.println("After bubbleSort = ");
        printArray(bubbleSort(bub));


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


    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int minValue, minIndex, temp=0;
        for (int i = 0; i < arr.length; i++){
            minValue = arr[i];
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }

            if (minValue < arr[i]) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }


    /*
     * Merge Sort does log n merge steps because each merge step doubles the list size.
     * it does n for each merge step because it must look at every item
     *
     * so it runs O(n log n)
     */
    public static void mergeSort(int[] arr, int lowIndex, int highIndex) {
        // Base case
        if (lowIndex == highIndex)
            return;

        else {
            int midIndex = (lowIndex + highIndex)/2;

            //left half
            mergeSort(arr, lowIndex, midIndex);
            //right half
            mergeSort(arr, midIndex + 1, highIndex);

            // merges sorted left and right half
            merge(arr, lowIndex, midIndex + 1, highIndex);
        }

    }

    // Merges the sorted left and right half
    public static void merge(int[] arr, int lowIndex, int midIndex, int highIndex) {
        int[] left = new int[midIndex - lowIndex + 2];

        for (int i = lowIndex; i <= midIndex; i++) {
            left[i-lowIndex] = arr[i];
        }
        left[midIndex - lowIndex + 1] = Integer.MAX_VALUE;

        int[] right = new int[highIndex - midIndex + 1];

        for (int i = midIndex + 1; i <= highIndex; i++) {
            right[i - midIndex - 1] = arr[i];
        }

        right[highIndex-midIndex] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int x = lowIndex; x <= highIndex; x++) {
            if (left[i] <= right[j]) {
                arr[x] = left[i];
                i++;
            }else {
                arr[x] = right[j];
                j++;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
