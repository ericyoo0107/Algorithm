import queue

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
R, C = map(int, input().split())
maze = []
fire = [[0 for _ in range(C)] for _ in range(R)]
jihun = [[0 for _ in range(C)] for _ in range(R)]
for _ in range(R):
    line = input()
    maze.append(line)
q_fire = queue.Queue()
q_jihun = queue.Queue()
for r in range(R):
    for c in range(C):
        if maze[r][c] == '#':
            fire[r][c] = -1
            jihun[r][c] = -1
        if maze[r][c] == "J":
            q_jihun.put((r,c,1))
            jihun[r][c] = 1
        if maze[r][c] == "F":
            q_fire.put((r,c,1))
            fire[r][c] = 1


def FIRE_BFS():
    while (not q_fire.empty()):
        y, x, time = q_fire.get()
        for i in range(4):
            new_x = x + dx[i]
            new_y = y + dy[i]
            if 0 <= new_x < C and 0 <= new_y < R and (fire[new_y][new_x] == 0 or fire[new_y][new_x] > time+1):
                fire[new_y][new_x] = time + 1
                q_fire.put((new_y, new_x, time + 1))

def JIHUN_BFS():
    while (not q_jihun.empty()):
        y, x, time = q_jihun.get()
        for i in range(4):
            new_x = x + dx[i]
            new_y = y + dy[i]
            if 0 <= new_x < C and 0 <= new_y < R and (jihun[new_y][new_x] == 0 or jihun[new_y][new_x] > time+1):
                jihun[new_y][new_x] = time + 1
                q_jihun.put((new_y, new_x, time + 1))
FIRE_BFS()
JIHUN_BFS()
min = 10000000
for r in range(R):
    for c in range(C):
        if (jihun[r][c] < fire[r][c] or fire[r][c] == 0) and (r== 0 or c == 0 or r == R - 1 or c == C - 1) and jihun[r][c] != 0:
            if min > jihun[r][c]:
                min = jihun[r][c]

if min == 10000000 or min == -1:
    print("IMPOSSIBLE")
elif min==0: print(1)
else:
    print(min)
