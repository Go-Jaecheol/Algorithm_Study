count = [0,0,0]

def reform_paper(N,arr):

    result = []
    temp = []

    part_length = int(N/3)

    for i in range(0,3):
        for j in range(0,3):
            for k in range(0,part_length):
                temp.extend(arr[part_length*i+k][j*part_length:(j+1)*part_length])

            result.append(temp)
            temp = []

    print(result)
    return result


def checkSame(arr):
    same = True

    if len(arr) == 1:
        count[int(arr[0])+1] +=1
        return True

    for i in range(len(arr)):
        if arr[i] != arr[0]:
            same = False
            break

    if same:
        print("arr[0] is: ", arr[0])
        count[int(arr[0])+1] +=1

    return same


def cut_paper(arr):

    # print(arr)
    part_len = int(len(arr) / 9)

    if checkSame(arr) is True:
        return

    else:
        for idx in range(0,len(arr),part_len):
            cut_paper(arr[idx*part_len:(idx+1)*part_len])


if __name__ == "__main__":

    paper=[]
    check=[]
    check_count = 0
    N = int(input())

    for i in range(0,N):
        paper.append(list(map(int,input().split())))

    print(paper)

    # do not cut if all elements are same
    for j in range(0,N):
        check.extend(paper[j])

    for j in range(0,pow(N,2)):
        if check[0] != check[j]:
            check_count+=1
            break

    if check_count == 0:
        count[paper[0][0] + 1] += 1

    else:
        reformed_paper = reform_paper(N,paper)

        for i in range(0,9):
            cut_paper(reformed_paper[i])

    for idx in range(0,3):
        print(count[idx])