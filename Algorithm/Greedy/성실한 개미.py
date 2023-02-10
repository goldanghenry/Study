# 큰 수의 법칙
# https://codeup.kr/problem.php?id=6098
# 먹이까지 가장 빠른 길 찾기
# 입력 : 10x10, 이동가능: 0, 벽: 1, 테두리는 벽(1)
# 개미 이동 경로 9로 표시, 먹이는 2
# 먹이를 만나거나, 우측 하단까지 이동하면 먹이찾기 종료
# 출발 위치(2,2) -> 오른쪽으로 이동하다 벽을 만나면 아래로 이동

# 10x10 테이블 입력
t = [[ 0 for j in range(10) ] for i in range(10) ]  # 0으로 초기화
for i in range(10):
    x = input().split()
    for j in range(10):
        t[i][j] = int(x[j])

# 길 찾기 알고리즘
x_axis = 0  # x축 이동 기록
end = 0     # 종료 조건 만족시 0 -> 1

for i in range(1, 9):   # 제일 아래 테두리는 검색하지 않음
    for j in range(1, 10):
        # 종료 조건 만족
        if j>=x_axis and t[i][j] == 2:
            t[i][j] = 9
            end = 1
            break
        # 바로 아래 줄로 이동
        elif j<x_axis: continue
        # 다음 칸에 1이 있다면 x좌표 기록 후 다음 줄로 이동
        elif t[i][j+1] == 1: 
            t[i][j] = 9
            x_axis = j
            break
        else: t[i][j] = 9   # 개미가 움직인 흔적 표시
    if end == 1: break      # 길 찾기 알고리즘 종료

# 결과 출력
for i in range(10):
    for j in range(10):
        if j == 9: print(t[i][j])
        else: print(t[i][j], end=' ')