# [43163] 단어 변환 - Java

## :pushpin: **Algorithm**

DFS, BFS

## :round_pushpin: **Logic**

```java
private int dfs(String begin, String target, String[] words, boolean[] visited, int count, int idx) {
    if (begin.equals(target) || visited[idx]) return count;
    
    visited[idx] = true;
    int ans = 0;
    
    for (int i = 0; i < words.length; i++) {
        if (idx != i && !visited[i] && isOneCharDiff(begin, words[i]))
            ans = dfs(words[i], target, words, visited, count + 1, i);
    }
    
    return ans;
}
```

- 재귀적인 DFS를 이용해 현재 단어와 한 문자만 다른 단어로 변환을 수행한다.
  - 이때 지금까지의 변환된 수(`count`)를 함께 전달한다.

## :black_nib: **Review**

- 단어별 다른 문자 수를 그래프 형태로 변환해 저장하고 이를 BFS 방식으로 접근하도록 구현했는데, 방법 자체가 잘못 된 것 같았다.
- 한 문자만 다른 단어로 변환할 수 있기에 굳이 단어별 다른 문자 수를 구할 필요가 없었고 DFS를 이용하는 방법을 참고했다.
