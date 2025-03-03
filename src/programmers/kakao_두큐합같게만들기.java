package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class kakao_두큐합같게만들기 {
    static int answer = 0;
    static long total = 0;
    static long queue1Total = 0;
    static long queue2Total = 0;

    public static void main(String[] args) {
        int queue1[] = {1, 1};
        int queue2[] = {1, 5};
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.add((long) queue1[i]);
            queue1Total += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.add((long) queue2[i]);
            queue2Total += queue2[i];
        }
        total = queue1Total + queue2Total;
        if(total % 2 != 0) {
            System.out.println(-1);
            return;
        }
        total /= 2;
        System.out.println(total);
        System.out.println(queue1Total);
        System.out.println(queue2Total);


        while (answer<4*queue1.length) {
            if (queue1Total > queue2Total) {
                Long poll = q1.poll();
                q2.add(poll);
                queue1Total -= poll;
                queue2Total += poll;
                answer++;
            } else if (queue1Total < queue2Total) {
                Long poll = q2.poll();
                q1.add(poll);
                queue1Total += poll;
                queue2Total -= poll;
                answer++;
            } else if (queue1Total == queue2Total) {
                System.out.println(answer);
            }
        }
        System.out.println(-1);
    }
}
