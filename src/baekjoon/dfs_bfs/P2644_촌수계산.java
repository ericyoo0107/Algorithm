package baekjoon.dfs_bfs;

import java.util.*;

public class P2644_촌수계산 {
    static Map<Integer, ArrayList<Integer>> relations = new HashMap<>();
    static boolean[] visited;
    static int p2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCnt = scanner.nextInt();
        int p1 = scanner.nextInt();
        p2 = scanner.nextInt();
        int relationCnt = scanner.nextInt();
        visited = new boolean[peopleCnt +1];
        for (int i = 0; i < relationCnt; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            if (relations.containsKey(parent)) {
                ArrayList list = relations.get(parent);
                list.add(child);
                relations.put(parent, list);
            } else {
                ArrayList list = new ArrayList<>();
                list.add(child);
                relations.put(parent, list);
            }
            if (relations.containsKey(child)) {
                ArrayList list = relations.get(child);
                list.add(parent);
                relations.put(child, list);
            } else {
                ArrayList list = new ArrayList<>();
                list.add(parent);
                relations.put(child, list);
            }
        }
        int result = DFS(p1);
        System.out.println(result);
    }

    static int DFS(int start) {
        Stack<int[]> stack = new Stack();
        stack.push(new int[]{start, 0});
        visited[start] = true;
        while (!stack.empty()) {
            int[] pop = stack.pop();
            int node = pop[0];
            int depth = pop[1];
            if (node == p2) return depth;
            for (Integer target : relations.get(node)) {
                if (!visited[target]) {
                    stack.push(new int[]{target, depth + 1});
                    visited[target] = true;
                }
            }
        }
        return -1;
    }
}
