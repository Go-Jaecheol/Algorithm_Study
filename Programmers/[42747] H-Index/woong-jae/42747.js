function solution(citations) {
    const n = citations.length;
    
    citations.sort((a, b) => b - a);
    for(let i = 0; i < n; i++) {
        const citation = citations[i];
        if(i + 1 >= citation && citation >= n - i - 1) {
            if(i !== 0 && citations[i - 1] > i) return Math.max(citation, i);
            return citation;
        };
    }
    return n;
}
