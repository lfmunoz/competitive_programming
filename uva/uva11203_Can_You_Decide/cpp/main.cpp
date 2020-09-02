/*
    https://www.udebug.com/UVa/11203

    Notes: I had originally missed the condition
        if( x == 0 || y == 0 || z == 0) return false;
    Remember to always consider base case        
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

bool isValid(string theorem) {
    unsigned int x = 0, y = 0, z = 0;
    unsigned int idx = 0;

    for(; idx < theorem.length(); idx++) {
        if(theorem[idx] == 'M') break;
        if(theorem[idx] == '?') {
            x += 1;
            continue;
        }
        return false;
    }
    for( idx += 1; idx < theorem.length(); idx++) {
        if(theorem[idx] == 'E') break;
        if(theorem[idx] == '?') {
            y += 1;
            continue;
        }
        return false;

    }
    for( idx += 1; idx < theorem.length(); idx++) {
        if(theorem[idx] == '?') {
            z += 1;
            continue;
        }
        return false;
    }
    if( x == 0 || y == 0 || z == 0) return false;
    if( x + y == z) return true; 
    return false;

}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    int N;
    string line;

    cin >> N >> ws;
    // cout << N << endl;
    for(int n = 0; n < N; n++) {
        getline(cin, line);

        if(isValid(line)) {
            cout << "theorem" << "\n";
        } else {
            cout << "no-theorem" << "\n";
        }
    }


    return 0;
}

#endif
