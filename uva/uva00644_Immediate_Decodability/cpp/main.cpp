/*

    https://www.udebug.com/UVa/644

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
vector<string> codes;

bool isPrefix(string str, string prefix) {
    if(prefix.length() > str.length()) return false;
    std::size_t found = str.find(prefix);
    if(found == 0) return true;
    return false;
}

bool isDecodeable() {
    for(int codeIdx = 0; codeIdx < codes.size(); codeIdx++) {
        for(int prefixIdx = 0; prefixIdx < codes.size(); prefixIdx++) {
            if(codeIdx == prefixIdx) continue;
            if(isPrefix(codes[codeIdx], codes[prefixIdx])){
                return false;
            }
        }
    }
    return true;
}


// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;
    int n = 1;
    while(getline(cin, line)) {
        if(line == "9") {
            if(isDecodeable()) {
                cout <<  "Set " <<  n << " is immediately decodable\n";
            } else {
                cout <<  "Set " <<  n << " is not immediately decodable\n";
            }
            n += 1;
            codes.clear();
        } else {
            codes.push_back(line);
        }
    }
    return 0;
}

#endif