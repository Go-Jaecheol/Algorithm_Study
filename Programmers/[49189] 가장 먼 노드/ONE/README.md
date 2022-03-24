# [49189] 가장 먼 노드 - JAVA

## :black_circle: Algorithm
**BFS**, **그래프**

## :black_circle: Logic

- 1번 노드로 부터 가장 멀리 떨어진 노드가 몇개인지 구하기

> _Key Idea_
> - 연결리스트를 이용해 양방향 그래프를 만듭니다
> - `한층씩` 이동하며 한층에 해당하는 개수를 세면 최종적으로 남는 개수가 답이 됩니다


```Java
        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int node : graph.get(cur)) {
                    if (!visited[node]) {
                        temp.add(node);
                        visited[node] = true;
                    }
                }
            }

            if (temp.isEmpty())
                break;
            queue.addAll(temp);
            cnt = temp.size();
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
        int result = solution.solution(6, new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}});
        assertEquals(3, result);
    }
}
```

## :black_circle: Review
옛날에 비슷한 문제를 풀었던 기억이 있어 쉽게 풀었던 것 같다
