import sys

def main():
    str1 = ' ' + sys.stdin.readline().rstrip()
    str2 = ' ' + sys.stdin.readline().rstrip()
    cal(str1, str2)


def cal(s1, s2):
    len1 = len(s1)
    len2 = len(s2)
    res = [[0] * len2 for j in range(len1)]
    for i in range(1, len1):
        for j in range(1, len2):
            if s1[i] == s2[j]:
                res[i][j] = res[i-1][j-1]+1
            else:
                res[i][j] = max(res[i-1][j], res[i][j-1])
    print(res[-1][-1])

main()