import java.util.Scanner;
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n <= 0) {
        System.out.println("Invalid array size");
        sc.close();
        return;
    }
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    long maxEnding = arr[0];
    long minEnding = arr[0];
    long maxProduct = arr[0];
    for (int i = 1; i < n; i++) {
        int current = arr[i];
        if (current < 0) {
            long temp = maxEnding;
            maxEnding = minEnding;
            minEnding = temp;
        }
        maxEnding = Math.max(current, maxEnding * current);
        minEnding = Math.min(current, minEnding * current);
        maxProduct = Math.max(maxProduct, maxEnding);
    }
    System.out.println(maxProduct);

    sc.close();
}
}
