# [1701] Cubeditor - JAVA

## :black_circle: Algorithm
**KMP**

## :black_circle: Logic
> _Key Idea_
> - `KMP 알고리즘`을 이용하여 풀 수 있는 문제
> - 문자열을 앞에서부터 하나씩 줄여나가면서 `접두와 접미의 공통된 길이`를 측정하는데
> - 여기서의 `최댓값`이 주어진 문자열의 두번 이상 나오는 부분문자열중에서 가장 긴 길이이다

```Java
private static int maxSub(String sub) {
    int j = 0, len = sub.length(), max = 0;
    int[] table = new int[len];

    for (int i = 1; i < len; i++) {
        while (j > 0 && sub.charAt(i) != sub.charAt(j))
            j = table[j - 1];
        if (sub.charAt(i) == sub.charAt(j)) {
            max = Math.max(max, table[i] = ++j);
        }
    }
    return max;
}
```

## :black_circle: Review
문자열은 어렵다