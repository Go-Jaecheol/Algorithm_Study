# [42884] 단속카메라 - JAVA

## :black_circle: Algorithm
**Greedy**

## :black_circle: Logic

- 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한번은 만나도록 카메라를 설치
- 차량의 경로가 주어질 때, **최소의 카메라 설치**

> _Key Idea_
> - 차량의 경로들을 진입한 지점의 오름차순으로 정렬
> - 진입한 지점이 같다면 나간지점을 오름차순으로 정렬
> - 정렬하여 우선순위 큐에 삽입
> - 큐에서 하나씩 꺼내서
>   - 만약 다음 경로와 겹치는 부분이 있다면
>     - 현재 경로와 다음경로의 겹치는 부분으로 새로운 경로를 만들고
>     - 새로운 경로와 그 다음경로를 비교해 나간다
>   - 만약 다음 경로와 겹치는 부분이 없다면
>     - 큐에서 꺼냈던 다음 경로를 다시 큐에 넣어주고
>     - answer++ 해주며 새로운 현재 경로를 큐에서 꺼내는 것을 반복


```Java
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(int[] route : routes)
            queue.add(new Node(route[0], route[1]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            while (!queue.isEmpty()) {
                Node next = queue.poll();
                if (isOverlap(current, next)){
                    current = overlapNode(current, next);
                    continue;
                }
                queue.add(next);
                break;
            }
            answer++;
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
        int result = solution.solution(new int[][]{{-20,-15},{-14,-5},{-18,-13},{-5,-3}});
        assertEquals(2, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new int[][]{{-2,-1},{1,2},{-3,-0}});
        assertEquals(2, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(new int[][]{{0,0},});
        assertEquals(1, result);
    }

    @Test
    public void solution_4(){
        int result = solution.solution(new int[][]{{0,1},{0,1},{1,2}});
        assertEquals(1, result);
    }

    @Test
    public void solution_5(){
        int result = solution.solution(new int[][]{{-20,15},{-14,-5},{-18,-13},{-5,-3}});
        assertEquals(2, result);
    }

    @Test
    public void solution_6(){
        int result = solution.solution(new int[][]{{-20,-15},{-20,15},{-14,-5},{-18,-13},{-5,-3}});
        assertEquals(2, result);
    }
}

```

## :black_circle: Review
처음에 생각을 잘못해서 막혀가지고 오래 걸렸던 문제  
겹치는 부분의 아이디어를 생각하고 나서는 금방 풀 수 있었다