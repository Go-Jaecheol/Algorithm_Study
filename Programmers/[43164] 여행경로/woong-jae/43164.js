function solution(tickets) {
    let answer = ["ICN"];
    
    const adj = new Map();
    tickets.forEach(ticket => {
        let [from, to] = ticket;
        if(adj.has(from)) {
            let list = adj.get(from);
            if(list[to]) list[to]++;
            else list[to] = 1;
        }
        else adj.set(from, { [to]: 1 });
    });
    
    function dfs(cur, depth) {
        if(depth === tickets.length) return true;
        if(!adj.has(cur)) return false;
        let nextList = adj.get(cur);
        let visited = new Set();
        
        while(1) {
            let next = null;
            for(let key in nextList) {
                if(nextList[key] && !visited.has(key) && (!next || next.localeCompare(key) > 0)) {
                    next = key;
                }
            }
            if(!next) return false;
            visited.add(next);
            
            answer.push(next);
            nextList[next]--;
            if(dfs(next, depth + 1)) return true;
            nextList[next]++;
            answer.pop();
        }
    }
    
    dfs("ICN", 0);
    
    return answer;
}
