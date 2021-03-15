from bisect import bisect_right
import sys
N = int(sys.stdin.readline())
crane = [int(x) for x in sys.stdin.readline().split()]
M = int(sys.stdin.readline())
box = [int(x) for x in sys.stdin.readline().split()]
time = 0

def moveBox():
    isChange = False
    for i in crane:
        if not box:
            break
        location = bisect_right(box, i)
        if location == 0:
            break
        elif location == len(box):
            box.pop()
            isChange = True
        else:
            box.pop(location - 1)
            isChange = True
    return isChange

crane.sort(reverse=True)
box.sort()
while box:
    if moveBox() == False:
        time = -1
        break
    time += 1
print(time)