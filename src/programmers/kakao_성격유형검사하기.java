package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class kakao_성격유형검사하기 {
    static Map<String, Integer> result = new HashMap<>();
    static String answer = "";

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};


        result.put("R", 0);
        result.put("T", 0);
        result.put("C", 0);
        result.put("F", 0);
        result.put("J", 0);
        result.put("M", 0);
        result.put("A", 0);
        result.put("N", 0);

        for (int i = 0; i < survey.length; i++) {
            String category = survey[i];
            int choice = choices[i];
            String first = String.valueOf(category.charAt(0));// A
            String second = String.valueOf(category.charAt(1));// N
            if (choice < 4) {
                Integer val = result.get(first);
                result.put(first, val + (4 - choice));
            } else if (choice > 4) {
                Integer val = result.get(second);
                result.put(second, val + choice - 4);
            }
        }
        check("R", "T");
        check("C", "F");
        check("J", "M");
        check("A", "N");
        System.out.println(answer);
    }

    static void check(String first, String second){
        if(result.get(first) < result.get(second)){
            answer+=second;
        } else if (result.get(first) > result.get(second)) {
            answer+=first;
        } else if (result.get(first) == result.get(second)) {
            answer+=first;
        }
    }
}
