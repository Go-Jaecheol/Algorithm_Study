# [49191] 순위 - JAVA

## :black_circle: Algorithm
**Graph**

## :black_circle: Logic

- n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다
- 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다
- 정확하게 순위를 매길 수 있는 선수의 수 구하기

> _Key Idea_
- 그래프의 정보를 저장할 이차원 배열에 `matching[i][j]`
- **자기 자신이면(i == j)** `0`,
- **i가 j에게 이겼다면** `1`,
- **i가 j에게 졌다면** `-1`,
- **알수없는 값**은 `Integer.MAX_VALUE` 로 초기화 합니다
- 그래프를 순회하면서 `[i][k]` 와 `[k][j]` 가 둘다 1이면
- i는 j에게 무조건 승리하므로 `[i][j]` 값을 1로 설정하고
- `[j][i]` 의 값은 -1로 설정해 줍니다
- 그래서 한 행 또는 열에서 모든 경기결과를 알 수 있을 때 `(MAX_VALUE가 하나도 없을 때)`
- 선수의 수를 카운트하여 답을 구합니다

```Java
    public void graph(int[][] matching, int n) {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (matching[i][k] == 1 && matching[k][j] == 1){
                        matching[i][j] = 1;
                        matching[j][i] = -1;
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
        int result = solution.solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}});
        assertEquals(2, result);
    }
}
```

## :black_circle: Review
아이디어를 생각하는 것 자체는 오래 걸리지 않았지만  
코드로 구현해내는데에 좀 걸린것 같다