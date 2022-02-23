import Foundation

func solution(_ citations:[Int]) -> Int {
    let n: Int = citations.count
    for (i, ci) in citations.sorted().enumerated() {
        if n - i <= ci { return n - i }
    }
    return 0
}