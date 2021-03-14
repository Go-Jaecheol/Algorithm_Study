N = int(input())
dice = list(map(int, input().split()))
result = 0

if N == 1:
    result = sum(dice) - max(dice)
    print(result)
else:
    one_face = 0
    two_face = 0
    three_face = 0
    min_face = []
    for i in range(3):
        min_face.append(min(dice[i], dice[5-i]))

    three_face = 4 * (min_face[0] + min_face[1] + min_face[2])
    two_face = (4 * (N - 1) + 4 * (N - 2)) * min((min_face[0] + min_face[1]), (min_face[1] + min_face[2]), (min_face[0] + min_face[2]))
    one_face = (4 * (N - 1) * (N - 2) + (N - 2) * (N - 2)) * min(min_face[0], min_face[1], min_face[2])

    result = one_face + two_face + three_face
    print(result)