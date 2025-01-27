package baekjoon.dfs_bfs;

import java.util.Scanner;

public class P2178_미로탐색 {
    private static String[][] graph = new String[10001][2];
    private static Boolean[][] check = new Boolean[101][101];
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        String[][] map = new String[101][101];

        // 입력
        for (int i = 0; i < N; i++) {
            String mapPiece = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                char c = mapPiece.charAt(j);
                map[i][j] = String.valueOf(c);
            }
        }

        // 그래프 초기화
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < 2; j++) {
                graph[i][j] = "0";
            }
        }

        // 그래프 만들기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == N-1 && j != M-1) {
                    if (map[i][j + 1].equals("1")) {
                        graph[(i * 6) + j + 1][0] = String.valueOf((i * 6) + j + 2);
                        continue;
                    }
                } else if (i != N-1 && j == M-1) {
                    if (map[i + 1][j].equals("1")) {
                        graph[(i * 6) + j + 1][0] = String.valueOf(((i + 1) * 6) + j + 1);
                        continue;
                    }
                } else if (i == N-1 && j == M-1) {
                    continue;
                }
                String right = map[i][j + 1];
                String down = map[i + 1][j];
                if (right.equals("1") && down.equals("0")) {
                    graph[(i * 6) + j + 1][0] = String.valueOf((i * 6) + j + 2);
                } else if (right.equals("0") && down.equals("1")) {
                    graph[(i * 6) + j + 1][0] = String.valueOf(((i + 1) * 6) + j + 1);
                } else if (right.equals("1") && down.equals("1")) {
                    graph[(i * 6) + j + 1][0] = String.valueOf((i * 6) + j + 2);
                    graph[(i * 6) + j + 1][1] = String.valueOf(((i + 1) * 6) + j + 1);
                }
            }
        }

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
}
