# [1541] 잃어버린 괄호 - JAVA

## :black_circle: Algorithm
**Greedy**

## :black_circle: Logic

- 적절히 괄호를 사용하여 식의 값을 최소로 만들기

> _Key Idea_
> - 덧셈은 괄호의 영향을 받지 않으나 뺄셈은 괄호의 영향을 받는다
> - 그래서 덧셈을 다한 후에 뺄셈을 진행하게되면 가장 큰수를 뺄 수 있다
> - `-` 로 분리한것들을 더한뒤에 빼기 연산을 해줄때 가장 앞의 숫자는 양수이므로 덧셈을 해준다

```Java
String expr = scanner.next();

String[] minusToken = expr.split("-");

for (int i = 0; i < minusToken.length; i++) {
    int plusNum = 0;

    String[] plusToken = minusToken[i].split("\\+");

    for(String plus : plusToken)
        plusNum += Integer.parseInt(plus);

    if(i == 0)
        answer += plusNum;
    else
        answer -= plusNum;
}
```

## :black_circle: Review
아이디어에 대한 생각 자체는 빨리 났었고  
코드를 구현하는데에도 큰 문제는 없었는데  
split 할 때 +는 그냥 사용하는것이 안돼서 \\+의 형태로 사용했다  
`+` 문자가 메타문자(meta character : 의미가 있는 문자)라 그렇다고 하네요~
