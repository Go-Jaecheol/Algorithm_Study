from copy import deepcopy


def move_left_right(i, move, name):

    copy_name = deepcopy(name)
    copy_name[0] = 0

    while True:
        name[i] = 0
        if sum(name) == 0:
            break

        left, right = 1, 1
        while name[i-left] == 0:
            left += 1
        while name[i+right] == 0:
            right += 1

        if i == 0:
            return min(move_left_right(i-left, left, name),
                move_left_right(i+right, right, copy_name))
        else:
            i += -left if left < right else right
            move += left if left < right else right

    return move


def solution(name):
    ascii_name = [min(ord(x)-ord("A"), ord("Z")-ord(x)+1) for x in name]

    return sum(ascii_name) + move_left_right(0, 0, ascii_name)