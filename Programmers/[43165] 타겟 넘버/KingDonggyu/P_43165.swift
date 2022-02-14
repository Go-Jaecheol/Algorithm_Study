import Foundation

func solution(_ numbers:[Int], _ target:Int) -> Int {
    if numbers.count > 0 {
        var num: [Int] = numbers
        num.removeFirst()
        return solution(num, target+numbers[0]) + solution(num, target-numbers[0])
    } else {
        if target == 0 {
            return 1
        } else {
            return 0
        }
    }
}