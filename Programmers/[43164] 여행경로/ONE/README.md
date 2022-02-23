# [43164] 여행경로 - JAVA

## :black_circle: Algorithm
**DFS**

## :black_circle: Logic

- **주어진 항공권을 모두 이용**하여 여행경로를 짜려고 하고, 항상 "ICN" 공항에서 출발합니다.
- 모든 도시를 방문할 수 없는 경우는 주어지지 않음

> _Key Idea_
- 항공권의 출발지와 도착지를 담는 `Ticket class` 생성
  - 출발지가 "ICN" 인지 검사하는 메소드
  - 현재 항공권의 도착지와 다음 항공권의 출발지가 같은지 검사하는 메소드
- `Ticket` 리스트를 만들어 "ICN"이 출발지인 항공권을 찾아 DFS 실행
- 가능한 경로가 여러개 나왔을경우 compareTo()를 이용하여 단어의 사전적 순서로 구분하여 알파벳 순서가 앞서는 경로를 선택합니다

```Java
    public String[] solution(String[][] tickets) {
        ArrayList<Ticket> list = new ArrayList<>();

        for(String[] ticket : tickets)
            list.add(new Ticket(ticket[0], ticket[1]));

        answer = new String[list.size() + 1];

        for (int i = 0; i < list.size(); i++)
            if(list.get(i).isICNDept()){
                boolean[] visited = new boolean[list.size()];
                String[] newAnswer = new String[list.size() + 1];
                DFS(newAnswer, list, i, 0, visited);
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
        String[] result = solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"}, result);
    }

    @Test
    public void solution_2(){
        String[] result = solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
        assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}, result);
    }

    @Test
    public void solution_3(){
        String[] result = solution.solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}});
        assertArrayEquals(new String[]{"ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"}, result);
    }
}
```

## :black_circle: Review
금방 풀줄 알았는데 compareTo() 부분에서 헷갈려서 좀 걸렸던 문제  
생각할 경우의 수가 좀 있었던 것 같다
