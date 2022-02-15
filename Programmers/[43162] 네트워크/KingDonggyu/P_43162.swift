import Foundation

func solution(_ n:Int, _ computers:[[Int]]) -> Int {
    var answer: Int = 0
    var visited: [Bool] = Array(repeating: false, count: n)
    
    func dfs(_ x: Int) {
        visited[x] = true
        for i in 0..<n {
            if !visited[i] && computers[x][i] == 1 {
                dfs(i)
            }
        }
    }
    
    for i in 0..<n {
        if !visited[i] {
            dfs(i)
            answer += 1
        }
    }
    
    return answer
}