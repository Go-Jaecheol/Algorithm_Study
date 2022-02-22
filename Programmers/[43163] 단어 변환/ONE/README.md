# [43163] 단어 변환 - JAVA

## :black_circle: Algorithm
**DFS**

## :black_circle: Logic

- 두 개의 단어 `begin`, `target`과 단어의 집합 `words`가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 `begin`을 `target`으로 변환할 수 있는지 찾기
- `begin`과 `target`은 같지 않습니다

> _Key Idea_
> - 단어 2개를 비교하여 1개만 차이나는지 확인하는 함수를 구현 `isChangedOneAlpha`
> - 시작단어에서 하나씩 다 비교를하며 `DFS`를 하는데
>   - 1번 단어 -> 2번단어 & 2번단어 -> 1번단어 와 같은 `중복 계산`이 되어 시간초과가 납니다
>   - 그래서 `visted` 배열을 전역이 아닌 파라미터로 전달하여 중복검사를 제외합니다

```Java
    public int solution(String begin, String target, String[] words) {
        int answer = words.length + 1;

        for (int i = 0; i < words.length; i++) {
            boolean[] visited = new boolean[words.length];
            if(isChangedOneAlpha(begin, words[i]))
                answer = Math.min(answer, DFS(words[i], target, words, i, visited, 1));
        }

        if(answer == words.length + 1)
            return 0;

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
        int result = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        assertEquals(4, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        assertEquals(0, result);
    }
}
```

## :black_circle: Review
처음에 구현할때 `visited` 를 전역변수로 두고  
`DFS` 탐색을 했었는데 시간초과가 났다  
그래서 `visited` 를 파라미터로 전달하여 중복검사를 제외하였다  
시간이 좀 걸린문제!