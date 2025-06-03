#itertools 사용 금지
import itertools

N,S = map(int, input().split())
li = list(map(int, input().split()))
total = 0

'''

def combination(arr, n):
    result = []
    if n == 1:
        return [[i] for i in arr]
    for idx in range(len(arr)):
        elem = arr[idx]
        for rest in combination(arr[idx+1:], n-1):
            result.append([elem] + rest)
    return result


for i in range(1, len(li)+1):
    comb = combination(li, i)
    for res in comb:
        if sum(res) == S: total = total+1
'''
for i in range(1, len(li)+1):
    comb = itertools.combinations(li, i)
    for res in comb:
            if sum(res) == S: total = total+1
print(total)