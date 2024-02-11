from tttsettings import Settings

import pygame.font

class Button:
    def __init__(self, ttt_game, x_multiplier, y_multiplier):
        self.screen = ttt_game.screen
        self.screen_rect = self.screen.get_rect()

        self.width = self.screen.get_rect().width
        self.height = self.screen.get_rect().height

        self.button_color = (0,0,0)
        self.out_button_color = (0,255,0)
        self.text_color = (255,255,255)
        self.font = pygame.font.SysFont(None, 48)               #None means default font. 48 sets size of the text

        #creates a rectangle for the tile to exist in
                                #x position of the tile                 #y position of the tile                 #width              #height
        self.rect = pygame.Rect(self.width * (x_multiplier - 1/3) - 1, self.height * (y_multiplier - 1/3) - 1, self.width / 3 - 1, self.height / 3 - 1)
        self.out_rect = pygame.Rect(self.width * (x_multiplier - 1/3), self.height * (y_multiplier - 1/3), self.width / 3, self.height / 3)
        #position:    0 for left, 1/3 for center, 2/3 for right

        self.msg = ""
        self._prep_msg(self.msg)

    def _prep_msg(self, msg):
        self.msg_image = self.font.render(msg, True, self.text_color, self.button_color)
        self.msg_image_rect = self.msg_image.get_rect()
        self.msg_image_rect.center = self.rect.center

    def draw_button(self):
        self.screen.fill(self.button_color, self.rect)
        self.screen.fill(self.out_button_color, self.out_rect)
        self.screen.blit(self.msg_image, self.msg_image_rect)