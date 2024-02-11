#this runs on my personal raspberry pi every day


import requests, random, os
from flask import request
from pprint import pprint
import authentication
import webbrowser, pyautogui, time, pyperclip
from config import sam_unorg, needle_drop


#use the authentication file to connect to the spotify api
file1 = open("hold.py", "r").readlines()
old_one = None
for i in file1:
    if "token = " in i:
        old_one = i.split("token = \"", 1)[1][:-1]

webbrowser.open(authentication.REDIRECT_URI[:-8])

new_one = old_one
while old_one == new_one:
    file1 = open("hold.py", "r").readlines()
    for i in file1:
        if "token = " in i:
            new_one = i.split("token = \"", 1)[1][:-1]
access_token = new_one



#TODO: store the total number of songs with the rest of the info in the other file
#use that number as the second param in this random number generator
#while doing the rest of this check if the total number of songs has increased
# if it has change the number in the other file

# sam_unorg is the exact id of the "sams unorganized" playlist
selected_index = random.randint(0, 1340)
playlist_url = f"https://api.spotify.com/v1/playlists/{sam_unorg}/tracks?offset={selected_index}"
headers = {
    "Authorization" : f"Bearer {access_token}",
    "Content-Type" : "application/json"
}

response = requests.get(playlist_url, headers = headers)

selected_song_id = response.json()['items'][0]['track']['id']





webbrowser.open(f"https://open.spotify.com/track/{needle_drop}")
time.sleep(5)
pyautogui.click(944, 1589)
time.sleep(5)



# Spotify API endpoint to play a track
playback_url = "https://api.spotify.com/v1/me/player/play"

# Spotify URI of the track you want to play
track_uri = f"spotify:track:{selected_song_id}"

headers = {
    "Authorization": f"Bearer {access_token}",
    "Content-Type": "application/json",
}

playback_data = {
    "uris": [track_uri],
}

response = requests.put(playback_url, json=playback_data, headers=headers)

if response.status_code == 204:
    print("Song is playing.")
else:
    print("Failed to play the song. Status code:", response.status_code)