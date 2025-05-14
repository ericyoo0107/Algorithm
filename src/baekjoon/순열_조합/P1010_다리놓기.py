T = int(input())
NM = []
result = []
for _ in range(T):
    n,m = map(int, input().split())
    NM.append((n,m))

for n, m in NM:
    temp = 1
    for i in range(m, m-n, -1):
        temp *= i
    for i in range(1, n+1):
        temp //= i
    result.append(temp)

for i in result:
    print(i)