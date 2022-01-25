# [42576] 완주하지 못한 선수 - JAVA

## :black_circle: Algorithm
**Hash**

## :black_circle: Logic

- 마라톤 참가자 명단중 완주자를 제외한 **단 한명의 사람 찾기**
- 참가자의 사람수와 완주자의 사람수는 **1명 차이**

> _Key Idea_
- 참가자 명단에 있는 모든 사람의 이름을 *key* 로,
- _value_ 를 1로 가지는 Hashmap 생성
  - 이 때, 동명이인이 있을 수 있기 때문에, map.getOrDefault()를 사용하여
  - 이미 키값이 존재하면 +1 을 해준다 
- completion 배열에 있는 사람들의 이름으로 map 에 value 값을 1씩 줄여준다
- map 에서 value 값이 1인 사람을 찾아 이름을 리턴해준다


```Java
    public String solution(String[] participant, String[] completion) {
        String answer;
        HashMap<String, Integer> map = initMap(participant);
        removeCompletion(map, completion);
        answer = findUnfinished(map);

        return answer;
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
        String result = solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        assertEquals("leo", result);
    }

    @Test
    public void solution_2(){
        String result = solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        assertEquals("vinko", result);
    }

    @Test
    public void solution_3(){
        String result = solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        assertEquals("mislav", result);
    }
}

```

## :black_circle: Review
hash 를 잘몰라서 공부를 좀 더 해서 푼 문제
난이도 자체는 굉장히 쉬웠던 것 같다.