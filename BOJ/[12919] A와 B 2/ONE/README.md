# [12919] A와 B 2 - JAVA

## :black_circle: Algorithm
**DFS**, **String**

## :black_circle: Logic
> _Key Idea_
> - S를 T로 바꾸는 것이 아닌 T를 S로 바꾼다
> - 이전 `A와 B` 문제와의 차이점은 B를 먼저 추가하고 문자열을 뒤집는 것인데
> - 이렇게되면 `B・・・A`와 같은 경우에 연산 2가지중 어느것을 먼저 수행해야할지 우선순위가 정해져 있지 않다
> - 그러므로 모든 경우의 수를 탐색하기위해 `DFS` 를 사용한다
> - 문자열을 뒤집는 연산은 실제로 하지는 않고 `boolean` 값을 이용해 판단한다
> - `DFS` 를 사용해 종료 조건을 문자열의 길이가 같아질때 까지로 두고
> - `head`가 어딘지에 따라 문자열을 비교하여 확인한다

```Java
private static void DFS(String S, String T, boolean head) {
    if (T.length() == S.length()) {
        if(T.equals(S) && head || reverse(T).equals(S) && !head)
            check = true;
        return;
    }

    if (head) {
        if(T.charAt(T.length() - 1) == 'A')
            DFS(S, T.substring(0, T.length() - 1), true);
        if(T.charAt(0) == 'B')
            DFS(S, T.substring(1), false);
    }

    else {
        if(T.charAt(0) == 'A')
            DFS(S, T.substring(1), false);
        if(T.charAt(T.length() - 1) == 'B')
            DFS(S, T.substring(0, T.length() - 1), true);
    }
}
```

## :black_circle: Review
지난번 문제와 비슷하게 풀려고했으나 두개의 *연산의 우선순위*를 정하지 못해  
두가지 경우의 수를 모두 탐색해야 할 것 같아서 `DFS` 를 사용했고 정답이었다  
이번문제는 응용성이 좋았고 빨리 푼것 같아 기분이 좋다!