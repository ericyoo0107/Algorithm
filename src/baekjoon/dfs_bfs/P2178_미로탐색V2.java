package baekjoon.dfs_bfs;

import java.util.*;

// 못 푼 이유  visited를 2차원 배열로 해보자

public class P2178_미로탐색V2 {
    static int map[][] = new int[101][101];
    static int result = 1;
    static boolean visited[] = new boolean[10001];
    static int N, M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    private static class Index {
        int height;
        int width;

        public Index(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }

    public static void main(String[] args) {
        Arrays.fill(visited, false);
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.valueOf(line.charAt(j) - 48);
            }
        }

        bfs();

        System.out.println(map[N-1][M-1]);
    }

    private static void bfs() {
        Queue<Index> queue = new LinkedList();
        queue.add(new Index(0, 0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            Index target = queue.poll();
            int h = target.height; // 0
            int w = target.width; // 0
            for(int i=0; i< 4; i++){
                int y = h+dy[i];
                int x = w+dx[i];
                if(x>=0 && y>=0){
                    if(map[y][x] == 1 && !visited[y*M + x]){
                        map[y][x] = map[h][w] + 1;
                        queue.add(new Index(y, x));
                        visited[y*M + x] = true;
                    }
                }
            }
/*

            if (h == N+1 && w == M+1) break;
            if ((map[h - 1][w] == 1 && !visited[((h - 1) * M) + w]) || (map[h][w + 1] == 1 && !visited[(h * M) + (w + 1)]) || (map[h + 1][w] == 1 && !visited[((h + 1) * M) + (w + 1)]) || (map[h][w - 1] == 1 && !visited[(h * M) + w])) {
                result++;
                System.out.println(result);
                if (map[h - 1][w] == 1 && !visited[((h - 1) * M) + w]) queue.add(new Index(h - 1, w));
                if (map[h][w + 1] == 1 && !visited[(h * M) + (w + 1)]) queue.add(new Index(h, w + 1));
                if (map[h + 1][w] == 1 && !visited[((h + 1) * M) + (w + 1)]) queue.add(new Index(h + 1, w));
                if (map[h][w - 1] == 1 && !visited[(h * M) + w]) queue.add(new Index(h, w - 1));
            }*/
        }
    }
}
