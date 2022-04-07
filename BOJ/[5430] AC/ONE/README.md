# [5430] AC - JAVA

## :black_circle: Algorithm
**Parsing**

## :black_circle: Logic

> _Key Idea_
> - 문자열에서 숫자만 분리하여 `ArrayList` 에 담는다
> - `R` 연산을 할때에는 실제로 배열을 `reverse` 하는 것이 아닌 **정방향과 역방향**으로 `boolean` 값으로 구분한다  
> - 배열의 size 가 _0 일 때_ D 연산을 수행한다면 error 반환  
> - 배열의 size 가 _1 이상 일 떄_ `정방향 역방향`에 따라 배열을 제거하는 인덱스를 `0` 또는 `length - 1` 로 한다

```Java
private static String execute(String functions, ArrayList<Integer> list) {
    boolean check = true; // true : 정방향 , false : 역방향

    for (int i = 0; i < functions.length(); i++) {
        char function = functions.charAt(i);

        if (function == 'R')
            check = !check;

        else {
            if (list.size() == 0)
                return "error";
            if (check)
                list.remove(0);
            else
                list.remove(list.size() - 1);
        }
    }

    return makeArray(list, check);
}
```

## :black_circle: Review
문제 구현자체는 어렵지 않았고, reverse 하는 부분에서  
시간 초과가 발생하여 boolean 을 이용해 풀어야 한다는 것은 쉽게 알 수 있었다  
