/*

    https://www.udebug.com/UVa/10252

    Got presentation error because I had an new line at the end.

    Had three ideas
    1) sort a and b then try to align
    2) hashmap of each letter and then loop through one map and check
     if letter exists in the other map
    3) simply count the number of each letter

*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

using namespace std;

// ________________________________________________________________________________
// GLOBAL
// ________________________________________________________________________________

// ________________________________________________________________________________
// HELPER METHODS
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

// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________
map<char, int> tblA;
map<char, int> tblB;


void print_times(char c, int times) {
    while(times--) {
        cout << c;
    }
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________


#if !defined(IS_TEST)

int main() {
    initialize();
    string a, b;

    while(!cin.eof()) {
        tblA.clear();
        tblB.clear();
        getline(cin, a);
        getline(cin, b);
        // cout << a << endl;
        // cout << b << endl;
        for(auto it: a) {
            tblA[it] = (!tblA[it]) ? tblA[it] = 1 : tblA[it] + 1;
        }
        for(auto it: b) {
            tblB[it] = (!tblB[it]) ? tblB[it] = 1 : tblB[it] + 1;
        }

        for(char c = 'a'; c <= 'z'; c++) {
            int times = min(tblA[c], tblB[c]);
            print_times(c, times);
        }
        if(!cin.eof()) cout << "\n";
    }


    return 0;
}

#endif