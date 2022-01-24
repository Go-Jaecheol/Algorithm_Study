function solution(clothes) {
    let answer = 0;
    const map = {};
    
    clothes.forEach(clothe => map[clothe[1]] ? map[clothe[1]].push(clothe[0]) : map[clothe[1]] = [clothe[0]]);
    
                    
    for(let clothe in map) {
        let combination = answer * map[clothe].length + map[clothe].length;
        answer += combination;
    }
    
    return answer;
}
