def findMaxSeat(emptySeat, maxPos):
    max = 0
    for column, row in maxPos:
        if emptySeat[column][row] > max : max = emptySeat[column][row]
    return max

N = int(input())
friend = []
attraction = [[0] * N for _ in range(N)]
emptySeat = [[0] * N for _ in range(N)]
result = 0

for column in range(N):
    for row in range(N):
        count = 0
        if (column - 1 >= 0):
            count += 1
        if (column + 1 < N):
            count += 1
        if (row - 1 >= 0):
            count += 1
        if (row + 1 < N):
            count += 1
        emptySeat[column][row] = count

for i in range(N * N):
    friend.append(list(map(int, input().split())))

# 자리 배치
for i in range(N * N):
    friendCount = [[0] * N for _ in range(N)]
    for column in range(N):
        for row in range(N):
            if (attraction[column][row] == 0):  # 자리 비어있으면
                for cnt in range(1, 5): # 주변에 좋아하는 친구 있는지 확인
                    likeFriend = friend[i][cnt]
                    if (column - 1 >= 0 and attraction[column - 1][row] == likeFriend):
                        friendCount[column][row] += 1
                    elif (column + 1 < N and attraction[column + 1][row] == likeFriend):
                        friendCount[column][row] += 1
                    elif (row - 1 >= 0 and attraction[column][row - 1] == likeFriend):
                        friendCount[column][row] += 1
                    elif (row + 1 < N and attraction[column][row + 1] == likeFriend):
                        friendCount[column][row] += 1
    maxValue = max(max(row) for row in friendCount) # 주변에 친한 친구가 많은
    maxPos = [] # 가장 좋아하는 친구가 많음
    maxPos2 = [] # 가장 빈자리가 많은
    for column in range(N): # 가장 좋아하는 친구가 많은 좌표 찾기
        for row in range(N):
            if(friendCount[column][row] == maxValue):
                maxPos.append([column, row])
    if len(maxPos)==1: # 좋아하는 친구 가장 많은 자리가 1곳이면
        attraction[maxPos[0][0]][maxPos[0][1]] = friend[i][0]  # 앉아
        if (maxPos[0][0] - 1 >= 0): emptySeat[maxPos[0][0] - 1][maxPos[0][1]] -= 1
        if (maxPos[0][0] + 1 < N):  emptySeat[maxPos[0][0] + 1][maxPos[0][1]] -= 1
        if (maxPos[0][1] - 1 >= 0): emptySeat[maxPos[0][0]][maxPos[0][1] - 1] -= 1
        if (maxPos[0][1] + 1 < N): emptySeat[maxPos[0][0]][maxPos[0][1] + 1] -= 1
        emptySeat[maxPos[0][0]][maxPos[0][1]] = -1
    elif not len(maxPos) == 1: # 좋아하는 친구 가장 많은 자리가 1곳 이상 이면
        for column, row in maxPos:
            maxSeat = findMaxSeat(emptySeat, maxPos)  # 비어있는 자리가 많은
            if(maxSeat == emptySeat[column][row]):
                maxPos2.append([column, row])
        minColumn = min(column for column, row in maxPos2) # 가장 작은 Column
        target_c = [pos for pos in maxPos2 if pos[0] == minColumn] # 가장 작은 Column의 전체 좌표
        if(len(target_c) == 1):
            attraction[target_c[0][0]][target_c[0][1]] = friend[i][0]  # 앉아
            if (target_c[0][0] - 1 >= 0): emptySeat[target_c[0][0] - 1][target_c[0][1]] -= 1
            if (target_c[0][0] + 1 < N): emptySeat[target_c[0][0] + 1][target_c[0][1]] -= 1
            if (target_c[0][1] - 1 >= 0): emptySeat[target_c[0][0]][target_c[0][1] - 1] -= 1
            if (target_c[0][1] + 1 < N): emptySeat[target_c[0][0]][target_c[0][1] + 1] -= 1
            emptySeat[target_c[0][0]][target_c[0][1]] = -1
        else:
            minRow = min(row for column, row in maxPos2)
            target_r = [pos for pos in maxPos2 if pos[0] == minRow]
            if(len(target_r) >= 1):
                attraction[target_r[0][0]][target_r[0][1]] = friend[i][0]  # 앉아
                if (target_r[0][0] - 1 >= 0): emptySeat[target_r[0][0] - 1][target_r[0][1]] -= 1
                if (target_r[0][0] + 1 < N): emptySeat[target_r[0][0] + 1][target_r[0][1]] -= 1
                if (target_r[0][1] - 1 >= 0): emptySeat[target_r[0][0]][target_r[0][1] - 1] -= 1
                if (target_r[0][1] + 1 < N): emptySeat[target_r[0][0]][target_r[0][1] + 1] -= 1
                emptySeat[target_r[0][0]][target_r[0][1]] = -1


for column in range(N):
    for row in range(N):
        nearFriend = 0
        target = attraction[column][row]
        if (row - 1 >= 0):
            for aFriend in friend:
                if aFriend[0] == target:
                    for i in range(1,5):
                        if aFriend[i] == attraction[column][row-1]: nearFriend+=1
        if (row + 1 < N):
            for aFriend in friend:
                if aFriend[0] == target:
                    for i in range(1,5):
                        if aFriend[i] == attraction[column][row+1]: nearFriend+=1
        if (column - 1 >= 0):
            for aFriend in friend:
                if aFriend[0] == target:
                    for i in range(1,5):
                        if aFriend[i] == attraction[column-1][row]: nearFriend+=1
        if (column + 1 < N):
            for aFriend in friend:
                if aFriend[0] == target:
                    for i in range(1,5):
                        if aFriend[i] == attraction[column+1][row]: nearFriend+=1

        if nearFriend == 0 : result+=0
        elif nearFriend == 1: result += 1
        elif nearFriend == 2: result += 10
        elif nearFriend == 3: result += 100
        elif nearFriend == 4: result += 1000

print(result)