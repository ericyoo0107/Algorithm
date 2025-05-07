N, K = map(int, input().split())
money = []
result = 0
for i in range(N):
    m = int(input())
    money.append(m)
money.sort(reverse=True)

for m in money:
    if K >= m:
        result += K // m
        K = K%m

print(result)