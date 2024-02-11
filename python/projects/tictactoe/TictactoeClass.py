import sys

class TictactoeClass:

    def __init__(self, tiles):
        self.var = tiles

    def equal(self, tics):
        if not all(tics):
            return False

        if tics[0] == tics[1] and tics[0] == tics[2]:
            return True
        else:
            return False

    def check(self, board):
        back = []
        row = []
        for i in range(3):
            if self.equal(board[i]):                            #horizontal
                return False

            vert = []                                           #vertical
            for j in range(3):
                vert.append(board[j][i])
            if self.equal(vert):
                return False
                            
            back.append(board[i][i])                            #diagonal top left --> bottom right
            row.append(all(board[i]))
        if self.equal(back):
            return False

        forw = [board[0][2], board[1][1], board[2][0]]
        if self.equal(forw):                                    #diagonal top right --> bottom left
            return False
        if all(row):
            print("it's a tie")
            sys.exit()
        return True