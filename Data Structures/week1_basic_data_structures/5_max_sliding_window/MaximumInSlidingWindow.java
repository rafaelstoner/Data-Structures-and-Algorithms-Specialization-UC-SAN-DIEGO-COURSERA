import java.util.*;

public class MaximumInSlidingWindow {
    public static void main(String[] args) {
        int [] sequence = readInput();
        int m = new Scanner(System.in).nextInt();
        findMaximums(sequence, sequence.length, m);
    }

    private static void findMaximums(int[] sequence, int n, int m) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            while (!dq.isEmpty() && sequence[dq.peekLast()] <= sequence[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for (int i = m; i < n; i++) {
            System.out.print(sequence[dq.peek()] + " ");

            while (!dq.isEmpty() && dq.peek() <= i - m) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && sequence[dq.peekLast()] <= sequence[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        // Print the maximum of the last window.
        System.out.println(sequence[dq.peek()]);

    }

    static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}