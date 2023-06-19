# 게임 개발


# 방법 1
# # 입력
# N,M = map(int, input().split())     # N: 세로, M: 가로
# dx,dy,d = map(int, input().split())  # 캐릭터 시작위치 // x: 행, y: 열, d: 방향(0:북,1:동,2:남,3:서)
# # 배열 초기화
# m = [[1 for j in range(M+2)] for i in range(N+2)]   # out of range index 방지
# for i in range(N):                  # 맵 입력 // 0: 육지, 1: 바다
#     L = list(map(int, input().split()))
#     for j in range(M):
#         m[i+1][j+1] = L[j]

# # 초기 셋팅
# dx = +2         # 행
# dy = +2         # 열
# turn = 0        # 방향 전환 횟수 기록
# count = 1       # 방문 횟수 기록
# m[dx][dy]= 1    # 현재 좌표 방문처리
# steps = [(3, -1),(2,1),(1,1),(0,-1)]    # 방향 설정

# # 캐릭터 이동
# while turn != 4:
#     if d>0 : d -= 1 # 반시계방향 전환(3:서->2:남->1:동->0:북->3:서)
#     else : d+=3

#     for step in steps:  # 이동 가능한 방향 검사 후 이동
#         if d == step[0]:
#             if step[0] %2 == 1 and m[dx][dy+step[1]] == 0:
#                 m[dx][dy+step[1]]=1
#                 dx+=1
#                 count += 1
#                 turn = 0
#             elif step[0]%2 != 1 and m[dx+step[1]][dy] == 0:
#                 m[dx+step[1]][dy]=1
#                 dy+=1
#                 count += 1
#                 turn = 0
#             else: turn += 1

# # 출력
# print(count)

# N과 M을 공백으로 구분해 입력받기
n,m = map(int, input().split())

# 방문한 위치를 저장하기 위한 맵을 생성해 0을 초기화
d = [[0]*m for _ in range(n)]

# 현재 캐릭터의 x좌표, y좌표, 방향을 입력받기
x,y,direction = map(int, input().split())
d[x][y] = 1 # 현재 좌표 방문처리

# 전체 맵 정보 받기
array = []
for i in range(n):
    array.append(list(map(int, input().split())))
    
# 북, 동, 남, 서 방향 정의
dx = [-1, 0,1,0]
dy = [0,1,0,-1]

# 왼쪽으로 회전
def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3
        
# 시뮬레이션 시작
count = 1
turn_time = 0

while True:
    # 왼쪽으로 회전
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    # 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
    if d[nx][ny] == 0 and array[nx][ny] == 0:
        d[nx][ny] = 1
        x = d[nx]
        y = d[ny]
        count +=1
        turn_time = 0
        continue
    # 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
    else:
        turn_time += 1
    
    # 네 방향 모두 갈 수 없는 경우
    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]
        # 뒤로 갈 수 있다면 이동하기
        if array[nx][ny] == 0:
            x = nx
            y = ny
        # 뒤에 바다로 막혀있다면
        else:
            break
        turn_time = 0
        
print(count)