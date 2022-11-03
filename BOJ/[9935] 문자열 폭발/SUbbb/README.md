# [9935] 문자열 폭발

## :pushpin: **Algorithm**

자료구조, 문자열, 스택

## :round_pushpin: **Logic**

```java
for (int index = 0; index < targetString.length(); index++) {
    char currentCharacter = targetString.charAt(index);
    stack.push(currentCharacter);

    if (stack.size() >= bombString.length() && searchBomb(bombString)) {
        bomb(bombString.length());
    }
}
```

- 문자열을 탐색하면서, 스택에 넣는다.
- 폭발 문자열의 길이와 스택의 길이가 같아지는 경우, 현재 스택의 내용에 폭발 문자열이 존재하는지 확인한다.

```java
private static boolean searchBomb(String bombString) {
    int start = stack.size() - bombString.length();
    int end = stack.size();
    int bombIndex = 0;

    for (int index = start; index < end; index++) {
        if (stack.get(index) != bombString.charAt(bombIndex++)) {
            return false;
        }
    }

    return true;
}
```

- 스택의 헤드에서부터 폭발 문자열의 길이만큼을 확인하면서, 폭발 문자열과 일치하는지 확인한다.

## :black_nib: **Review**
- 스택을 활용하는 문자열 문제를 많이 접해보고 나니, 이 문제를 처음 봤을 때보단 접근이 쉬웠다.