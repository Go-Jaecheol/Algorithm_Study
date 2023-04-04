# [16916] 부분 문자열

## :pushpin: **Algorithm**

KMP

## :round_pushpin: **Logic**

```java
private static void makeTable() {
    int prefix = 0;
    
    for (int suffix = 1; suffix < pattern.length(); suffix++) {
        while (prefix > 0 && pattern.charAt(suffix) != pattern.charAt(prefix)){
            prefix = patternIndexs[prefix - 1];
        }
        
        if (pattern.charAt(suffix) == pattern.charAt(prefix)) {
            patternIndexs[suffix] = ++prefix;
        }
    }
}
```

- 첫번째 인덱스부터 현재 인덱스까지의 문자열에서 가장 긴 접두사, 접미사의 길이를 값으로 하는 배열을 초기화한다.

```java
private static boolean kmpSearch() {
    int orgIndex = 0;
    int patternIndex = 0;
    while (orgIndex < original.length() && patternIndex < pattern.length()) {
        while (patternIndex > 0 && original.charAt(orgIndex) != pattern.charAt(patternIndex)) {
            patternIndex = patternIndexs[patternIndex - 1];
        }
        
        if (original.charAt(orgIndex) == pattern.charAt(patternIndex)) {
            if (patternIndex == pattern.length() - 1) {
                return true;
            }
            patternIndex++;
        }
        orgIndex++;
    }
    
    return false;
}
```

- 패턴 문자열의 인덱스를 옮겨가면서 주어진 문자열에 패턴 문자열이 존재하는지 확인한다.

## :black_nib: **Review**

- 오늘 KMP 알고리즘에 대해 배우고 실습해보면서 푼 문제이다.
- 알고리즘 자체는 이해가 되는데, 테이블 값을 만드는 과정이 완벽하게 이해가 되지 않는다.