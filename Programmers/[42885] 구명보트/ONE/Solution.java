import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int head = 0;
        int tail = people.length - 1;

        Arrays.sort(people);

        while(head <= tail){
            if(people[head] + people[tail] <= limit){
                head++;
            }
            tail--;
            answer++;
        }

        return answer;
    }
}