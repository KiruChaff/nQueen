import sys;sys.setrecursionlimit(16000)
class NQueen:
    def __init__(self, n):
        self.position=[]
        self.n=n
        self.putQueens()
    def _isSafe(self, x, y, safe=True):
        if x>=self.n:
            return[]
        else:
            for i in range(len(self.position)):
                pos_x=self.position[i][0]
                pos_y=self.position[i][1]
                if (x==pos_x or abs(y-pos_y)==abs(x-pos_x)):
                # abs(y-pos_y)==abs(x-pos_x) same as y-x==pos_y-pos_x or y+x==pos_y+pos_x):
                    return self._isSafe(x+1, y)
        return[x, y]
    def _check(self, x, y, queen, result=[]):
        result=self._isSafe(x, y)
        if queen==self.n:
            return
        if len(result)>1:
            x=result[0]
            y=result[1]
            self.putQueens(x, y, queen)
        else:
            prevQueen=queen-1
            prevX=self.position[prevQueen][0]
            prevY=self.position[prevQueen][1]
            self.position.pop()
            self._check(prevX+1, prevY, prevQueen)
    def putQueens(self, x=0, y=0, queen=0):
        self.position.append([x, y])
        self._check(0, y+1, queen+1)
    def next(self):
        x=self.position[self.n-1][0]+1
        y=self.position[self.n-1][1]
        self.position.pop()
        self._check(x, y, self.n-1)
chess_board=NQueen(8)

# first_pos=chess_board.position
# print(first_pos)
# chess_board.next()
# second_pos=chess_board.position
# print(second_pos)

for i in range(1,92):
    pos=chess_board.position;chess_board.next()
    print("%d :" %i ,pos)
