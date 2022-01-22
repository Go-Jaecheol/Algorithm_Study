# [42883] 큰 수 만들기 - JAVA

## :black_circle: Algorithm
**Greedy**

## :black_circle: Logic

- 어떤 숫자에서 **k 개의 숫자를 제거** 했을 때 얻을 수 있는 **가장 큰 숫자**


> _Key Idea_
> - **왼쪽부터 적은값을 제거**해야 가장 큰 숫자를 얻을 수 있다 
> - 왼쪽부터 탐색하며 다음값보다 작은 값을 문자열에서 빼준다
> - 위를 *k 번 반복* 한다

```Java
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
        String result = solution.solution("1924", 2);
        assertEquals("94", result);
    }

    @Test
    public void solution_2(){
        String result = solution.solution("1231234", 3);
        assertEquals("3234", result);
    }

    @Test
    public void solution_3(){
        String result = solution.solution("4177252841", 4);
        assertEquals("775841", result);
    }
}
```

## :black_circle: Review
맨 처음 완전탐색으로 구현했다가 '0'의 존재를 몰라서 
오류와 시간초과가 났다. 생각한거 보다 조금 더 어려운 문제.