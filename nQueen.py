
n =13
position = []

def isSafe(x, y, position, safe=True):
    if x >= n :
        return []
    else:
        for i in range(len(position)):
            if (x == position[i][0] or abs(y - position[i][1]) == abs(x - position[i][0])):
            #abs(y - position[i][1]) == abs(x - position[i][0]) same as y - x == position[i][1] - position[i][0] or y + x == position[i][1] + position[i][0]):
                safe = False
                break
            else:
                safe = True
    if not safe:
        return isSafe(x + 1, y, position, safe)
    return [x, y]

def logs(queen, position, x, y):
    print('queen', queen+1)
    print('pos', position)
    print('_________________________')

def check(x, y, queen, position, result=[]):
    result = isSafe(x, y, position)
    if queen == n:
        return True
    if len(result) > 1:
        x = result[0]
        y = result[1]
        putQueens(x, y, queen)
    else:
        prevQueen = queen - 1
        prevX = position[prevQueen][0]
        prevY = position[prevQueen][1]
        position.pop()
        check(prevX+1, prevY, prevQueen, position)
def putQueens(x=0, y=0, queen=0):
    position.append([x, y])
    logs(queen, position, x, y)
    check(0, y+1, queen+1, position)

putQueens()
