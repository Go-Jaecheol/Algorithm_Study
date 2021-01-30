N = int(input())
A = list(map(int, input().split()))
A_data = {}

for i in A:
    A_data[i] = {'data': 1}
    A_data = dict(sorted(A_data.items(), key=lambda x: x[1]['data']))
    for key in reversed(A_data):
        if key < i and A_data[key]['data'] >= 1:
            A_data[i]['data'] += A_data[key]['data']
            break
print(max(A_data.items(), key=lambda x: x[1]['data'])[1]['data'])

