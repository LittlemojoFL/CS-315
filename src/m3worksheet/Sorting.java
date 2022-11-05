package m3worksheet;

public class Sorting {
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        System.out.println();
    }

    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void quicksort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quicksort(arr, low, pi-1);
            quicksort(arr, pi+1, high);
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp;
        String line = "";
        boolean swapped;
        for(int i=0; i < n; i++){
            if(i == n-1) {
                System.out.println("\nfinal array = " + printArray(arr));
                return;
            }
            line = "\ni = " + i + "\tarray = " + printArray(arr);
            int len = line.length();
            System.out.println(line);
            swapped = false;
            for(int j=1; j < (n-i); j++){
                line = "j = " + j + "\tarray =   ";
                for(int x = 0; x < j; x++)
                    line += "  ";
                line += arr[j-1] + " " + arr[j];
                if(arr[j-1] > arr[j]){
                    swapped = true;
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                for(int x = line.length(); x < len; x++)
                    line += " ";
                line += "  Swapped = " + swapped;
                System.out.println(line);
            }
        }
    }

    public static void selectionSort(int[] arr){
        String line = "";
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            if(i == arr.length-2) {
                System.out.println("\nfinal array: " + printArray(arr));
                return;
            }
            System.out.println("\ni = " + i + "\tarr = \t" + printArray(arr) + "\tmin = " + min);
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                line = "\tj = " + j + "        ";
                for(int x = 0; x < j; x++) {
                    line += "  ";
                }
                line += "*";
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
                System.out.println(line);
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            min = smallerNumber;
        }
    }

    public static void insertionSort(int arr[]) {
        String line = "", spaces = "";
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j-1;

            System.out.println("\ni = " + i + "    array = " + printArray(arr));
            while ( (i > -1) && (arr [i] > key ) ) {

                spaces = "\t    ";
                for(int x = 0; x < i; x++)
                    spaces += "  ";
                arr [i+1] = arr [i];
                line = "        j = " + (j-i) + spaces + key + " " + arr[i];
                System.out.println(line);
                i--;
            }
            arr[i+1] = key;
        }
    }

    static String printArray(int[] arr) {
        String line = "";
        for(int i = 0; i < arr.length; i++)
            line += arr[i] + " ";
        return line;
    }
    public static void main(String[] args) {
//        int arr1[] ={3, 12, 44, 99, 72, 33, 11, 18, 65, 42};
//        int arr2[] = {8, 6, 42, 11, 5, 19, 88, 40, 9, 3};
//
//        int arr5[] = {3, 12, 44, 99, 72, 33, 11, 18, 65, 42};
//        int arr6[] = {8, 6, 42, 11, 5, 19, 88, 40, 9, 3};
//
//        int mergeArr[] = {3, 12, 44, 99, 72, 33, 11, 18, 65, 42};
//        int mergeArr1[] = {8, 6, 7, 5, 3, 0, 9, 99, 44, 100, 11};

        int num6[] = {11, 38, 42, 8, 6, 5};

//        System.out.println("BUBBLE SORT #1");
//        bubbleSort(arr1);
//        System.out.println("--------------------------------------");
//        System.out.println("\n\n\n\n\nBUBBLE SORT #2");
//        bubbleSort(arr2);
//        System.out.println("--------------------------------------");

//        System.out.println("\nSELECTION SORT #1");
//        selectionSort(arr1);
//        System.out.println("--------------------------------------");
//        System.out.println("\n\n\n\n\nSELECTION SORT #2");
//        selectionSort(arr2);
//        System.out.println("--------------------------------------");

//        System.out.println("\nINSERTION SORT #1");
//        insertionSort(arr5);
//        System.out.println("--------------------------------------");
//        System.out.println("\n\n\n\n\nINSERTION SORT #2");
//        insertionSort(arr6);
//        System.out.println("--------------------------------------");

        System.out.println("\nMERGE SORT #1");
        System.out.print("Given array is: ");
        System.out.println(printArray(num6));
        quicksort(num6, 0, num6.length-1);
        System.out.print("Sorted array is: ");
        System.out.println(printArray(num6));
        System.out.println("--------------------------------------");
//        System.out.println("\n\n\n\n\nMERGE SORT #2");
//        mergeSort(mergeArr1, 0, mergeArr1.length-1);
//        System.out.println("--------------------------------------");

    }
}
