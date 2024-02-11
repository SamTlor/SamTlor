import mysql.connector
from difflib import get_close_matches

con = mysql.connector.connect(
    user = "ardit700_student",
    password = "ardit700_student", 
    host = "108.167.140.122",
    database = "ardit700_pm1database"
)
def data(var):
    cursor = con.cursor()
    cursor.execute(f"SELECT * FROM Dictionary WHERE Expression = '{var}'")

def define(word):
    cursor = con.cursor()
    cursor.execute("SELECT * FROM Dictionary")
    result = cursor.fetchall()

    keys = []
    for i in result:
        keys.append(i[0])

    close = get_close_matches(word, keys)
    if len(close) > 0:
        for j in close:
            if input(f"Did you mean to type '{j}'?").upper() == "Y":
                return data(j)
    return keys



print(define(input("What word do you want to define?")))
