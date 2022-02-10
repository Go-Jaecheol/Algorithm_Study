# [42839] 소수 찾기 - JAVA

## :black_circle: Algorithm
**DFS**, **순열**

## :black_circle: Logic

- 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는가?
- "11" 과 "011" 은 같은 수로 취급

> _Key Idea_
> - `소수를 만드는 부분` 과 `소수를 판별하는 부분` 두가지로 나누어 생각
> - 소수를 만드는 부분에서는 DFS 와 check 배열을 활용하여 순열을 구현해 문자열을 만든다
> - 소수를 판별하는 부분에서는 만들어진 문자열을 숫자로 변환하여 소수를 판별한다

```Java
    private ArrayList<Integer> answer = new ArrayList<>();
    private boolean[] check;
    public int solution(String numbers) {
        int length = numbers.length();
        char[] numAry = initAry(numbers);
        check = new boolean[length];

        make(numAry, length, "");

        return answer.size();
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
        int result = solution.solution("17");
        assertEquals(3, result);
    }

    @Test
    public void solution_2(){
        int result = solution.solution("011");
        assertEquals(2, result);
    }
}
```

## :black_circle: Review
풀이 방법이 바로 생각나서 바로 구현했던 문제