import sys
N = int(sys.stdin.readline())
crane = [int(x) for x in sys.stdin.readline().split()]
M = int(sys.stdin.readline())
box = [int(x) for x in sys.stdin.readline().split()]
time = 0

def moveBox():
    isChange = False
    for i in range(N):
        for j in range(len(box)):
            if not box:
                return isChange
            if crane[i] >= box[j]:
                isChange = True
                del box[j]
                break
    return isChange

crane.sort(reverse=True)
box.sort(reverse=True)
while box:
    if moveBox() == False:
        time = -1
        break
    time += 1

print(time)