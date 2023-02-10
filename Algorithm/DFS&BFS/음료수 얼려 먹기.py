# 음료수 얼려 먹기 ( 시간제한 1초, 메모리 제한 128MB )

# 문제)
# N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시.
# 구멍이 뚫여 있는 부분끼리 상, 하, 좌, 우로 붙이 있는 경우 서로 연결되어 있는 것으로 간주
# 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.

# 입력조건)
# 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다(1 <= N,M <= 1,000)
# 두 번째 줄 부터 N +1 번째 줄까지 얼음 틀의 형태가 주어진다.

# N, M을 공백으로 구분하여 입력받기
N,M = map(int,input().split())

# 2차원 리스트의 맵 정보 입력받기
graph = []
for i in range(N):
    graph.append(list(map(int,input())))

# DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x,y):
    # 주어진 범위를 벗어나는 경우에는 즉시 종료
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False
    # 현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 0:
        # 해당 노드 방문 처리
        graph[x][y] = 1
        # 상, 하, 좌, 우의 위치도 모두 재귀적으로 호출
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

# 모든 노드(위치)에 대하여 음료수 채우기
result = 0
for i in range(N):
    for j in range(M):
        # 현재 위치에서 DFS 수행
        if dfs(i,j) == True:
            result += 1

print(result)
