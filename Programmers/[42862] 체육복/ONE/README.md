# [42862] 체육복 - JAVA

## :black_circle: Algorithm
**Greedy**

## :black_circle: Logic

- 번호는 체격순 (1 ~ N)
- 바로 앞 or 바로 뒤 만 빌려주기 가능
- 여벌이 있는 학생만 체육복을 도난당한(체육복이 없는) 학생에게 빌려주기 가능
- 여벌이 있는 학생도 도난을 당할 수 있고, 이때는 여벌이 없어져 다른 학생에게 빌려줄 수 없음
- 체육수업을 들을 수 있는 학생의 **최댓값** 구하기


> _Key Idea_
> - 3가지의 상태로 학생들을 구분함
>   - -1 : 체육복을 도난당해 없는 상태
>   - 0 : 체육복을 본인의 것만 가지고 있는 상태 (여별 X)
>   - 1 : 체육복을 여벌로 가지고 있는 상태 (2개)  
> - 학생 수와 같은 int 배열을 생성 (체육복의 수를 나타냄, 처음엔 모두 0)
> - _reserve_ 에 있는 번호들에 해당하는 학생들의 체육복수를 1 증가
> - _lost_ 에 있는 번호들에 해당하는 학생들의 체육복수를 1 감소
> - 체육복이 없는 학생들의 앞, 뒤를 조사하여 앞 또는 뒤에 체육복이 여벌로 있는 학생이 있다면 빌림
> - 체육복이 없는 학생들을 제외한 학생들의 수가 결과

```Java
    public int solution(int n, int[] lost, int[] reserve){
        int answer = 0;
        int[] students = new int[n + 1];

        reserveStd(students, reserve);
        lostStd(students, lost);
        borrow(n, students);

        answer = countResult(n, students);

        return answer;
    }
```

### Test Code

```Java
public class SolutionTest {
    Solution sol;

    @BeforeEach
    public void setSol(){
        sol = new Solution();
    }

    @Test
    public void solution_1(){
        assertEquals(5, sol.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    @Test
    public void solution_2(){
        assertEquals(4, sol.solution(5, new int[]{2, 4}, new int[]{3}));
    }

    @Test
    public void solution_3(){
        assertEquals(2, sol.solution(3, new int[]{3}, new int[]{1}));
    }
}
```

## :black_circle: Review
이번 알고리즘 문제부터, 코드를 작성할 때, **"자바 웹프로그래밍 Next Step"** 에서 공부한  
리팩토링을 위한 **3가지의 원칙** 을 지키며 코드를 작성하려 한다.  
테스트코드 작성도 같이 진행하며 연습할 예정이고,  
이번 문제는 간단한 문제라 테스트코드로 검사할 부분이 없었던 것 같다.  
_보기좋은 코드 만들기 1일차._
