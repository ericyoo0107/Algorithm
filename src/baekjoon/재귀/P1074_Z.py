result = 0

def isSame(x,y,r,c):
    global result
    if x==c and y==r:
        print(result)
        return True
    return False

def Z (N, x, y, r, c):
    global result
    if N == 1:
        if(isSame(x,y,r,c)): return
        result+=1
        x+=1
        if(isSame(x,y,r,c)): return
        result += 1
        x-=1
        y+=1
        if(isSame(x,y,r,c)): return
        result += 1
        x+=1
        if(isSame(x,y,r,c)): return
        result += 1
        return
    num =  2 ** (N-1)
    Z(N-1, x, y, r, c)
    Z(N - 1, x+num, y, r, c)
    Z(N - 1, x, y+num, r, c)
    Z(N - 1, x+num, y+num, r, c)

N, r, c = map(int, input().split())
Z(N,0,0,r,c)