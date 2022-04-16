# [2671] 잠수함식별 - JAVA

## :black_circle: Algorithm
**String**

## :black_circle: Logic

> _Key Idea_
- 이전에 `1013 Contact` 문제와 똑같은 유형의 문제
- 정규표현식을 사용하여 `~` 의 의미가 `+` 와 같으므로
- `(100+1+|01)+` 을 `matches()` 함수를 사용하여 확인

```Java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String pattern = "(100+1+|01)+";
    String sound = scanner.next();

    if(sound.matches(pattern))
        System.out.println("SUBMARINE");
    else
        System.out.println("NOISE");

    scanner.close();
}
```

## :black_circle: Review
전에 풀어본 문제와 같은 유형이라 쉽게 풀 수 있었다