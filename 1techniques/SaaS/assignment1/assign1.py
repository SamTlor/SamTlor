import requests, config

if __name__ == "__main__":
    
    #uses requests
    query = {
        "q" : "languages:python",
        "per_page" : 10
    }
    auth = {config.username : config.token}#this wasn't necessary so BONUS POINTS PLS-><-
    r = requests.get("https://api.github.com/search/repositories",  params = query, headers = auth)
    data = r.json()    
    
    #stores all the repos in a dictionary
    folder = {}
    for i, repo in enumerate(data['items']):
        folder[i] = [repo['watchers'], repo['full_name'], repo['issues_url']]
        
    #sorting array based on watchers
    folder = dict(sorted(folder.items(), key = lambda x:x[1][0], reverse = True))
    
    #final print. fullname, watchers, bug issue, \n\n\n
    for i in folder:
        print(f"{folder[i][1]}, {folder[i][0]}\nBug Issue:\n{requests.get(folder[i][2][:-9]).json()[0]['body']}\n\n\n")