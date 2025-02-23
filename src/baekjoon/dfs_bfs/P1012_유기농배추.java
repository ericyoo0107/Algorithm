package baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1012_유기농배추 {
    static boolean land[][];
    static int M;
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            resetLand();
            int count = 0;
            for (int j = 0; j < K; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                land[y][x] = true;
            }
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (land[y][x] == true) {
                        BFS(y, x);
                        count++;
                    }
                }
            }
            resetLand();
            System.out.println(count);
        }
    }

    static void BFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        land[y][x] = false;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x_now = poll[0];
            int y_now = poll[1];
            if ((x_now + 1) <= M && y_now <= N && land[y_now][x_now + 1] == true) {  // 우로 1보
                land[y_now][x_now + 1] = false;
                queue.add(new int[]{x_now + 1, y_now});
            }
            if ((x_now - 1) >= 0 && y_now <= N && land[y_now][x_now - 1] == true) { // 좌로 1보
                land[y_now][x_now - 1] = false;
                queue.add(new int[]{x_now - 1, y_now});
            }
            if ((x_now) <= M && (y_now + 1) <= N && land[y_now + 1][x_now] == true) { // 아래로 1보
                land[y_now + 1][x_now] = false;
                queue.add(new int[]{x_now, y_now + 1});
            }
            if ((x_now) <= M && (y_now - 1) >= 0 && land[y_now - 1][x_now] == true) { // 아래로 1보
                land[y_now - 1][x_now] = false;
                queue.add(new int[]{x_now, y_now - 1});
            }
        }
    }

    static void resetLand() {
        land = new boolean[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                land[N][M] = false;
            }
        }
    }
}
