# [1515] 게임 개발
## Algorithm
- DP
## Logic
빌딩 `x`의 최소 건설 시간은 '`x의 건설 시간` + `선행되는 건물 중 가장 오래 걸리는 건물`'로 일반화 할 수 있다.

계산한 건설 시간은 캐시에 저장해, 다음번 계산을 줄여 동적 계획법을 구현했다.

```js
function getConstructionTime(buildingNum) {
    let res = cache[buildingNum];
    if (res) return res; // 캐시에 있으면 바로 반환
    
    res = constructionTime[buildingNum];
    let maxBuildTime = 0;
    for (let b = 0; b < buildingToBePreceded[buildingNum].length; b++) {
        maxBuildTime = Math.max(maxBuildTime, getConstructionTime(buildingToBePreceded[buildingNum][b]));
    }
    res += maxBuildTime;
    
    cache[buildingNum] = res;
    return res;
}
```
## Review
동적 계획법으로 푸는 방법은 쉽게 생각했지만, 위상 정렬로 푸는 방법은 잘모르겠다. 위상정렬로도 풀어봐야겠다.
