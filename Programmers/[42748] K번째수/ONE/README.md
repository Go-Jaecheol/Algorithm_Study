# [42748] K번째수 - JAVA

## :black_circle: Algorithm
**Sorting**

## :black_circle: Logic

- 배열 `array`의 `i`번째 숫자부터 `j`번째 숫자까지 자르고 정렬했을 때, `k`번째에 있는 수를 구하기

> _Key Idea_
> - `Arrays.copyOfRange` 를 이용해 `i`번째부터 `j`번째까지의 배열을 구합니다
> - `Arrays.sort` 를 이용해 배열을 오름차순으로 정렬하고 `k` 번째 인덱스의 값을 구합니다

```Java
    private int find(Command command, int[] array) {
        int[] subArray = Arrays.copyOfRange(array, command.i - 1, command.j);

        Arrays.sort(subArray);

        return subArray[command.k - 1];
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
        int[] result = solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}});
        assertArrayEquals(new int[]{5,6,3}, result);
    }
}
```

## :black_circle: Review
정렬해서 값만 구하면되는 쉬운문제
