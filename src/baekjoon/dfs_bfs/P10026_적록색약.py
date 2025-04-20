import queue

n = int(input())
img = [['X'] * n for _ in range(n)]
check = [[False] * n for _ in range(n)]
res_1, res_2 = 0,0

for i in range(n):
    line = input()
    for j in range(n):
        img[i][j] = line[j]


def BFS(i, j):
    q = queue.Queue()
    check[i][j] = True
    q.put([i,j])
    while q.empty() == False:
        get = q.get()
        x = get[0]
        y = get[1]
        color = img[x][y]
        check[x][y] = True
        if x-1 >= 0 and check[x-1][y] == False and img[x-1][y] == color:
            q.put([x-1,y])
        if x+1 < n and check[x+1][y] == False and img[x+1][y] == color:
            q.put([x+1, y])
        if y-1 >= 0 and check[x][y-1] == False and img[x][y-1] == color:
            q.put([x, y-1])
        if y+1 < n and check[x][y+1] == False and img[x][y+1] == color:
            q.put([x, y+1])

# res1
for i in range(n):
    for j in range(n):
        if(check[i][j] == False):
            res_1 +=1
            BFS(i,j)

check = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if(img[i][j] != 'B'):
            img[i][j] = 'R'
# res2
for i in range(n):
    for j in range(n):
        if(check[i][j] == False):
            res_2 += 1
            BFS(i,j)

print(res_1, res_2)