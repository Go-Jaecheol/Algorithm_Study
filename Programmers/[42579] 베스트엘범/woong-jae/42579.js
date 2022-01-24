function solution(genres, plays) {
    let answer = [];
    const map = {};
    
    genres.forEach((genre, index) => {
        map[genre] ? map[genre].play += plays[index] : map[genre] = { play: plays[index], indexes: [] };
        map[genre].indexes.push(index);
    });
    
    let order = [];
    for(let genre in map) {
        order.push(genre);
    }
    order.sort((a, b) => map[b].play - map[a].play).forEach(genre => {
        map[genre].indexes.sort((a, b) => {
            if(plays[a] !== plays[b]) return plays[b] - plays[a];
            else return a - b;
        });
        if(map[genre].indexes.length > 2) map[genre].indexes = map[genre].indexes.slice(0, 2);
        answer = answer.concat(map[genre].indexes);
    });
    
    return answer;
}
