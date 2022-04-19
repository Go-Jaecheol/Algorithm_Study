# [2866] 문자열 잘라내기 - JAVA

## :black_circle: Algorithm
**String**

## :black_circle: Logic
> _Key Idea_
> - 입력받은 문자열들의 세로로 문자열들을 넣은 `List` 를 최초에 한번만 생성
> - 가장 위의 행을 제외한 세로 문자열들에 중복이 없다면
> - 실제로 문자열 하나를 삭제하는 것이 아닌 `idx` 를 증가시켜 세로 문자열들의 앞에서 하나씩 잘라준다
> - 중복검사는 세로 문자열들을 `Map` 에 `key` 로 넣고 `value`는 개수로 둬서
> - 만약 `value` 가 2이상이라면 중복이 발생한 것이므로 count 개수를 출력하고 프로그램을 종료한다
> - 중복이 발생하지 않았다면 `count++` 하고 `idx++` 해주어 가장위의 행을 지운 것과 같은 효과를 본다


```Java
ArrayList<String> colStrings = makeCols(list, C);

while (true) {
    if (isDup(colStrings, idx)) {
        System.out.println(count);
        break;
    } else {
        count++;
        idx++;
    }
}
```

## :black_circle: Review
이 문제는 명확하게 시간이 오래 걸릴 것같은 문제였어서  
어떻게 하면 시간을 줄일 수 있을 지 고민하다 알고 스터디에서  
최상단의 위치를 최초 1회 `idx` 만 구하고 그 이후로는 
`idx` 만을 이용하여 시간을 줄이는 것에 아이디어를 얻어서  
실제로 문자열을 제거하는 것이 아닌 `idx` 를 이용해 세로 문자열의 길이를  
조절하는 방법을 생각했고 통과했다  
중복 검사 또한 `contains()` 함수가 시간이 오래 걸리기에 
`Map` 을 이용해 개수로 접근하는 방식을 사용해 시간을 줄일 수 있었던 것 같다
