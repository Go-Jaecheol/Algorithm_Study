const [T, ...TC] = require("fs")
  .readFileSync("./input.txt")
  // .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

TC.forEach((line, idx) => {
  if (idx % 2 !== 0) {
    const choices = line.split(" ").map(Number);
    choices.unshift(0);
    const visited = Array(choices.length + 1).fill(0);
    const check = Array(choices.length + 1).fill(0);
    
    let team = 0;

    function dfs(n) {
      visited[n] = 1;
      const next = choices[n];

      if (!visited[next]) {
        dfs(next);
      } else if (!check[next]) {
        for (let i = next; i !== n; i = choices[i]) {
          team += 1;
        }
        team += 1;
      }

      check[n] = 1;
    }

    for (let i = 1; i <= choices.length; i += 1) {
      if (!visited[i]) {
        dfs(i);
      }
    }
    console.log(choices.length - team);
  }
});
