# [12904] A와 B - JAVA

## :black_circle: Algorithm
**Greedy**, **String**

## :black_circle: Logic

> _Key Idea_
- A를 추가하는 연산과 문자열을 뒤집고 뒤에 B를 추가하는 연산을 거꾸로 생각한다
- T 에서 위의 연산들을 거꾸로 실행하여 S가 되는지 검사한다
- 문자열을 뒤집는 과정은 `boolean` 을 전역변수로 선언하여 **head 쪽이 앞**이면 `true`, **tail 쪽이 앞**이면 `false` 로 생각한다
- T 문자열의 맨뒤에 있는 Char 를 검사하여 A 면 그냥 제거만하고 B 이면 제거를 한 후에 `boolean` 값을 바꿔준다
- 연산을 거치다가 T 문자열의 길이와 S 문자열의 길이가 같아졌을 때 `equals()` 검사를 한다

```Java
private static String remove(String T) {
    if(head){
        if (T.charAt(T.length() - 1) == 'B')
            head = false;
        return T.substring(0, T.length() - 1);
    }
    else {
        if (T.charAt(0) == 'B')
            head = true;
        return T.substring(1);
    }
}
```

## :black_circle: Review
문자열 맨뒤의 char 을 검사하여 연산을 거꾸로 하는 아이디어를 쉽게 생각할 수 있었다  
정답률이 높은 이유가 있는듯!
