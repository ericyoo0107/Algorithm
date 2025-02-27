package baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576_토마토 {

    static int[][] box;
    static int result = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M;
    static int N;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        box = new int[N + 1][M + 1];
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] tomato = line.split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(tomato[j]);
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j, 1});
                }
            }
        }
        /* // 시간 초과
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1)
                    BFS(i, j);
            }
        }*/
        BFS();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] > result) result = box[i][j] - 1;
                if (box[i][j] == 0) {
                    result = -1;
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println(result);
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now_y = poll[0];
            int now_x = poll[1];
            int depth = poll[2];
            for (int i = 0; i < 4; i++) {
                if (now_x + dx[i] >= 0 && now_x + dx[i] < M && now_y + dy[i] >= 0 && now_y + dy[i] < N && box[now_y + dy[i]][now_x + dx[i]] != -1 && box[now_y + dy[i]][now_x + dx[i]] != 1) {
                    // 새 영역에 토마토 영역 확장
                    if (box[now_y + dy[i]][now_x + dx[i]] == 0) {
                        box[now_y + dy[i]][now_x + dx[i]] = depth + 1;
                        queue.add(new int[]{now_y + dy[i], now_x + dx[i], depth + 1});
                    }
                    // 남의 영역에 토마토 영역 다시 할당
                    if (depth + 1 < box[now_y + dy[i]][now_x + dx[i]]) {
                        box[now_y + dy[i]][now_x + dx[i]] = depth + 1;
                        queue.add(new int[]{now_y + dy[i], now_x + dx[i], depth + 1});
                    }
                }
            }
        }
    }
}
