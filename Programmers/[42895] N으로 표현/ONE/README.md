# [42895] N으로 표현 - JAVA

## :black_circle: Algorithm
**DP**

## :black_circle: Logic

- 이처럼 숫자 `N`과 `number`가 주어질 때, `N`과 *사칙연산*만 사용해서 표현 할 수 있는 방법 중 `N 사용횟수의 최솟값` 찾기

> _Key Idea_
> - `DP` 를 사용하기 위해 1~8 인덱스까지의 `HashSet` 배열을 만듭니다
> - 먼저 `N` 이 `number` 과 같은 경우를 처리하여 `1`을 리턴해 줍니다
> - 그리고 2번째 인덱스 부터 이전의 인덱스의 `HashSet` 의 값들을 가지고 사칙연산을 진행하여 add 해줍니다
>   - 예를 들어 `[5]`의 값을 구하기 위해 `[1]-[4]`, `[2]-[3]`, `[3]-[2]`, `[4]-[1]` 의 값들을 각각 사칙연산하여 값을 저장해 줍니다
> - 여기서 각 `HashSet`에 맨처음 인덱스의 수만큼의 `N`들로 이루어진 수를 더해주고
> - 나누기 연산에서 `divide by zero` 를 생각하여 나누는 수가 0인 경우를 제외해 줍니다

```Java
    public int solution(int N, int number) {
        int answer = -1;

        if(N == number)
            return 1;

        Set<Integer>[] dp = new Set[9];

        for (int i = 0; i <= 8; i++)
            dp[i] = new HashSet<>();

        dp[1].add(N);

        for (int i = 2; i <= 8; i++){
            dp[i].add(makeNstr(N, i));

            for (int j = 1; j <= i - 1; j++)
                for(int k : dp[j])
                    for(int h : dp[i - j])
                        calculation(dp, i, k, h);


            if (dp[i].contains(number)) {
                answer = i;
                break;
            }
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
        int result = solution.solution(5,12);
        assertEquals(4, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution(2,11);
        assertEquals(3, result);
    }

    @Test
    public void solution_3(){
        int result = solution.solution(8,5800);
        assertEquals(8, result);
    }
}
```

## :black_circle: Review
생각은 빨리나서 구현까지도 쉽게 진행하였으나,  
사용된 메모리 용량과 걸린시간이 너무 커  
다른 사람들의 코드를 참고해 `HashSet`을 사용하여 시간과 용량을 크게 줄일 수 있었다