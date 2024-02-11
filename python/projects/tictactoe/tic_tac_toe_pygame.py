import pygame, sys

from tttsettings import Settings
from tttbutton import Button
from TictactoeClass import TictactoeClass

class Tic_tac_toe_pygame:
    def __init__(self):
        pygame.init()                                                                   #pygame initializer function
        self.settings = Settings()

        #screen
        self.screen = pygame.display.set_mode((0, 0), pygame.FULLSCREEN)                #fullscreen
        self.settings.screen_width = self.screen.get_rect().width                       #width
        self.settings.screen_height = self.screen.get_rect().height                     #height
        pygame.display.set_caption("Tic Tac Toe")                                       #title at the top of the browser
        self.bg_color = (230,230,230)

        #tiles
        self.tiles = []                                                                 #creates all of the tiles you can put stuff on
        self.board = []                                                                 #creates a list of values for the tiles
        for i in range(1,4):
            self.tiles.append([Button(self,i/3, j/3) for j in range(1,4)])              #self.tiles
            self.board.append([j.msg for j in self.tiles[i-1]])                           #self.board


        #win condition intializer
        self.win = TictactoeClass(self.tiles)                                           #instance of the tttclass that has check()

    #starts the actual game
    def run_game(self):
        self.player = 'X'                                                               #player
        while True:                                                                     #main loop for the game
            self._check_events()                                                        #anything that happens in the game
            self._update_screen()                                                       #put stuff on the screen
    
    def _check_events(self):                                                            #anything that happens in the game
        for event in pygame.event.get():                                                #FOR every event that happens in the game
            if event.type == pygame.MOUSEBUTTONDOWN:                                    #if the mouse is clicked
                mouse_pos = pygame.mouse.get_pos()
                x = self._check_tile(mouse_pos[0], self.settings.screen_width)          #which tile based on x
                y = self._check_tile(mouse_pos[1], self.settings.screen_height)         #which tile based on y

                if not self.board[x][y]:
                    self.tiles[x][y].msg = f"{self.player}"                             #change the value that get displayed
                    self.tiles[x][y]._prep_msg(self.player)

                    self.board[x][y] = f"{self.player}"                                 #change the value in the the board list

                    if not self.win.check(self.board):
                        print(f"{self.player}'s win!")
                        sys.exit()

                    if self.player == 'X':                                              #switches players
                        self.player = 'O'
                    else:
                        self.player = 'X'

            #if a button is pressed
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_q:
                sys.exit()
    
    def _check_tile(self, mouse_pos, direction):
        if mouse_pos < direction / 3:
            return 0
        elif mouse_pos < direction * 2 / 3:
            return 1
        else:
            return 2

    #makes the screen visible
    def _update_screen(self):
        self.screen.fill(self.settings.bg_color)
        
        for row in range(len(self.tiles)):
            for tile in range(len(self.tiles[row])):
                self.tiles[row][tile].draw_button()

        pygame.display.flip()                                                           #makes the most recently drawn screen visible

if __name__ == '__main__':
    ttt_game = Tic_tac_toe_pygame()
    ttt_game.run_game()