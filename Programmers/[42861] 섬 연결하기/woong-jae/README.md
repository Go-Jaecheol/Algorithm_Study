# [42861] 섬 연결하기
## Algorithm
- MST(Kruskal's algorithm)
## Logic
Minimum spanning tree를 찾는 문제다.

쿠르스칼/프림 알고리즘을 구현하면 쉽게 풀 수 있다. 나는 쿠르스칼을 사용했다.
```js
function solution(n, costs) {
    let answer = 0;
    const disjointSet = new DisjointSet(n);
    
    costs = costs.map(edge => edge.map(elem => +elem)).sort((a, b) => a[2] - b[2]);
    
    for(let edgeIndex = 0; edgeIndex < costs.length; edgeIndex++) {
        let [u, v, w] = costs[edgeIndex];
        u = disjointSet.find(u); v = disjointSet.find(v);
        if(u === v) continue;
        disjointSet.merge(u, v);
        answer += w;
    }
    
    
    return answer;
}
```
## Review
MST 알고리즘을 알고 있다면 너무 쉬운 문제.
