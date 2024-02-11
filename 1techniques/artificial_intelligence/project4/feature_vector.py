import sys, string
import proj_code.Porter_Stemmer_Python


# words = []
# stops = [line for line in open("Project4_stop_words.txt", "r")]

# for line in open("Project4_paragraphs.txt", "r"):
#     for word in line.split():
#         word = word.translate(str.maketrans('', '', string.punctuation)).lower()
        
#         if word.isdigit() or word in stops or word == "<br />":
#             continue
#         if word not in words:
#             words.append(word)          

# for i in words:
#     print(i)









sys.argv.extend(["Project4_paragraphs.txt"])
pars = proj_code.Porter_Stemmer_Python.main()
stops = [line for line in open("Project4_stop_words.txt", "r")]

for par in pars:
    text = ' '.join(par)
    words = par.split()
    uniques = []
    
    for word in words:
        if word in stops or word == "<br />":
            continue
        if word not in uniques:
            uniques.append(word)
        
    # for j in uniques:
    #     print(j)
    print(uniques)