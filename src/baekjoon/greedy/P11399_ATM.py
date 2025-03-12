N = int(input())
PI = list(map(int, input().split()))
result = 0
PI.sort()
for i in range(N):
    for j in range(0,i+1):
        result+=PI[j]

print(result)