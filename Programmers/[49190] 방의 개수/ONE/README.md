# [49190] 방의 개수 - JAVA

## :black_circle: Algorithm
**Graph**

## :black_circle: Logic

- 이동하는 방향이 담긴 배열 arrows가 매개변수로 주어질 때, 방의 갯수 구하기

> _Key Idea_
> - 방문했던 `Point`를 재방문하면 방이 생성된다
> - 기존에 통과한 간선을 재 통과하는 경우에는 재방문해도 방이 생성되지 않는다
> - 간선끼리의 `단위가 작은 X 교차` 경우를 위해 반복문을 이용해 스케일업 해준다

```Java
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Point newPoint = new Point(origin.x + dx[arrow], origin.y + dy[arrow]);

                if (!visited.containsKey(newPoint)) {
                    visited.put(newPoint, makeList(origin));

                    if (visited.get(origin) == null)
                        visited.put(origin, makeList(newPoint));

                    else
                        visited.get(origin).add(newPoint);
                }
                else if (visited.containsKey(newPoint) &&
                        !(visited.get(newPoint).contains(origin))) {

                    visited.get(newPoint).add(origin);
                    visited.get(origin).add(newPoint);
                    answer++;
                }
                origin = newPoint;
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
        int result = solution.solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0});
        assertEquals(3, result);
    }
}
```

## :black_circle: Review
방문했던 정점을 다시 방문하는 경우만 계속 구하다가  
모르겠어서 질문과 블로그를 참고하여 X 교차하는 경우를 찾아 풀었던 문제  
최근 푼 문제중에 제일 어려웠던 것 같고 `HashMap`을 사용하기 위해  
`method`를 오버라이딩해서 풀었던 첫문제인데 나중에도 기억해서 활용할 수 있을 것 같다
