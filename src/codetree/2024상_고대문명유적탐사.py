import queue
import copy

K, M = map(int, input().split())
item = []
for i in range(5):
    item.append(list(map(int, input().split())))
itemPiece = list(map(int, input().split()))
idx = 0
def rotate(temp, i, j):
    degree = 0
    max = 0
    if i == 2 and j == 2:
        a = 10
    for cnt in range(4):  # 90도 씩 4번 돌림
        bfs = BFS(temp)  # 유물 몇개 얻을수 있는지 체크
        if (bfs > max):
            max = bfs
            degree = cnt * 90
        temp2 = copy.deepcopy(temp)
        temp[i - 1][j + 1] = temp2[i - 1][j - 1]
        temp[i][j + 1] = temp2[i - 1][j]
        temp[i + 1][j + 1] = temp2[i - 1][j + 1]
        temp[i + 1][j] = temp2[i][j + 1]
        temp[i + 1][j - 1] = temp2[i + 1][j + 1]
        temp[i][j - 1] = temp2[i + 1][j]
        temp[i - 1][j - 1] = temp2[i + 1][j - 1]
        temp[i - 1][j] = temp2[i][j - 1]
    return degree, max


def BFS(temp):
    total = 0
    check = [[False] * 5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            tempTotal = 0
            q = queue.Queue()
            q.put([i, j, temp[i][j]])
            tempTotal += 1
            check[i][j] = True
            while (q.empty() is False):
                now = (q.get())
                if int(now[0] + 1) < 5 and temp[now[0] + 1][now[1]] == now[2] and check[now[0] + 1][now[1]] == False:
                    q.put([now[0] + 1, now[1], temp[now[0] + 1][now[1]]])
                    tempTotal += 1
                    check[now[0] + 1][now[1]] = True
                if int(now[0] - 1) >= 0 and temp[now[0] - 1][now[1]] == now[2] and check[now[0] - 1][now[1]] == False:
                    q.put([now[0] - 1, now[1], temp[now[0] - 1][now[1]]])
                    tempTotal += 1
                    check[now[0] - 1][now[1]] = True
                if int(now[1] + 1) < 5 and temp[now[0]][now[1] + 1] == now[2] and check[now[0]][now[1] + 1] == False:
                    q.put([now[0], now[1] + 1, temp[now[0]][now[1] + 1]])
                    tempTotal += 1
                    check[now[0]][now[1] + 1] = True
                if int(now[1] - 1) >= 0 and temp[now[0]][now[1] - 1] == now[2] and check[now[0]][now[1] - 1] == False:
                    q.put([now[0], now[1] - 1, temp[now[0]][now[1] - 1]])
                    tempTotal += 1
                    check[now[0]][now[1] - 1] = True
            if tempTotal >= 3: total += tempTotal
    return total

def getItem(i, j, degree):
    for cnt in range(degree//90):  # 90도 씩 4번 돌림
        temp = copy.deepcopy(item)
        item[i - 1][j + 1] = temp[i - 1][j - 1]
        item[i][j + 1] = temp[i - 1][j]
        item[i + 1][j + 1] = temp[i - 1][j + 1]
        item[i + 1][j] = temp[i][j + 1]
        item[i + 1][j - 1] = temp[i + 1][j + 1]
        item[i][j - 1] = temp[i + 1][j]
        item[i - 1][j - 1] = temp[i + 1][j - 1]
        item[i - 1][j] = temp[i][j - 1]
    allPos = BFS2()
    return allPos

def BFS2():
    check = [[False] * 5 for _ in range(5)]
    pos = []
    for i in range(5):
        for j in range(5):
            tempTotal = 0
            tempPos = []
            q = queue.Queue()
            q.put([i, j, item[i][j]])
            tempTotal += 1
            check[i][j] = True
            while (q.empty() is False):
                now = (q.get())
                tempPos.append([now[0], now[1]])
                if int(now[0] + 1) < 5 and item[now[0] + 1][now[1]] == now[2] and check[now[0] + 1][now[1]] == False:
                    q.put([now[0] + 1, now[1], item[now[0] + 1][now[1]]])
                    tempTotal += 1
                    check[now[0] + 1][now[1]] = True
                if int(now[0] - 1) >= 0 and item[now[0] - 1][now[1]] == now[2] and check[now[0] - 1][now[1]] == False:
                    q.put([now[0] - 1, now[1], item[now[0] - 1][now[1]]])
                    tempTotal += 1
                    check[now[0] - 1][now[1]] = True
                if int(now[1] + 1) < 5 and item[now[0]][now[1] + 1] == now[2] and check[now[0]][now[1] + 1] == False:
                    q.put([now[0], now[1] + 1, item[now[0]][now[1] + 1]])
                    tempTotal += 1
                    check[now[0]][now[1] + 1] = True
                if int(now[1] - 1) >= 0 and item[now[0]][now[1] - 1] == now[2] and check[now[0]][now[1] - 1] == False:
                    q.put([now[0], now[1] - 1, item[now[0]][now[1] - 1]])
                    tempTotal += 1
                    check[now[0]][now[1] - 1] = True
            if tempTotal >= 3: pos.append(tempPos)
    return pos

def zeroItem(targets):
    for targetPos in targets:
        for pos in targetPos:
            item[pos[0]][pos[1]] = 0

def changeItem():
    global idx
    for j in range(5):
        for i in range(4,-1,-1):
            if(item[i][j] == 0):
                if idx==M: idx=0
                item[i][j] = itemPiece[idx]
                idx+=1

for _ in range(K):
    result = 0
    rotateVal = {}  # (좌표, 각도) : 값
    for i in range(1, 4):
        for j in range(1, 4):
            temp = copy.deepcopy(item)
            degree, value = rotate(temp, i, j)  # 특정 좌표에서 어떤 각도의 Value가 최대인지 반환
            rotateVal[(i, j, degree)] = value
    # 1. 값이 큰 좌표 찾기
    rotateValues = rotateVal.values()
    maxValue = max(rotateValues)
    if(maxValue < 3) : break
    maxValuePos = []
    result+=maxValue
    for val in rotateVal.items():
        if(maxValue == val[1]): maxValuePos.append(val[0])
    # 2. 회전 각도 작은 좌표 찾기
    minRotateMaxValuePos = []
    minRotate = 1000
    for rotateValue in maxValuePos:
        if(rotateValue[2] < minRotate): minRotate = rotateValue[2]
    for rotateValue in maxValuePos:
        if(rotateValue[2] == minRotate): minRotateMaxValuePos.append(rotateValue)
    # 3. 열이 작은 것 좌표 찾기
    resultPos1 = []
    minCol = 10
    for val in minRotateMaxValuePos:
        if (val[1] < minCol): minCol = val[1]
    for val in minRotateMaxValuePos:
        if (val[1] == minCol): resultPos1.append(val)
    # 4. 행이 작은 것 좌표 찾기
    resultPos2 = []
    minRow = 10
    for val in resultPos1:
        if (val[1] < minRow): minRow = val[1]
    for val in minRotateMaxValuePos:
        if (val[1] == minRow): resultPos2.append(val)
    # 작업
    allPos = getItem(resultPos2[0][0], resultPos2[0][1], resultPos2[0][2])
    zeroItem(allPos)
    changeItem()

    # 유물 연쇄 획득
    while(True):
        allPos = getItem(2, 2, 0)
        if len(allPos) == 0: break
        for pos in allPos:
            result += len(pos)
        zeroItem(allPos)
        changeItem()

    print(result, end=" ")