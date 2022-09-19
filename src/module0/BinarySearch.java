package module0;

public class BinarySearch {
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No arguments passed.");
        } else if(args.length == 1) {
            System.out.println("Key with no values");
        } else {
            int key = Integer.parseInt(args[0]);
            int [] arr = new int[args.length-1];
            for(int i = 1; i < args.length-1; i++) {
                arr[i - 1] = Integer.parseInt(args[i]);
            }
            System.out.print("Values: ");
            for(int i = 0; i < arr.length; i++)
               System.out.print((i < arr.length-1) ? i + ", " : "" + i);
            System.out.println("\nKey: " + key);
            System.out.println("Rank: " + rank(key, arr));
        }
    }
}