const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

rl.on('line', function(line) {
    input.push(line.split(' '));
}).on('close', function() {
    solution();
    process.exit();
});

function solution() {
    const [N, M] = input.shift().map(elem => +elem);
    const map = [];
    for (let rowIndex = 0; rowIndex < N; rowIndex++) {
        map.push(input.shift().map(elem => +elem));
    }

    const islands = getIslands(N, M, map);
    const adj_list = getMinPathAdjList(N, M, map, islands);

    let res = calcPrim(adj_list);
    console.log(res === Infinity ? -1 : res);
}

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

function getIslands(N, M, map) {
    const islands = [];
    const visited = [];
    visited.length = N;
    for (let index = 0; index < visited.length; index++) {
        visited[index] = [];
        visited[index].length = M;
        visited[index].fill(false);
    }

    for (let rowIndex = 0; rowIndex < N; rowIndex++) {
        for (let colIndex = 0; colIndex < M; colIndex++) {
               const element = map[rowIndex][colIndex];
               if (element && visited[rowIndex][colIndex] === false) {
                   const island = [];
                   const queue = [];
                   queue.push({r: rowIndex, c: colIndex});
                   visited[rowIndex][colIndex] = true;
                   while(queue.length) {
                        const current = queue.shift();
                        island.push(current);
                        map[current.r][current.c] = islands.length + 1;
                        for (let direction = 0; direction < 4; direction++) {
                            const next = { 
                                r: current.r + dr[direction], 
                                c: current.c + dc[direction]
                            };
                            if (checkInBoundary(next, N, M) && !visited[next.r][next.c] && map[next.r][next.c]) {
                                queue.push(next);
                                visited[next.r][next.c] = true;
                            }
                        }
                   }
                   islands.push(island);
               }
        }
    }

    return islands;
}

function checkInBoundary(indexToCheck, N, M) {
    if (0 <= indexToCheck.r && indexToCheck.r < N && 0 <= indexToCheck.c && indexToCheck.c < M) return true;
    return false;
}
