/*

   https://www.udebug.com/UVa/11576


*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

typedef unsigned int uint;

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
int isMatch (const string &result, const string &line, int pos) {
    for ( int i = pos; i < result.size (); i++ ) {
        if ( result[i] != line[i - pos] ) return false;
    }
    return true;
}


// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    string result, line;
    int n, k, w;

    cin >> n;
    while(n--) {
        cin >> k >> w;
        result = "";
        while(w--) {
            cin >> line;
            if(result.begin() == result.end()) {
                result += line;
                continue;
            }
            int R = result.size();
            int cut = 0;
            for(int r = R - k; r < R; r++) {
                if( isMatch(result, line, r)) {
                    cut = R - r;
                    break;
                }
            }
            result += line.substr(cut);
        }
        cout << result.size() << "\n";
    }

 

    return 0;
}

#endif