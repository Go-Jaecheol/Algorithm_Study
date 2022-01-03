# [16637] 괄호 추가하기 - JAVA

## :black_circle: Algorithm
**Brute Force**, **DFS**, **Backtracking**

## :black_circle: Logic

- 길이가 N인 수식 (0 ~ 9, +, - , *), N은 홀수
- 왼쪽부터 순서대로 계산
- 괄호 사용 가능, **괄호 중첩은 X**
- 식에 괄호를 적절히 추가하여 결과의 최댓값 구하기


> ###Key Idea
> - 이전의 연산 결과를 순서대로 계산
> - 이전의 연산 결과를 오른쪽의 괄호된 연산과 계산
> - 위의 두가지 경우를 백트래킹을 이용해 구현

- 길이가 N 인 수식을 숫자와 연산자로 나누어 배열 2개로 입력
- 재귀를 이용하여 순서대로 연산을 수행
- 한번 전체 연산이 끝난 이후, **백트래킹**하면서, 오른쪽에 괄호를 칠수 있는경우,
- 즉, 다음 연산자가 있을 경우 오른쪽의 괄호친 연산을 먼저 수행한후 현재의 값과 연산을 진행한다
- 연산자의 인덱스가 사이즈가 됐다는 것은 연산이 끝까지 됐음을 의미하기 때문에 연산된 결과를 최댓값과 비교하여 초기화

```Java
    private static void DFS(int result, int oprIndex){
        if(oprIndex == oprList.size()){
            max = Math.max(max, result);
            return;
        }

        int calc = calculation(oprList.get(oprIndex), result, numList.get(oprIndex + 1));
        DFS(calc, oprIndex + 1);

        if(oprIndex + 1 < oprList.size()){
            calc = calculation(oprList.get(oprIndex + 1), numList.get(oprIndex + 1), numList.get(oprIndex + 2));
            DFS(calculation(oprList.get(oprIndex), result, calc), oprIndex + 2);
        }
    }
```
- 그리고 연산의 결과값이 0보다 작은 음수가 나올수 있기 때문에,  
- max 의 값을 Integer.MIN_VALUE 로 초기화 해주었다.

## :black_circle: Review
원래 연산자들을 객체로 처리하여 연산자 좌우의 숫자들과 좌우의 연사자들의 인덱스의 정보를 담는 객체 배열로 이용해 만들려고 했는데,  
이렇게 하게되면 괄호가 중첩되는 처리는 따로하기 매우 힘들어서 풀지못하고
결국 구글링을 통해 힌트를 얻고 백트래킹을 이용해 풀었다  
조금 어려웠던 문제지만 방식만 이해하면 다음번에 적용시키기 좋을거같다
