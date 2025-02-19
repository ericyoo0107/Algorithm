package baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2468_안전지역 {
    static int N;
    static int[][] map;
    static int[][] tempMap;

    public static void main(String[] args) {
        int maxCount = 0;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        } // === setting ===

        for (int k = 0; k < 101; k++) {
            int count = 0;
            copyMap();
            //printMap();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tempMap[i][j] > k) {
                        BFS(i, j, k);
                        count++;
                    }
                }
            }
            if (maxCount < count) maxCount = count;
        }
        System.out.print(maxCount);
    }

    static void BFS(int x, int y, int k) {
        Queue<XY> queue = new LinkedList();
        queue.add(new XY(x, y));
        tempMap[x][y] = -1;
        while (!queue.isEmpty()) {
            XY now = queue.poll();
            if((now.x + 1) < N){ // 아래로
                if (tempMap[now.x + 1][now.y] > k && (now.y) < N) {
                    queue.add(new XY(now.x + 1, now.y));
                    tempMap[now.x + 1][now.y] = -1;
                }
            }
            if((now.y + 1) < N){ // 왼쪽으로
                if (tempMap[now.x][now.y + 1] > k && (now.x) < N) {
                    queue.add(new XY(now.x, now.y + 1));
                    tempMap[now.x][now.y + 1] = -1;
                }
            }
            if((now.x - 1) >= 0){ // 위로
                if (tempMap[now.x - 1][now.y] > k && (now.y) < N) {
                    queue.add(new XY(now.x - 1, now.y));
                    tempMap[now.x - 1][now.y] = -1;
                }
            }
            if((now.y - 1) >= 0){ //오른쪽으로
                if (tempMap[now.x][now.y - 1] > k && (now.x) < N) {
                    queue.add(new XY(now.x, now.y - 1));
                    tempMap[now.x][now.y - 1] = -1;
                }
            }
        }
    }

    static class XY {
        public int x;
        public int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void printMap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tempMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void copyMap(){
        tempMap = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
    }
}