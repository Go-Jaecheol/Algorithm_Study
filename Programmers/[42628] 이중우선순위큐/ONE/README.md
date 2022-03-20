# [42628] 이중우선순위큐 - JAVA

## :black_circle: Algorithm
**Queue**

## :black_circle: Logic

- I 숫자	큐에 `주어진 숫자`를 **삽입**합니다  
- D 1	큐에서 `최댓값`을 **삭제**합니다  
- D -1	큐에서 `최솟값`을 **삭제**합니다
- 이중 우선순위 큐가 할 연산 `operations`가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 `[0,0]` 비어있지 않으면 `[최댓값, 최솟값]`을 구하기

> _Key Idea_
> - *오름차순*으로 정렬이 되는 우선순위큐와 *내림차순*으로 정렬이 되는 우선순위큐 각각 1개씩을 사용합니다
> - 삽입할 때에는 두 곳에 모두 삽입을 해줍니다
> - 큐에서 `최댓값`을 삭제할 때에는 내림차순 우선순위큐에서 제일 앞의 값을 꺼내고 오름차순 큐에서 해당 값을 `remove()` 해줍니다
> - 큐에서 `최솟값`을 삭제하는 것은 위의 방법의 반대로 진행합니다

```Java
PriorityQueue<Integer> increase = new PriorityQueue<>((o1, o2) -> o1 - o2);
PriorityQueue<Integer> decrease = new PriorityQueue<>((o1, o2) -> o2 - o1);

for (String operation : operations) {
    String[] tokens = operation.split(" ");

    switch (tokens[0]) {
        case "I" :
            insert(increase, decrease, tokens[1]);
            break;
        case "D" :
            delete(increase, decrease, tokens[1]);
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
        int[] result = solution.solution(new String[]{"I 16","D 1"});
        assertArrayEquals(new int[]{0,0}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(new String[]{"I 7","I 5","I -5","D -1"});
        assertArrayEquals(new int[]{7,5}, result);
    }
}
```

## :black_circle: Review
우선순위큐를 2개 사용해서 풀 수 있었던 쉬운 문제  
SKT 코딩 테스트 2차를 쳤는데 벽을 느꼈다...  
알고리즘은 꾸준히 풀어야 실력이 느니까 매일 1개씩 푸는 습관을 들이자
