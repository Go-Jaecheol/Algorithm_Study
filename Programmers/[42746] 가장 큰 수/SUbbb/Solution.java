import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                return (obj2 + obj1).compareTo(obj1 + obj2);
            }
        });

        if (strNumbers[0].equals("0")) {
            answer = "0";
        } else {
            for (String strNumber : strNumbers) {
                answer += strNumber;
            }
        }

        return answer;
    }
}