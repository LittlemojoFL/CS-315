package CS420;

public class Multithreading {
    static int[] arr;
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No arguments passed.");
        } else {
            arr = new int[args.length - 1];
            for (int i = 0; i < args.length - 1; i++)
                arr[i] = Integer.parseInt(args[i]);
            printArr();

            new Multithreading();
        }
    }

    public Multithreading() {
        AvgThread avg = new AvgThread(arr);
        minThread min = new minThread(arr);
        maxThread max = new maxThread(arr);

        avg.run();
        min.run();
        max.run();

        System.out.println("The average value is " + avg.getAvg());
        System.out.println("The minimum value is " + min.getMin());
        System.out.println("The minimum value is " + max.getMax());
    }

    static void printArr() {
        System.out.print("Values: ");
        for(int i = 0; i < arr.length; i++)
            System.out.print((i < arr.length-1) ? arr[i] + ", " : arr[i] + ".\n");
    }
}

class AvgThread extends Thread {
    int[] arr;
    int avg = 0;
    public AvgThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for(int i = 0; i < arr.length; i++)
            avg += arr[i];
    }

    public int getAvg() {
        return avg /= arr.length;
    }
}

class minThread extends Thread {
    int[] arr;
    int min = Integer.MAX_VALUE;
    public minThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] < min)
                min = arr[i];
    }

    public int getMin() {
        return min;
    }
}

class maxThread extends Thread {
    int[] arr;
    int max = Integer.MIN_VALUE;
    public maxThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] > max)
                max = arr[i];
    }

    public int getMax() {
        return max;
    }
}


