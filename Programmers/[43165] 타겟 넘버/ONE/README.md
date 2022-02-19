# [43165] 타겟 넘버 - JAVA

## :black_circle: Algorithm
**DFS**

## :black_circle: Logic

- n개의 **음이 아닌 정수**들을 순서를 바꾸지 않고 적절히 더하거나 빼서 *타겟 넘버*를 만들려고 합니다

> _Key Idea_
> - `DFS` 를 이용하는데 덧셈으로 한번, 뺄셈으로 한번으로 총 두번의 재귀호출을 해줍니다
> - 타겟 넘버와 같다면 개수를 카운트해줍니다

```Java
    private void DFS(int[] numbers, int target, int depth, int result) {
        if (depth == numbers.length) {
            if (result == target)
                answer++;
            return;
        }

        DFS(numbers, target, depth + 1, result + numbers[depth]);
        DFS(numbers, target, depth + 1, result - numbers[depth]);
    }
```

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
        int result = solution.solution(new int[]{1, 1, 1, 1, 1}, 3);
        assertEquals(5, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new int[]{4, 1, 2, 1}, 4);
        assertEquals(2, result);
    }
}
```

## :black_circle: Review
`DFS` 를 사용하여 풀수있었던 쉬운 문제
