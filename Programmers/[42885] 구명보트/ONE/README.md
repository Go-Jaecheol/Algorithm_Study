# [42885] 구명보트 - JAVA

## :black_circle: Algorithm
**Greedy**

## :black_circle: Logic

- 최대 2명씩, 보트에 무게제한
- 구명보트를 최게한 적게 사용하여 모두를 구출
- 구명보트 개수의 최솟값 구하기

> _Key Idea_
> - 사람 몸무게 배열을 오름차순으로 정렬한다
> - 그래서 제일 적은 몸무게와 제일 많은 몸무게를 더하여
>  - limit 보다 작다면 보트 1개에 태운다
>  - limit 보다 크다면 제일 많은 몸무게 혼자 태우고 그 다음 몸무게 많은 사람으로 인덱스 이동
> - 위를 모든 사람을 태울때 까지 (head <= tail) 반복 다

```Java
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
```

### Test Code

```Java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int result = solution.solution(new int[]{70, 50, 80, 50}, 100);
        assertEquals(3, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new int[]{70, 80, 50}, 100);
        assertEquals(3, result);
    }
}

```

## :black_circle: Review
정렬만 해서 풀면 되는 쉬웠던 문제