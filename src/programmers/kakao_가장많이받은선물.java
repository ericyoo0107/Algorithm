package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class kakao_가장많이받은선물 {
    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        List<String> friendList = Arrays.stream(friends).collect(Collectors.toList());
        int friendCnt = friends.length;
        int giftLog [][] = new int[friendCnt][friendCnt];
        int giftPoint[] = new int [friendCnt];
        int answerList[] = new int[friendCnt];
        Arrays.fill(answerList, 0);

        // gift log 만들기
        for(int i = 0; i<gifts.length; i++){
            String give = gifts[i];
            String giver = give.split(" ")[0];
            String receiver = give.split(" ")[1];
            int giverId = friendList.indexOf(giver);
            int receiverId = friendList.indexOf(receiver);
            giftLog[giverId][receiverId]++;
        }

        // gift point 준거에 대해서 ++
        for(int i=0; i<friendCnt; i++){
            for(int j=0; j<friendCnt; j++){
                giftPoint[i]+=giftLog[i][j];
            }
        }

        // gift point 받은거에 대해서 --
        for(int i=0; i<friendCnt; i++){
            for(int j=0; j<friendCnt; j++){
                giftPoint[i]-=giftLog[j][i];
            }
        }

        for(int i=0; i<friends.length; i++){
            for(int j=0; j< friends.length; j++){
                if(i==j) continue;
                if(giftLog[i][j] > giftLog[j][i]) answerList[i]++;
                else if (giftLog[i][j] == giftLog[j][i]) {
                    if(giftPoint[i] > giftPoint[j]) answerList[i]++;
                }
            }
        }

        System.out.println(Arrays.stream(answerList).max().getAsInt());
    }
}
