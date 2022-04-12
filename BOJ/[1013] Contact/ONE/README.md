# [1013] Contact - JAVA

## :black_circle: Algorithm
**String**, **정규표현식**

## :black_circle: Logic

> _Key Idea_
> - 정규표현식에 대한 문법을 알고있으면 쉽게 풀 수 있는 문제
> - `+` : 앞문자가 한번 이상
> - `()` : 소괄호 안의 문자를 하나의 문자로 인식
> - `|` : 패턴안에서 or 연산을 수행할 때 사용
> - matches() 메소드에 정규표현식을 이용해 참 거짓을 판단

```Java
for (int i = 0; i < T; i++) {
    String pattern = scanner.next();
    if(pattern.matches(vega))
        System.out.println("YES");
    else
        System.out.println("NO");
}
```

## :black_circle: Review
처음에는 아예 접근법을 몰라서 노가다로 여러가지 경우를 생각해보며  
if 문을 겁나게 걸어서 하는 방법으로 했는데 생각대로 되질 않았다  
그래서 질문들을 찾아보던 중 정규표현식과 자바 String 의 method 를 사용해  
쉽게 풀 수 있던 것임을 알고 허무했지만 다음번에 정규표현식에 관련한 문제가 나온다면 쉽게 풀 수 있을것 같다

출처 - https://coding-factory.tistory.com/529