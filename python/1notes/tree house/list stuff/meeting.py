games = ['overwatch 2', 'cuphead dlc', 'cyberpunk 2077']
movies = ['tenet', 'black widow', 'doctor strange 2']

def wishlist (thing, wish):
    copy = wish.copy()
    suggested = copy.pop(0)
    print("\nThis is the {} that he wants the most: {}".format(thing, suggested))
    print("These will work too tho: ")
    for i in copy:
        print("* " + i)

wishlist("Video game", games)
wishlist("Movie", movies)
wishlist("Movie", movies)