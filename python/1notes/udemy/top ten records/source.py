import mysql.connector

con = mysql.connector.connect(
    user = "ardit700_student",
    password = "ardit700_student", 
    host = "108.167.140.122",
    database = "ardit700_pm1database"
)

word = input("What word do you want to define?")

cursor = con.cursor()
query = cursor.execute(f"SELECT Definition FROM Dictionary WHERE Expression LIKE '{word}'")
result = cursor.fetchall()

if result:
    for i in result:
        print(i[0])
else:
    print("That word isn't in the dictionary.")