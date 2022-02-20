# [43162] 네트워크 - JAVA

## :black_circle: Algorithm
**DFS**

## :black_circle: Logic

- 컴퓨터의 개수 `n`, 연결에 대한 정보가 담긴 2차원 배열 `computers`가 매개변수로 주어질 때, 네트워크의 개수 찾기

> _Key Idea_
> - `union-find` 를 이용해 구현
> - 전체를 검사하여 1인값이 있으면 `union` 합니다
> - 하지만 최종 parent 배열에서 각 노드가 루트노드를 가리키지 않는 반례도 있는 것 같아
> - for 문 돌려서 각 노드마다 `find` 값을 대입해줍니다
> - 그리고 다른 네트워크의 개수를 세기 위해 `Hashmap` 을 이용하여 `size` 를 구합니다

```Java
    public int solution(int n, int[][] computers) {
        parent = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(j != i && computers[i][j] == 1)
                    union(i, j);

        for(int i = 0; i < n; i++)
            parent[i] = find(i);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : parent)
            map.put(key, map.getOrDefault(key, 0) + 1);

        return map.size();
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
        int result = solution.solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}});
        assertEquals(2, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}});
        assertEquals(1, result);
    }
}


```

## :black_circle: Review
`union-find` 방식으로 진행하다가 막혀서 질문하기에서 찾아봤는데 위와 같은 반례가 있는 것 같아 코드를 수정했다  
코드 통과 후 다른사람의 풀이를 찾아봤는데 DFS 가 동작한 횟수를 구하는 방법이 있었고 되게 좋은 방식이라 생각했다.
