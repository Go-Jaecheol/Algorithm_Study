# [42583] 다리를 지나는 트럭 - JAVA

## :black_circle: Algorithm
**Queue**

## :black_circle: Logic

- 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다
- 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 구하기
- 다리에는 트럭이 최대 `bridge_length` 대 올라갈 수 있으며, 다리는 `weight` 이하까지의 무게를 견딜 수 있습니다

> _Key Idea_
- 다리의 상태를 나타내는 `int[] bridge` 생성
- `Queue` 를 생성하여 모든 트럭의 무게를 삽입합니다
- 맨 처음 `Queue` 의 **가장 앞에 있는 값**을 다리에 넣습니다
- bridge 의 트럭들을 **앞으로 한칸씩 이동**시킵니다
- `Queue` 의 맨 앞의 트럭의 무게와 `bridge` 에 있는 트럭들의 무게를 모두 더한 값이 `weight` 를 넘지 않으면 큐에서 꺼내 `bridge[0]` 에 넣어줍니다
- 위를 _다리가 모두 비워질때까지_ 반복합니다

```Java
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] bridge = new int[bridge_length];
        Queue<Integer> queue = new LinkedList<>();

        for (int truck : truck_weights)
            queue.add(truck);

        int headTruck = queue.poll();
        bridge[0] = headTruck;
        answer++;

        while (!isBridgeEmpty(bridge)) {
            moveTrucks(bridge);
            if(!queue.isEmpty()) {
                headTruck = queue.peek();
                if (!isOverWeight(sumOfBridge(bridge) + headTruck, weight)){
                    headTruck = queue.poll();
                    bridge[0] = headTruck;
                }
            }
            answer++;
        }

        return answer;
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
        int result = solution.solution(2, 10, new int[]{7, 4, 5, 6});
        assertEquals(8, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(100, 100, new int[]{10});
        assertEquals(101, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        assertEquals(110, result);
    }
}
```

## :black_circle: Review
금방 풀 수 있었던 쉬운 문제였다