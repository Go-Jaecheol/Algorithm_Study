function solution(str) {
  let index = 0;
  while (true) {
    if (index == str.length) return "SUBMARINE";

    // 0으로 시작하는 경우
    if (
      index < str.length - 1 &&
      (str[index] === "0" && str[index + 1] === "1")
    ) {
      index += 2;
      continue;
    }
    
    // 1로 시작하는 경우
    if (
      index + 3 > str.length - 1 ||
      str[index] !== "1" ||
      str[index + 1] !== "0" ||
      str[index + 2] !== "0"
    ) break;

    index += 3;
    while (str[index] === "0") index += 1;
    if (index > str.length - 1 || str[index] !== "1") break;

    const temp = index;
    while (str[index] === "1") index += 1;
    if (str[index + 1] === "0") index -= 1;
    if (temp === index) break;
  }

  return "NOISE";
}

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  console.log(solution(line));
  rl.close();
}).on("close", () => {
  process.exit();
});
