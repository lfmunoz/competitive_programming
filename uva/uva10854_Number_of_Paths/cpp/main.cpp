/*

https://www.udebug.com/UVa/10854
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
int recurseIf();
int recurseElse();
int recurse();

int recurseIf() {
    string str; 
    int nPath = 1;
    while(cin >> str) {
        if (str == "IF")  {
            nPath*=recurseIf();
        } else if(str == "ELSE") {
            return nPath+recurseElse();
        }
    }
}

int recurseElse() {
    string str; 
    int nPath = 1;
    while(cin >> str) {
        if (str == "IF")  {
            nPath*=recurseIf();
        } else if(str == "END_IF") {
            return nPath;
        }
    }
}

int recurse() {
    string str; 
    int nPath = 1;
    while(cin >> str) {
        if (str == "IF")  {
            nPath*=recurseIf();
        } else if(str == "ENDPROGRAM") {
            return nPath;
        }
    }
}



// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    int P; 
    string line;

    cin >> P;
    for(int p = 0; p < P; p++) {
        cout << recurse() << "\n";
    }
}

#endif