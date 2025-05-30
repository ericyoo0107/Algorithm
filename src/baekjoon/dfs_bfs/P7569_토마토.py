import queue

# 초기 입력
dx = [1,0,-1,0,0,0]
dy = [0,1,0,-1,0,0]
dz = [0,0,0,0,1,-1]

M, N, H = map(int, input().split())
box = []
for h in range(H):
    floor = []
    for n in range(N):
        line = list(map(int, input().split()))
        floor.append(line)
    box.append(floor)

q = queue.Queue()
# BFS 함수
def BFS():
    global box
    while (not q.empty()):
        x, y, z, day = q.get()
        for i in range(6):
            new_x = x + dx[i]
            new_y = y + dy[i]
            new_z = z + dz[i]
            if M > new_x >=0 and N > new_y >= 0 and H > new_z >=0 :
                if box[new_z][new_y][new_x] == 0 or box[new_z][new_y][new_x] > day+1 :
                    box[new_z][new_y][new_x] = day+1
                    q.put((new_x,new_y,new_z,day+1))

# MAIN
for h in range(H):
    for n in range(N):
        for m in range(M):
            if(box[h][n][m] == 1):
                q.put((m,n,h,1))
BFS()
flag = False
max = 0
for h in range(H):
    for n in range(N):
        for m in range(M):
            if (box[h][n][m] > max): max = box[h][n][m]
            if (box[h][n][m] == 0): flag = True

if flag == True: print(-1)
else: print(max-1)