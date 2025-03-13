exp = input()
result = 0
for i in range(len(exp)):
    isMinus = True
    if(exp[i] == "-"):
        exp = exp[:i+1] + "(" + exp[i+1:]
        isMinus = False
        for j in range(i+1, len(exp)):
            if(exp[j] == "-"):
                exp = exp[:j] + ")" + exp[j:]
                isMinus = True
                break
    if(isMinus is False):
        exp = exp + ")"
print(exp)
r = len(exp)
for i in range(r):
    if(i==0 and exp[i] =="0"):
        for j in range(i, r):
            exp = exp[i+1:]
            r-=1
            if(exp[0] != "0"): break
    if(i == r): break
    if(exp[i] == "(" or exp[i] == "+" or exp[i] == "-"):
        if(exp[i+1] == "0"):
            for j in range(i+1, r):
                if (exp[i + 1] != ")"): break
                exp = exp[:i+1] + exp[i+2:]
                r -= 1
                if (exp[i+1] != "0"): break
print(exp)
print(eval(exp))

''' 남의 코드
exp = input().split('-') #'-'를 기준으로 split해서 exp 리스트에 저장

num = [] #'-'로 나눈 항들의 합을 저장할 리스트

for i in exp:
    sum = 0
    tmp = i.split('+') #덧셈을 하기 위해서 '+'를 기준으로 split
    for j in tmp: #split한 리스트의 각 요소들을 더해줌
        sum += int(j)
    num.append(sum) #각 항의 연산 결과(덧셈)를 num에 저장

n = num[0] #식의 제일 처음은 숫자로 시작하기 때문에 0번째 값에서 나머지 값들을 빼준다

for i in range(1,len(num)): #1번째 값부터 n에서 빼준다
    n -= num[i]
print(n)

'''