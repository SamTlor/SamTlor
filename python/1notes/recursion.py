def list_sum(num_list):                                 #name of the method
    if len(num_list) == 1:                              #stopping point
        return num_list[0]                              
    else:                                               #how it recurrs
        return num_list[0] + list_sum(num_list[1:])     #gets the first number from list and creates a new list without that number
                                                        #keeps doing that until there's only one number

                                                        #gets that value and adds it to the second to last number and returns that value
                                                        #that value is returned and added to the third to last number
                                                        #etc.
print(list_sum([1,2,3,4,5]))
