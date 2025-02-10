package programmers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;

public class kakao_개인정보수집유효기간 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] answer = {};

        answer = new int[privacies.length];
        int num = 0;
        LocalDate todayDate = LocalDate.of(Integer.parseInt(today.substring(0, 4)), Integer.parseInt(today.substring(5, 7)), Integer.parseInt(today.substring(8)));
        HashMap termMap = new HashMap<>();
        for(int i = 0; i<terms.length; i++){
            termMap.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }

        for(int i = 0; i<privacies.length; i++){
            String start = privacies[i];
            LocalDate startDate = LocalDate.of(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5, 7)), Integer.parseInt(start.substring(8,10)));
            String term = start.split(" ")[1];
            int plusMonth = Integer.parseInt(String.valueOf(termMap.get(term)));
            LocalDate expireDate = startDate.plusMonths(plusMonth);
            if(todayDate.isAfter(expireDate) || todayDate.isEqual(expireDate)) {
                answer[num] = i+1;
                num++;
            }
        }
        int[] ans = Arrays.copyOfRange(answer, 0, num);

    }
}
