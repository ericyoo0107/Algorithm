import itertools

def solution(k, dungeons):
    cases = list(itertools.permutations(dungeons))
    answer = 0
    for case in cases:
        tmpK = k
        tmpAns = 0
        for dungeon in case:
            if dungeon[0] <= tmpK:
                tmpAns+=1
                tmpK-=dungeon[1]
            else: break
        if answer < tmpAns:  answer = tmpAns
    return answer

k = 80
dungeons = [[80,20],[50,40],[30,10]]
print(solution(k, dungeons))