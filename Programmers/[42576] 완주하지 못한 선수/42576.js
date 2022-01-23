function solution(participant, completion) {
    const map = {};
    completion.forEach(elem => map[elem] ? map[elem]++ : map[elem] = 1);
    
    for(let i = 0; i < participant.length; i++) {
        let p = participant[i];
        if(!map[p]) return p;
        map[p]--;
    }
}
