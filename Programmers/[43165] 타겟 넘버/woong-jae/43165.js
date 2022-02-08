function solution(numbers, target) {
    let answer = 0;
    
    function dfs(depth, currentNumber) {
        if(depth === numbers.length) {
            if(currentNumber === target) answer++;
            return;
        }
        dfs(depth + 1, currentNumber + numbers[depth]);
        dfs(depth + 1, currentNumber - numbers[depth]);
    }
    
    dfs(0, 0);
    
    return answer;
}
