# [42861] 섬 연결하기 - JAVA

## :black_circle: Algorithm
**Kruskal**

## :black_circle: Logic

- n 개의 섬에 다리를 건설
- 건설하는 비용이 주어질때 최소의 비용으로 모든 섬이 통행 가능하도록
- 다리를 여러번 건너도 도달할 수 있으면 통행가능

> _Key Idea_
> - 부모노드는 처음 자기 자신으로 초기화
> - 비용을 기준으로 오름차순 정렬하며 Node 들을 우선순위 큐에 삽입
> - 큐에서 하나씩 꺼내면서 만약 부모가 다르다면
> - 다리를 이어주며 비용을 답에 더하고
> - 서로의 부모를 같게 만들어준다 (union)

```Java
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = initParent(n);
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(int[] node: costs)
            queue.add(new Node(node[0], node[1], node[2]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if(find(current.u, parent) != find(current.v, parent)){
                union(current.u, current.v, parent);
                answer += current.w;
            }
        }

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
        int result = solution.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
        assertEquals(4, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(5, new int[][]{{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4},{2,4,6},{4,0,7}});
        assertEquals(15, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(5, new int[][]{{0,1,1},{3,4,1},{1,2,2},{2,3,4}});
        assertEquals(8, result);
    }

    @Test
    public void solution_4(){
        int result = solution.solution(4, new int[][]{{0,1,5},{1,2,3},{2,3,3},{1,3,2},{0,3,4}});
        assertEquals(9, result);
    }
}

```

## :black_circle: Review
크루스칼 알고리즘을 이용해 풀수있는 간단한 문제...이지만  
union 에서 변수를 잘못넣어서 1시간 정도 헤맨문제...
