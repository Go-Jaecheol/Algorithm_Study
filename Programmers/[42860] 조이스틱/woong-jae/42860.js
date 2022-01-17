function solution(name) {
    let answer = 0;
    const nameArray = name.split('');
    
    let charToChange = [];
    answer = nameArray.reduce((acc, cur, i) => {
        let charCode = cur.charCodeAt(0) - 65;
        if (cur !== "A" && i !== 0) charToChange.push(i);
        return (charCode < (26 - charCode) ? acc + charCode : acc + (26 - charCode));
    }, 0);
    
    answer += calcMinMove(0, charToChange, name.length);
    
    return answer;
}

function calcMinMove(cur, charToChange, length) {
    if (charToChange.length === 0) return 0;
    
    let minMove = Infinity;
    
    // 왼쪽
    let next = charToChange.pop();
    let nextCost = cur < next ? length - next + cur : cur - next;
    minMove = Math.min(minMove, calcMinMove(next, charToChange, length) + nextCost);
    charToChange.push(next);
    // 오른쪽
    next = charToChange.shift();
    nextCost = cur < next ? next - cur : length - cur + next;
    minMove = Math.min(minMove, calcMinMove(next, charToChange, length) + nextCost);
    charToChange.unshift(next);
    
    return minMove;
}
