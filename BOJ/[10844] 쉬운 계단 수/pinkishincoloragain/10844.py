
N = int(input())

num_arr = [0,1,1,1,1,1,1,1,1,1]
temp = [0,1,1,1,1,1,1,1,1,1]
test = []

# print(num_arr)

for i in range(1,N):

    temp[0]=num_arr[1]
    temp[9]=num_arr[8]

    for j in range(1,9):
        temp[j] = num_arr[j-1] + num_arr[j+1]

    for k in range(0,10):
        num_arr[k] = temp[k] % 1000000000

    # print(num_arr)
    # test.append(sum(num_arr) % 1000000000)

print(sum(num_arr) % 1000000000)
# print(test)


