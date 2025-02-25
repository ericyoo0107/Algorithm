package baekjoon.dfs_bfs;

import java.util.*;

public class P2667_단지번호붙이기 {
    static int dx[] = new int[]{1, 0, -1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};
    static int house[][];
    static boolean visited[][];
    static int N;
    static int result = 0;
    static int[] houseCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.valueOf(scanner.nextLine());
        house = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                house[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        // === 세팅 ===
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (house[i][j] != 0 && visited[i][j] == false) {
                    result++;
                    BFS(i, j);
                }
            }
        }
        houseCount = new int[result+1];
        Arrays.fill(houseCount, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (house[i][j] != 0) {
                    houseCount[house[i][j]]++;
                }
            }
        }
        Arrays.sort(houseCount, 1, result+1);
        System.out.println(result);
        for (int i = 1; i < result + 1; i++) {
            System.out.println(houseCount[i]);
        }
    }


    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        house[x][y] = result;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now_x = poll[0];
            int now_y = poll[1];
            for (int i = 0; i < 4; i++) {
                if (now_x + dx[i] <= N && now_x + dx[i] >= 0 && now_y + dy[i] <= N && now_y + dy[i] >= 0) {
                    if (house[now_x + dx[i]][now_y + dy[i]] != 0 && !visited[now_x + dx[i]][now_y + dy[i]]) {
                        queue.add(new int[]{now_x + dx[i], now_y + dy[i]});
                        visited[now_x + dx[i]][now_y + dy[i]] = true;
                        house[now_x + dx[i]][now_y + dy[i]] = result;
                    }
                }
            }
        }
    }
}
