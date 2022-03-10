# [42627] 디스크 컨트롤러 - JAVA

## :black_circle: Algorithm
**Queue**

## :black_circle: Logic

- 각 작업에 대해 ***작업이 요청되는 시점, 작업의 소요시간***을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 구하기

> _Key Idea_
> - 요청시간이 빠른 순서로 정렬하여 작업을 대기하는 `readyQueue`
> - 작업시간이 적은 순서로 정렬하여 작업을 수행하는 `runQueue`
> - `readyQueue`에서 현재 시간에서 수행이 가능한 **Task**들을 `runQueue`에 넣는다
> - `runQueue`에서 총소요시간과 **Task** 개수를 세고, 현재시간에 작업시간을 더해준다
> - 만약 작업할 **Task**가 없다면 시간만 1 올려준다

```Java
    public int solution(int[][] jobs) {
        int time = 0;
        int count = 0;
        int sum = 0;

        PriorityQueue<Task> readyQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.requestTime));

        for (int[] job : jobs)
            readyQueue.add(new Task(job[0], job[1]));

        PriorityQueue<Task> runQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.runTime));

        while (count < jobs.length) {
            while (!readyQueue.isEmpty() && time >= readyQueue.peek().requestTime)
                runQueue.add(readyQueue.poll());

            if(!runQueue.isEmpty()){
                Task current = runQueue.poll();
                sum += current.runTime + (time - current.requestTime);
                time += current.runTime;
                count++;
            }
            else
                time++;
        }
        return sum / count;
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
        int result = solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        assertEquals(9, result);
    }
}
```

## :black_circle: Review
알고리즘이 도저히 생각이 안나 질문의 도움을 받았다..  
계속 시간초과가 떠서 내 코드로 계속해봤는데 생각보다 단순하게 풀 수 있어서 허무했던것 같다
