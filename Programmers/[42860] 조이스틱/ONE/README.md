# [42860] 조이스틱 - JAVA

## :black_circle: Algorithm
**Greedy**

## :black_circle: Logic

- ▲ - 다음 알파벳
- ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
- ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
- ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
- 처음에는 모든 알파벳이 'A'로 되어있음
- 조이스틱 조작의 **최소이동**


> _Key Idea_
> - 세로 Count 와 가로 Count를 분리
> - 세로는 알파벳 'N' 을 기준으로 'B' ~ 'N' 까지는 1~13으로 증가
> - 그리고 'O' ~ 'Z' 는 12 ~ 1로 감소하는 형태
> - 가로이동은 'A' 의 존재가 관건
> - 일단 처음 시작에서 오른쪽으로 이동한다는 전제를 두고 (moveCnt = len - 1)
> - 하나씩 이동하며 다음에 'A' 가 있으면
>   - 오른쪽으로 그대로 진행하여 'A' 가 끝나는 부분에 도달
>   - 왼쪽으로 역행해서 'A' 가 끝나는 부분에 도달
> - i + len - next : 왼쪽으로 역행했을때 'A' 가 끝나는 부분에 도달하는데 까지 걸리는 거리
> - min(i, len-next) : 다음에 나오는 'A' 가 아닌 위치에서 왼쪽으로 i 까지 오는 거리와 우측으로 그대로 진행하는 거리를 비교
> - 오른쪽으로 그대로 진행하는 것과 왼쪽으로 역행하는것 중 최솟값을 구한다

```Java
public int solution(String name) {
    int answer = 0;

    answer += upDown(name);
    answer += leftRight(name);

    return answer;
}

private int upDown(String name){
    int sum = 0;
    for(int i = 0; i < name.length(); i++)
        sum += verticalCount(name.charAt(i));
    return sum;
}

private int leftRight(String name) {
    int len = name.length();
    int moveCnt = len - 1;

    for (int i = 0; i < len; i++) {
        int next = i + 1;

        while (next < len && isA(name.charAt(next)))
            next++;

        moveCnt = Math.min(moveCnt, i + len - next + Math.min(i, len - next));
    }
    return moveCnt;
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
        int result = solution.solution("ABAAAAABB");
        Assertions.assertEquals(solution.solution("ABBAAAAAB"), result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution("JAN");
        Assertions.assertEquals(23, result);
    }
}
```

## :black_circle: Review
세로와 가로를 분리하여 생각하는거까지는 금방 도달했는데,  
가로 이동에서 A의 여부를 확인하여 좌우판단하는 과정이 굉장히 어려웠던것 같다.  
많은 시간이 걸렸던 문제
