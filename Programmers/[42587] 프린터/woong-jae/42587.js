function solution(priorities, location) {
    let answer = 0;
    
    let pending = new Array(priorities.length).fill(0).map((_,i) => i);
    let maxVal = priorities.slice(0).sort((a, b) => a - b);
    
    while(1) {
        let current = pending.shift();

        if(priorities[current] === maxVal[maxVal.length - 1]) {
            answer++;
            maxVal.pop();
            if(location === current) break;
        }
        else pending.push(current);
    }
    
    return answer;
}
