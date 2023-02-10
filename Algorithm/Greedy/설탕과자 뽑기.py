# 설탕과자 뽑기
# https://codeup.kr/problem.php?id=6097

# 격자판의 세로(h), 가로(w) 입력
h,w = input().split()
h = int(h)
w = int(w)

# 격자판 그리기, 0으로 초기화
dd = [[0 for j in range(w)] for i in range(h)]

# 놓을 수 있는 막대의 개수(n)
n = int(input())

# 알고리즘
for k in range(n):
    # 각 막대의 길이(l), 방향(d), 좌표(x,y)입력  // d=0:가로 / d=1:세로
    l,d,x,y = input().split()
    l = int(l)
    x = int(x)-1
    y = int(y)-1

    # 막대 놓기
    if d == '0':    # 가로
        for i in range(y, y+l):
            dd[x][i] = 1
    else:           # 세로
        for i in range(x,x+l):
            dd[i][y] = 1

# 격자판 결과 출력
for i in range(h):
    for j in range(w):
        if j == int(w)-1: print(dd[i][j])
        else: print(dd[i][j], end=' ')
