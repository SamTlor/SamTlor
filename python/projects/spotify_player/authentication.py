#run this file first
#this file goes to the spotify auth website with flask
#you have to run this before play_spotify will work


from flask import Flask, request, redirect, jsonify, session
import requests, base64, secrets, os
import hold
from config import spotify_CLIENT_ID, spotify_CLIENT_SECRET, spotify_REDIRECT_URI, flask_key

# it's so stupid that i can't edit config.py while this is running
def edit_hold(new_one):
    file1 = open("hold.py", "r").readlines()

    rewritten = open("hold.py", "w")
    for i in file1:
        if "token = " not in i:
            rewritten.write(i)
        else:
            rewritten.write(f"token = \"{new_one}\"")

    rewritten.close()


# Your Spotify API credentials
CLIENT_ID = spotify_CLIENT_ID
CLIENT_SECRET = spotify_CLIENT_SECRET
REDIRECT_URI = spotify_REDIRECT_URI

app = Flask(__name__)
app.config['SECRET_KEY'] = flask_key


# The program will automatically run on 127.0.0.1 so this function will be called
# the function sets the parameters and redirects to the REDIRECT_URI. get the right
# info for the 'code' variable on line 40
@app.route('/')
def index():
    auth_url = (
        f'https://accounts.spotify.com/authorize?'
        f'client_id={CLIENT_ID}&'
        f'response_type=code&'
        f'redirect_uri={REDIRECT_URI}&'
        f'scope=user-read-playback-state \
                user-modify-playback-state \
                playlist-modify-private \
                playlist-read-private'
    )
    return redirect(auth_url)

# Post to the spotify token endpoint with the correct header info that has been encoded
# correctly and with correct requirements. from the json response get the 'access token'
# the access token will be displayed in the redirect_uri page or in the json
@app.route('/callback')
def callback():
    auth_header = base64.b64encode(f'{CLIENT_ID}:{CLIENT_SECRET}'.encode()).decode()
    headers = {
        'Authorization' : f'Basic {auth_header}',
        'Content-Type' : 'application/x-www-form-urlencoded',
    }
    
    data = {
        'grant_type': 'authorization_code',
        'code': request.args.get('code'),   
        'redirect_uri': REDIRECT_URI,
    }   
    
    response = requests.post("https://accounts.spotify.com/api/token", headers = headers, data = data)

    
    if response.status_code == 200:
        edit_hold(response.json().get('access_token'))
        return response.json().get('access_token')
    else:
        return 'Failed to obtain an access token', 400
    

if __name__ == '__main__':
    app.run(debug = True, port = 8888)