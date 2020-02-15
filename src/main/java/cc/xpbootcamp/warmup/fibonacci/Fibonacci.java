package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    private static long arr[] = new long[50];

    public static long calculate(int i) {
        if (i > 2) {
            long first = arr[i-1] == 0 ? calculate(i-1) : arr[i-1];
            arr[i-1] = first;
            long second = arr[i-2] == 0 ? calculate(i-2) : arr[i-2];
            arr[i-2] = second;
            return first + second;
        }
        return 1;
    }
}
