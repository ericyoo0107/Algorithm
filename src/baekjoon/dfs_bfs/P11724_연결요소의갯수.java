package baekjoon.dfs_bfs;

import java.util.*;

// 11724번 연결 요소의 개수
public class P11724_연결요소의갯수 {
    static Integer result = 0;
    static Boolean checks[];
    static Map<Integer, ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N = Integer.parseInt(scanner.next());
        Integer M = Integer.parseInt(scanner.next());
        checks = new Boolean[N+1];
        Arrays.fill(checks, Boolean.FALSE);
        graph = new LinkedHashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        // 그래프 만들기
        for (int i = 0; i < M; i++) {
            Scanner connect = new Scanner(System.in);
            Integer firstConn = Integer.parseInt(connect.next());
            Integer secondConn = Integer.parseInt(connect.next());
            ArrayList<Integer> conn1 = graph.get(firstConn);
            conn1.add(secondConn);
            ArrayList<Integer> conn2 = graph.get(secondConn);
            conn2.add(firstConn);
        }
        for (int i = 1; i < checks.length; i++) {
            if (checks[i] == false) {
                result++;
                DFS(i);
            }
        }
        System.out.println(result);
    }

    private static void DFS(int v) {
        if (checks[v]) return;
        checks[v] = true;
        for (Integer i : graph.get(v)) {
            if (!checks[i]) DFS(i);
        }
    }
}
