import requests

def test_shuffle():
    input = {"list_of_ints" : [1,2,3,4,5]}
    #there's no reason for this not to work
    shuffled_list = requests.get('http://localhost:5000/shuffle', json = input).json().get('shuffled_list')
    
    #other attempts
    # shuffled_list = requests.get('http://host.docker.internal:5000/shuffle', json = input).json().get('shuffled_list')
    # shuffled_list = requests.get('http://0.0.0.0:5000/shuffle', json = input).json().get('shuffled_list')  
    # shuffled_list = requests.get('assignment4/shuffle', json = input).json().get('shuffled_list')
    
    assert input['list_of_ints'] != shuffled_list
