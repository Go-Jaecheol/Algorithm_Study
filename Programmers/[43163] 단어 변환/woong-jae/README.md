# [43163] 단어 변환
## Algoritm
- DFS
## Logic
한 개의 알파벳만 차이나는 단어끼리 edge가 형성되는 그래프로 볼 수 있다.

그래프를 순회하다 `target`을 찾아내면 이때까지 걸린 단계를 리턴해주고, 이 값들중 최소값을 구한다.

```js
function solution(begin, target, words) {
    let answer = Infinity;
    const visited = new Array(words.length).fill(false);
    
    words.forEach((word, next) => {
        if(getDiff(begin, word) < 2 && !visited[next]) {
            answer = Math.min(answer, dfs(next));
        }
    });
    
    function dfs(current) {
        const currentWord = words[current];
        if(currentWord === target) return 1;
        let minStep = Infinity;
        visited[current] = true;
        words.forEach((word, next) => {
            if(getDiff(currentWord, word) < 2 && !visited[next]) {
                minStep = Math.min(minStep, dfs(next) + 1);
            }
        });
        visited[current] = false;
        return minStep;
    }
    
    return isFinite(answer) ? answer : 0;
}

function getDiff(w1, w2) {
    let diff = 0;
    w1.split("").forEach((char, i) => {
       if(char !== w2[i]) diff++;
    });
    return diff;
}
```
## Review
단순 dfs/bfs 문제는 쉬운 것 같다.
