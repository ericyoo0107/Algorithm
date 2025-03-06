package baekjoon.dfs_bfs;

import java.util.*;

public class P2583_영역구하기 {
    static int count = 0;
    static int map[][] = new int[101][101];
    static int landSize = 0;
    static ArrayList<Integer> result = new ArrayList<>();
    static int M, N, K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        K = scanner.nextInt();

        for (int i = 0; i < K; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            fillMap(x1, y1, x2, y2);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    count++;
                    BFS(j, i);
                    result.add(landSize);
                    landSize = 0;
                }
            }
        }

        System.out.println(count);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    static void fillMap(int x1, int y1, int x2, int y2) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                map[y][x] = 1;
            }
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        map[y][x] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now_x = poll[0];
            int now_y = poll[1];
            landSize++;
            if (now_x + 1 < N && map[now_y][now_x + 1] == 0) {
                queue.add(new int[]{now_x + 1, now_y});
                map[now_y][now_x + 1] = 1;
            }
            if (now_x - 1 >= 0 && map[now_y][now_x - 1] == 0) {
                queue.add(new int[]{now_x - 1, now_y});
                map[now_y][now_x - 1] = 1;
            }
            if (now_y + 1 < M && map[now_y + 1][now_x] == 0) {
                queue.add(new int[]{now_x, now_y + 1});
                map[now_y + 1][now_x] = 1;
            }
            if (now_y - 1 >= 0 && map[now_y - 1][now_x] == 0) {
                queue.add(new int[]{now_x, now_y - 1});
                map[now_y - 1][now_x] = 1;
            }
        }
    }
}