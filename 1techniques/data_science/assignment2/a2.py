import pandas as pd
import numpy as np
import time

# use the pandas functions fillna() and mean() to replace NaN values with the mean
# of the whole column. make a copy of the dataframe so that the original isn't 
# changed accidently
def mean_imput(correct, dataframe, name):
    start = time.time()
    
    final = dataframe.copy()
    for col in final.columns:
        final[col].fillna(round(final[col].mean(), 5), inplace = True)          #replace NaN values with the mean of the whole column
        
    end = time.time()
    print(f"MAE{name} = {mae(dataframe, correct, final): .4f}")
    print(f"Runtime{name} = {((end - start) * 1000): .2f}\n")

    return final

# ?'s have been turned into NaN values. This will go through a copy of the datataframe
# with missing values. Every time it finds a missing value with the isna() function it
# will go through a different dataframe without any missing values. it will score each
# row based on the sum of the differences between each feature. It will then replace the
# missing value with the value or values from the lowest scored row
def hot_deck(correct, dataframe, name):
    start = time.time()

    #imputation function really starts
    final = dataframe.copy()                                                    #final return dataframe
    non_nan_data = dataframe.dropna()                                           #dataframe without missing values
    for index, nan_row in dataframe.iterrows():                                 #go through every row
        if nan_row.isna().any():                                                #for the rows that have a missing value
            lowest_score = np.inf                                               #store the best match
            lowest_row = None                                                   #store the best row match
            
            mis_col = [col for col, value in nan_row.items() if pd.isna(value)] #save the column that has the missing value
            for _, non_nan_row in non_nan_data.iterrows():                      #go through all the non missing rows
                this_row_score = np.abs(nan_row - non_nan_row).sum()            #save the distance from this object

                if this_row_score < lowest_score:                               #store the best match
                    lowest_score = this_row_score
                    lowest_row = non_nan_row
            for i in mis_col:
                final.iloc[index][i] = round(lowest_row[i], 4)
    #imputation function really ends
    
    end = time.time()
    print(f"MAE{name} = {mae(dataframe, correct, final): .4f}")
    print(f"Runtime{name} = {((end - start) * 1000): .2f}\n")

    return final

# store a final sum of all of the differences between the correct data and the imputed data.
# for all of the NaN values in the original find the difference between the imputed value
# and the correct value. then add the abs value of that to the final. return final / length
def mae(original, correct, test):
    off_final = 0                                                                   #sum of all differences
    for index, nan_row in original.iterrows():                                      #get an index for the length of both datasets
        if nan_row.isna().any():                                                    #use the loop to find all the times there were NaN values
            mis_col = [col for col, value in nan_row.items() if pd.isna(value)]     #save the columns with NaN values
            
            for col in mis_col:                                                     #for just the columns with NaN values
                off_final += np.abs(correct.loc[index, col] - test.loc[index, col]) #find the abs difference and add it to the sum
        
    return off_final / correct.shape[0]                                             #divide by the length of the dataframe



if __name__ == "__main__":
    #bring in the csv files
    zer_perc = pd.read_csv("dataset_complete.csv")
    one_perc = pd.read_csv("dataset_missing01.csv", na_values = ['?'])
    ten_perc = pd.read_csv("dataset_missing10.csv", na_values = ['?'])
        
    #convert to numeric
    for col in zer_perc.columns:
        zer_perc[col] = zer_perc[col].apply(pd.to_numeric, errors = 'coerce')
        one_perc[col] = one_perc[col].apply(pd.to_numeric, errors = 'coerce')
        ten_perc[col] = ten_perc[col].apply(pd.to_numeric, errors = 'coerce')

    #call the imput functions
    one_perc_imped = mean_imput(zer_perc, one_perc, "_01_mean")
    one_perc_hoted = hot_deck(zer_perc, one_perc, "_01_hd")
    ten_perc_imped = mean_imput(zer_perc, ten_perc, "_10_mean")
    ten_perc_hoted = hot_deck(zer_perc, ten_perc, "_10_hd")
    
    #to csv
    one_perc_imped.to_csv("V00798059_missing01_imputed_mean.csv", index = False)
    one_perc_hoted.to_csv("V00798059_missing01_imputed_hd.csv", index = False)
    ten_perc_imped.to_csv("V00798059_missing10_imputed_mean.csv", index = False)
    ten_perc_hoted.to_csv("V00798059_missing10_imputed_hd.csv", index = False)