result = []

# 입력
N = int(input())
map = []
check = [[0]*N for _ in range(N)]
for i in range(N):
    line = input()
    mapLine = []
    for j in range(N):
        mapLine.append(int(line[j]))
    map.append(mapLine)

def BFS(i, j):
    temp = 0
    queue = []
    queue.append((i, j))
    check[i][j] = 1
    while(len(queue) != 0):
        dy, dx = queue[0]
        del(queue[0])
        temp+=1
        if (dy-1) >= 0 and check[dy-1][dx] == 0 and map[dy-1][dx] != 0:
            queue.append((dy-1, dx))
            check[dy - 1][dx] = 1
        if (dy+1) < N and check[dy+1][dx] == 0 and map[dy+1][dx] != 0:
            queue.append((dy+1, dx))
            check[dy + 1][dx] = 1
        if (dx-1) >= 0 and check[dy][dx-1] == 0 and map[dy][dx-1] != 0:
            queue.append((dy, dx-1))
            check[dy][dx - 1] = 1
        if (dx+1) < N and check[dy][dx+1] == 0 and map[dy][dx+1] != 0:
            queue.append((dy, dx+1))
            check[dy][dx + 1] = 1
    result.append(temp)

for i in range(N):
    for j in range(N):
        if check[i][j] == 0 and map[i][j] != 0:
            BFS(i,j)

print(len(result))
result.sort()
for i in range(len(result)):
    print(result[i])