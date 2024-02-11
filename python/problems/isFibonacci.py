#i think this was for a class or something i don't remember anymore
#that's why the try statement is there

try:
    num = int(input("What number do you want to see if is in the fibonacci sequence?"))

    fib = [0,1]
    while(fib[-1] < num):
        addition = fib[-1] + fib[-2]            #f(n-1) + f(n-2)
        fib.append(addition)

    if num in fib:
        print("True")
    else:
        print("False")



except:
    print("https://www.reddit.com/r/ProgrammerHumor/comments/29kbnq/accurate_depiction_of_end_users/")