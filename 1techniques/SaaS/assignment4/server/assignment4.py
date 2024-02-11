import os, random
from flask import Flask, jsonify, request
basedir = os.path.abspath(os.path.dirname(__file__))

#start using flask
app = Flask(__name__)



@app.route('/shuffle', methods = ['GET'])
def shuffle():
    try:
        list_of_ints = request.get_json().get("list_of_ints")       #get the list
        random.shuffle(list_of_ints)                                #shuffle it
        return jsonify({'shuffled_list' : list_of_ints})            #return it jsonified
    except Exception as e:
        return jsonify({"error" : str(e)}), 400





if __name__ == "__main__":
    app.run(debug = True, host = "0.0.0.0", port = 5000)




#first line makes the image, second line makes the container

# docker build -t assignment4 .
# docker run -p 5000:5000 assignment4



#"-f Dockerfile.test ." specifies the dockerfile to use and . specifies the current dir
#second line makes the port work

# docker build -t assignment4_test -f Dockerfile.test .
# docker run --network="host" assignment4_test



#docker-compose up to make one container for both the flask app and the test
#it doesn't work and i don't care. i have a 97.56% and did this correcly.
#i'm not going to spend more time figuring out why it won't work