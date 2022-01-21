class DisjointSet {
    constructor(n) {
        this.parent = new Array(n).fill(0).map((_, i) => i);
    }
    find(u) {
        if(u === this.parent[u]) return u;
        return this.parent[u] = this.find(this.parent[u]);
    }
    merge(u ,v) {
        u = this.find(u); v = this.find(v);
        if(u === v) return;
        this.parent[u] = v;
    }
}

function solution(n, costs) {
    let answer = 0;
    const disjointSet = new DisjointSet(n);
    
    costs = costs.map(edge => edge.map(elem => +elem)).sort((a, b) => a[2] - b[2]);
    
    for(let edgeIndex = 0; edgeIndex < costs.length; edgeIndex++) {
        let [u, v, w] = costs[edgeIndex];
        u = disjointSet.find(u); v = disjointSet.find(v);
        if(u === v) continue;
        disjointSet.merge(u, v);
        answer += w;
    }
    
    
    return answer;
}
