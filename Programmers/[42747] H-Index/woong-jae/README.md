# [42747] H-Index
## Algorithm
- Sort
## Logic
1. `citations`를 내림차순으로 정렬한다.
2. 조건에 만족되는 논문을 발견했다면,
  - 현재 논문 인용 횟수보다 `h`가 클 수 있는지 확인하고 크다면 그것을 반환한다.
  - 아니라면 현재 논문 인용 횟수를 반환한다.
3. 조건에 만족되는 논문을 발견하지 못했다면 `n`이 H-Index가 된다.
```js
function solution(citations) {
    const n = citations.length;
    
    citations.sort((a, b) => b - a);
    for(let i = 0; i < n; i++) {
        const citation = citations[i];
        if(i + 1 >= citation && citation >= n - i - 1) {
            if(i !== 0 && citations[i - 1] > i) return Math.max(citation, i);
            return citation;
        };
    }
    return n;
}
```
## Review
정렬 문제는 코너 케이스를 찾는게 힘든 것 같다. 정렬 문제를 좀 더 많이 풀어서 익숙해져야겠다.
