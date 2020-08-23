/*

    https://www.udebug.com/UVa/10851


*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

using namespace std;

// ________________________________________________________________________________
// CODE 
// ________________________________________________________________________________


// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________


// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________
void initialize() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    #ifdef DEFAULT
        // freopen("input.txt", "r", stdin);
        // freopen("default.txt", "r", stdin);
    #endif

    std::cout << std::fixed;
    std::cout << std::setprecision(2);
}



// | oo o.ooo| -> oo o.ooo
string clean_string(string& aLine) {
    aLine.erase(10, 1); // |
    aLine.erase(6, 1); // .
    aLine.erase(1, 1); // space
    aLine.erase(0, 1); // |
    return aLine;
}

//  oooo.ooo -> 64
int string_to_int(string& aLine) {
    clean_string(aLine);
    int decodedValue = 0;
    for (std::string::size_type i = 0; i < aLine.size(); i++) {
        if(aLine[i] == 'o') {
            decodedValue = (64 >> i) + decodedValue;
        } 
    }
    return decodedValue;
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________
string START_END = "___________";

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;
    getline(cin, line);

    // return 0;

    while(true) {
        getline(cin, line);
        if(line.compare(START_END) == 0) break;
        int charAsInt = string_to_int(line);
            //  cout << charAsInt << endl;
        if(charAsInt > 31 && charAsInt < 127) {
            cout << (char) charAsInt;
        } else if(charAsInt == 10 || charAsInt == 13) {
            cout << "\n";
        } else if(charAsInt == 9 ) {
            cout << "\t";
        } else if(charAsInt == 8 ) {
            cout << "\b";
        } 
    }

    return 0;
}

#endif