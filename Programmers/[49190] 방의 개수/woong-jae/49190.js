function solution(arrows) {
    var answer = 0;
    
    const dr = [-1, -1, 0, 1, 1, 1, 0, -1];
    const dc = [0, 1, 1, 1, 0, -1, -1, -1];
    
    let cur = { r: 0, c: 0 };
    let adj_list = new Map();
    adj_list.set("0,0", new Set());
    
    arrows.forEach(direction => {
        let current = String(cur.r) + "," + cur.c;
        let next = String(cur.r + dr[direction]) + "," + (cur.c + dc[direction]);
        let diag1 = String(cur.r + dr[direction]) + "," + cur.c;
        let diag2 = String(cur.r) + "," + (cur.c + dc[direction]);
        
        if(!adj_list.get(current).has(next)) {
            if(adj_list.has(next)) answer++;
            if(direction % 2 && adj_list.has(diag1) && adj_list.get(diag1).has(diag2)) answer++;   
        }
        
        if(!adj_list.has(next)) adj_list.set(next, new Set());
        adj_list.get(current).add(next);
        adj_list.get(next).add(current);
        cur.r += dr[direction];
        cur.c += dc[direction];
    });
    
    return answer;
}
