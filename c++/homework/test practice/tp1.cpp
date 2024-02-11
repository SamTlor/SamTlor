#include <iostream>

using namespace std;


int main(){
    int year, init = 1626;
    float value = 24.00;

    cout << "What is the year?";
    cin >> year;

    for (init; init < year; init++){
        value += (value*.06);
    }

    cout << "\nThey would now have: $" << value;

    return 0;

}

