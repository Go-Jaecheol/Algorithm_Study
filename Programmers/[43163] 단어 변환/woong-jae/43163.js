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
