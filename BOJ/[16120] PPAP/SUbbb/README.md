# [16120] PPAP

## :pushpin: **Algorithm**

문자열

## :round_pushpin: **Logic**

```java
for (int index = 0; index < ppap.length(); index++) {
    char ch = ppap.charAt(index);
    stringBuilder.append(ch);

    if (stringBuilder.length() >= 4 && getString().equals(PPAP)) {
        deleteString();
    }
}

if (!stringBuilder.toString().equals("P")) {
    answer = "NP";
}
```

- 주어진 문자열의 한 문자씩 StringBuilder에 추가한다. 
- StringBuilder의 길이가 4 이상이라면 PPAP와 같은지 확인하고 지운다.
- 최종적으로 P만 남아야 PPAP 문자열이다.

## :black_nib: **Review**
- 문제 이해를 잘못해서 PPAPPPAP도 PPAP 문자열인 것으로 알고 구현했다.
- 문자열 폭발과 매우 유사한 문제였다.