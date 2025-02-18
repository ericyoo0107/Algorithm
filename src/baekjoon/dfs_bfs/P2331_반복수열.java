package baekjoon.dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2331_반복수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int P = scanner.nextInt();
        List<Integer> D_list = new ArrayList<>();
        D_list.add(A);
        while (true){
            int target = A;
            A=0;
            while (true){
                A += Math.pow((target%10), P);
                target/=10;
                if(target == 0) break;
            }
            if(D_list.indexOf(A) != -1) break;
            D_list.add(A);
        }
        int result = D_list.indexOf(A);
        System.out.println(result);
    }
}
