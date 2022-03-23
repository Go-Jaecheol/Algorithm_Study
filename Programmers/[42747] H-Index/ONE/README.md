# [42747] H-index - JAVA

## :black_circle: Algorithm
**Sorting**

## :black_circle: Logic

- 논문 `n`편 중, `h`번 이상 인용된 논문이 `h`편 이상이고 나머지 논문이 `h`번 이하 인용되었다면 `h`의 최댓값 구하기

> _Key Idea_
> - 배열을 `내림차순`으로 정렬한 후, `인덱스`보다 해당 `인덱스의 배열값`이 *크거나 같은 인덱스*중 **최댓값**을 구하면 된다

### Test Code

```Java
public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int result = solution.solution(new int[]{3, 0, 6, 1, 5});
        assertEquals(3, result);
    }
}
```

## :black_circle: Review
생각한것만큼 어렵지는 않았던 문제
