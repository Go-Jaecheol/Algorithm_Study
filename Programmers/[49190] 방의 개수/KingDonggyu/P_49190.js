function solution(arrows) {
    const dx = [1, 1, 0, -1, -1, -1, 0, 1];
    const dy = [0, 1, 1, 1, 0, -1, -1, -1];

    let answer = x = y = nextX = nextY = 0;
    const visited = new Map();
    visited.set('0,0', new Set());

    arrows.forEach(a => {
        for (let i=0;i<2;i++) {
            nextX += dx[a];
            nextY += dy[a];

            const nowStr = `${x},${y}`
            const nextStr = `${nextX},${nextY}`
            
            if (visited.has(nextStr) && !visited.get(nextStr).has(nowStr)) {
                answer++;
            } 
            
            if (!visited.has(nextStr)) {
                visited.set(nextStr, new Set())
            }
            
            visited.get(nextStr).add(nowStr)
            visited.get(nowStr).add(nextStr)

            x = nextX;
            y = nextY;
        }
    });
    
    return answer;
}