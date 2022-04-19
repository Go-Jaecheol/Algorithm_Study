# [16120] PPAP - JAVA

## :black_circle: Algorithm
**String**

## :black_circle: Logic
> _Key Idea_
> - `문자열폭발`과 유사한 문제로 한글자씩 `StringBuilder` 에 넣으면서 `PPAP`와 비교하여  
> - 만약에 같다면 `P` 한글자만 남기고 다른것들은 삭제한다
> - 최종적으로 남은 문자열이 `P` 라면 `PPAP` 를 출력
> - 아니라면 `NP`를 출력

```Java
for (int i = 0; i < len; i++) {
    char c = origin.charAt(i);

    builder.append(c);

    if (builder.length() >= 4) {
        boolean check = true;

        for (int j = 0; j < 4; j++) {
            char originC = builder.charAt(builder.length() - 4 + j);
            char ppapC = ppap.charAt(j);

            if (originC != ppapC) {
                check = false;
                break;
            }
        }
        if(check)
            builder.delete(builder.length() - 4 + 1, builder.length());
    }
}
```

## :black_circle: Review
처음에는 `KMP 알고리즘`을 사용하여 문제를 풀었는데 시간초과가 떴고,  
좀 더 생각해보니 이전에 풀었던 문자열 폭발과 비슷한 유형이란 느낌이 들어  
비슷한 방식으로 풀어보니 해결되었다  
`StringBuilder` 말고 `Stack` 을 이용해 구현하여 두개의 시간을 비교해보니  
`StringBuilder`가 거의 2배정도 짧았다  
아마 조회하는 부분에서의 시간 최적화 차이가 아닐까 싶다 
