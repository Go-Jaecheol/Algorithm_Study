public class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);

        for(int i = 0; i < k; i++){
            int idx = answer.length() - 1;
            for(int j = 0; j < idx; j++)
                if(answer.charAt(j) < answer.charAt(j + 1)){
                    idx = j;
                    break;
                }
            answer.deleteCharAt(idx);
        }

        return answer.toString();
    }
}
