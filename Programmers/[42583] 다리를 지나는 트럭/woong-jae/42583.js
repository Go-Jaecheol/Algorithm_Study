function solution(bridge_length, weight, truck_weights) {
    let answer = 0;
    let bridge = [];
    
    let truckIndex = 0;
    let bridgeWeight = 0;
    while(truckIndex < truck_weights.length) {
        bridge.forEach(elem => elem.l--);
        if(bridge.length && bridge[0].l === 0) bridgeWeight -= bridge.shift().w;
        if(bridgeWeight + truck_weights[truckIndex] <= weight) {
            bridgeWeight += truck_weights[truckIndex];
            bridge.push({w: truck_weights[truckIndex++], l: bridge_length});
        }
        answer++;
    }
    
    if(bridge.length) answer += bridge[bridge.length - 1].l;
    
    return answer;
}
