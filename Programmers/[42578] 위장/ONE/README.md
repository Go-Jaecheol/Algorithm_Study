# [42578] 위장 - JAVA

## :black_circle: Algorithm
**Hash**

## :black_circle: Logic

- 매일 다른 옷을 조합하여 자신을 위장
- 같은 이름을 가진 의상은 존재 X
- 모든 원소는 문자열로 이루어짐
- 하루에 최소 한개의 의상은 입습니다

> _Key Idea_
> - 옷종류를 키값으로 **Hashmap** 을 생성
> - 중복되는 옷종류가 있을 수도 있기 때문에
> - map.getOrDefault() 를 사용하여
> - 이미 키값이 존재한다면 +1 만해준다
> - 그 후 옷종류 마다 각 옷들을 입고 & 안입고 + 아무것도 안입는 경우(+1)를 답에 곱한다
> - 최소 옷 1개는 입어야 하기때문에 모든 옷을 입지않는경우(-1)를 빼준다

```Java
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);

        Set<String> keySet = map.keySet();

        for(String key : keySet)
            answer *= map.get(key) + 1;

        return answer - 1;
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
        int result = solution.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        assertEquals(5, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}});
        assertEquals(3, result);
    }
}

```

## :black_circle: Review
`완주하지 못한 선수` 와 굉장히 유사한 문제  
경우의 수만 생각하여 풀면 됐다.