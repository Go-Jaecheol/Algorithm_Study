# [17472] 다리 만들기 2
## Algorithm
- Bruteforce
- Minimum Spanning Tree(Prim)
## Logic
1. 각 섬 라벨링하고 가져오기
2. 한 섬에서 각 섬으로 만들 수 있는 다리를 edge로 인접 리스트 생성
```js
function getMinPathAdjList(N, M, map, islands) {
    const adj_list = [];

    for (let islandIndex = 0; islandIndex < islands.length; islandIndex++) {
        const island = islands[islandIndex];
        adj_list.push([]);

        for (let landIndex = 0; landIndex < island.length; landIndex++) {
            const landPosition = island[landIndex];
            
            for (let direction = 0; direction < 4; direction++) {
                const next = {
                    r: landPosition.r + dr[direction],
                    c: landPosition.c + dc[direction]
                };
                if (checkInBoundary(next, N, M) && !map[next.r][next.c]) {
                    let length = 0;
                    while(checkInBoundary(next, N, M)) {
                        if (map[next.r][next.c] && length >= 2) {
                            adj_list[islandIndex].push({ node: map[next.r][next.c] - 1, weight: length });
                            break;
                        }
                        else if (map[next.r][next.c] && length < 2) break;
                        length++;
                        next.r += dr[direction];
                        next.c += dc[direction];
                    }
                }
            }
        }
    }

    return adj_list;
}
```
3. 프림 알고리즘으로 최소 길이 구하기
```js
function calcPrim(adj_list) {
    let ret = 0;

    const added = new Array(adj_list.length).fill(false);
    const minWeight = new Array(adj_list.length).fill(Infinity);

    minWeight[0] = 0;

    for (let iter = 0; iter < adj_list.length; iter++) {
        let node = -1;
        for (let vertexIndex = 0; vertexIndex < adj_list.length; vertexIndex++) {
            if (!added[vertexIndex] && (node === -1 || minWeight[node] > minWeight[vertexIndex]))
                node = vertexIndex;
        }
        
        ret += minWeight[node];
        added[node] = true;

        for (let edgeIndex = 0; edgeIndex < adj_list[node].length; edgeIndex++) {
            const { node: vertex, weight } = adj_list[node][edgeIndex];
            if (!added[vertex] && minWeight[vertex] > weight) {
                minWeight[vertex] = weight;
            }
        }
    }

    return ret;
}
```
## Review
문제 자체는 풀고나니까 어렵지 않은 것 같은데, MST 알고리즘이 하나도 생각이 안나 오래 걸렸다. 공부하자... 
