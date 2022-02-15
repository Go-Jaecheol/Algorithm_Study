# [42842] 카펫 - JAVA

## :black_circle: Algorithm
**완전 탐색**

## :black_circle: Logic

- 갈색 격자수는 노란색 격자의 테두리를 둘러싼 모습
- 갈색 격자 수와 노란색 격자 수가 주어졌을 때 전체 카펫의 가로 세로 길이 구하기

> _Key Idea_
> - brown 의 가로값을 3부터 증가시키며
> - 전체격자수를 brown의 가로값으로 나누었을때 딱 떨어지고
> - yellow 의 가로 세로는 brown 의 가로세로보다 각각 2씩 작기 때문에
> - 이를 이용해 yellow 의 값과 가로세로를 곱한 값을 비교

```Java
private void solving(int brown, int yellow, int[] answer) {
    int sum = brown + yellow;

    for (int i = 3; i <= sum; i++) {
        if(sum % i != 0)
            continue;
        if (i >= sum / i && isYellowRight(i, brown, yellow)) {
            answer[0] = i;
            answer[1] = sum / i;
            return;
        }
    }
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
        int[] result = solution.solution(10, 2);
        assertArrayEquals(new int[]{4, 3}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(8, 1);
        assertArrayEquals(new int[]{3, 3}, result);
    }

    @Test
    public void solution_3(){
        int[] result = solution.solution(24, 24);
        assertArrayEquals(new int[]{8, 6}, result);
    }
}
```

## :black_circle: Review
쉬운문제였던 것같다