package baekjoon.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class P10451_순열사이클 {
    static int T;
    static boolean[] visited = new boolean[1001];
    static int[] result;
    static int aResult = 0;

    public static void main(String[] args) {
        Arrays.fill(visited, false);
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        result = new int[T];
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] arr = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                arr[j] = scanner.nextInt();
            }
            dfs(arr, N);
            result[i] = aResult;
            Arrays.fill(visited, false);
            aResult = 0;
        }
        scanner.close();
        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int[] arr, int N) {
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            aResult++;
            int now = i;
            while (true) {
                now = arr[now];
                visited[now] = true;
                if (now == i) break;
            }
        }
    }
}
