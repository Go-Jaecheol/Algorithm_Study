const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
rl.on('line', function(line) {
    input.push(line.split(' '));
}).on('close', function() {
    solution();
    process.exit();
});

function solution() {
    let N = Number(input[0]);
    let buildingToBePreceded = {}, constructionTime = {};
    let cache = {};

    for (let i = 1; i <= N; i++) {
        constructionTime[i] = Number(input[i][0]);
        buildingToBePreceded[i] = [];
        for (let b = 1; b < input[i].length - 1; b++) {
            buildingToBePreceded[i].push(Number(input[i][b]));
        }
    }

    function getConstructionTime(buildingNum) {
        let res = cache[buildingNum];
        if (res) return res;
    
        res = constructionTime[buildingNum];
        let maxBuildTime = 0;
        for (let b = 0; b < buildingToBePreceded[buildingNum].length; b++) {
            maxBuildTime = Math.max(maxBuildTime, getConstructionTime(buildingToBePreceded[buildingNum][b]));
        }
        res += maxBuildTime;
    
        cache[buildingNum] = res;
        return res;
    }
    
    for (let i = 1; i <= N; i++) {
        let res = getConstructionTime(i, cache);
        console.log(res);
    }
}
