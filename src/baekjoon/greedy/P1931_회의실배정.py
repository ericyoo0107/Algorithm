# 전제 : 시간이 오래걸리는 예약보다 시간이 짧게 걸리는 예약을 넣는게 무조건 이득이다
result = 1
N = int(input())
time = []
for i in range(N):
    a, b = map(int, input().split())
    time.append((a, b))
time.sort(key=lambda x: (x[1], x[0]))
temp = time[0][1]
del(time[0])
for reservation in time:
    if reservation[0] >= temp:
        temp = reservation[1]
        result += 1

print(result)
