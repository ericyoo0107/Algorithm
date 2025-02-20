package baekjoon.dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1679_숨바꼭질 {
    static int N, K;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        visited = new boolean[100001];
        Arrays.fill(visited, false);
        int result = BFS(N);
        if(N==K) result = 0;
        System.out.println(result);
    }

    public static int BFS(int node) {
        Queue<int[]> queue = new LinkedList<>(); // 위치, depth 저장
        queue.add(new int[]{node, 0});
        visited[node] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now = poll[0];
            int depth = poll[1];
            int a = now + 1;
            int b = now - 1;
            int c = now * 2;
            if (a == K || b == K || c == K) return depth + 1;
            if (a >= 0 && a < 100001 && !visited[a]) {
                queue.add(new int[]{a, depth + 1});
                visited[a] = true;
            }
            if (b >= 0 && b < 100001 && !visited[b]) {
                queue.add(new int[]{b, depth + 1});
                visited[b] = true;
            }
            if (c >= 0 && c < 100001 && !visited[c]) {
                queue.add(new int[]{c, depth + 1});
                visited[c] = true;
            }
        }
        return -1;
    }
}
