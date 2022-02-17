# [42587] 프린터 - JAVA

## :black_circle: Algorithm
**Queue**

## :black_circle: Logic

- `중요도`가 높은 문서를 먼저 인쇄하는 프린트
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
- 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 **location** 이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 찾기

> _Key Idea_
> - 중요도와 처음 위치의 인덱스 값을 가진 `class Paper` 생성
> - `Queue` 를 만들어 모두 삽입한 후
> - 하나씩 꺼내어 큐에 남은 `Paper` 들 중 자신의 우선순위 보다 높은 `Paper` 가 있는지 찾기
> - 만약 자신의 우선순위보다 큰 `Paper` 가 있다면 꺼내었던 `Paper` 를 다시 `Queue` 에 삽입
> - 위를 반복하다가 자신의 문서(`location`)인 `Paper` 를 찾는다면 이때 까지 꺼낸수를 답에 넣는다


```Java
public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Paper> queue = initQueue(priorities);

    while (!queue.isEmpty()) {
        Paper first = queue.poll();
        if (!isMostImportant(queue, first)){
            queue.add(first);
            continue;
        }
        answer++;
        if(first.isMyPaper(location))
            break;
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
        int result = solution.solution(new int[]{2, 1, 3, 2}, 2);
        assertEquals(1, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        assertEquals(5, result);
    }
}
```

## :black_circle: Review
이전과 같이 `Queue` 를 사용하여 쉽게 풀 수 있는 문제
