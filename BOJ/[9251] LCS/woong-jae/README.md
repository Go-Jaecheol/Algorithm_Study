# [9251] LCS
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

두 개의 문자열을 처음부터 비교한다.

지금 index가 가르키는 두 개의 문자가 같다면, index를 둘 다 증가시킨 후 다음 부분 문제로 들어간다.

문자가 다르다면, index를 각각 하나씩만 올린 부분 문제로 들어간다.

```
int lcs(int index1, int index2) {
    if(index1 == str1.size() || index2 == str2.size()) return 0;
    int&ret = cache[index1][index2];
    if(ret != -1) return ret;
    
    ret = 0;
    if(str1[index1] == str2[index2]) {
        ret = max(ret, lcs(index1 + 1, index2 + 1) + 1);
    } else {
        ret = max(lcs(index1 + 1, index2), lcs(index1, index2 + 1));
    }
    
    return ret;
}
```

## 💡Review

다음 부분 문제로 들어가는 부분을 이중포문으로 구현하니 시간 초과가 났다...

알고보니 굳이 포문으로 들어갈 필요가 없었다. 이런 식으로 생각은 어떻게 하는지 참 신기하다.

이중 포문이 들어가면 일단 나를 의심해야겠다.
