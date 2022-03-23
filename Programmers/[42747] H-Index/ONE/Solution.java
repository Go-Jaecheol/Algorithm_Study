import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] array = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(array, Collections.reverseOrder());

        for (int i = 0; i < array.length; i++)
            if(array[i] >= i + 1)
                answer = Integer.max(answer, i + 1);

        return answer;
    }
}