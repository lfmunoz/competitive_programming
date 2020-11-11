/*

    https://www.udebug.com/UVa/00012


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

template <typename T>
std::ostream& operator<< (std::ostream& out, const std::vector<T>& v) {
  if ( !v.empty() ) {
    out << '[';
    std::copy (v.begin(), v.end(), std::ostream_iterator<T>(out, ", "));
    out << "\b\b]";
  }
  return out;
}



// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________
bool verifyPattern(vector<uint> &pattern, uint steps) {
    uint i = 0;
    for(uint p: pattern) {
        if(i == steps) { i = 0; }
        // cout << "checking " << p << " is same as " << pattern[i] << endl;
        if(p == pattern[i]) {
            i += 1;
            continue;
        } else {
            return false;
        }
    }
    return true;
}

vector<uint> find_pattern(string line) {
    // maximum pattern length happens when we just repeat twice
    uint maxPatternLength = line.size() / 2;
    vector<uint> pattern; 
    for_each(line.begin(), line.end(), [&pattern](const char &c) {
        pattern.push_back((uint) (c - '0'));
        // cout << c << endl;
    });
    while(maxPatternLength > 1) {
        if(verifyPattern(pattern, maxPatternLength)) break;
        maxPatternLength -= 1;
    }
    pattern.resize(maxPatternLength);
    return pattern;
}


// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;
    uint N;

    cin >> N;
    while(N--) {
        cin >> line;
        vector<uint> pattern = find_pattern(line);
        // cout << "pattern=" << pattern << endl; 
        auto itr = pattern.begin();
        for(uint i = 0; i < line.size(); i++ ) {
            if(itr == pattern.end()) { itr = pattern.begin(); }
            itr++;
        }
        for(uint i = 0; i < 8; i++ ) {
            if(itr == pattern.end()) { itr = pattern.begin(); }
            cout << *itr;
            itr++;
        }
        cout << "..." << "\n";
    }

    return 0;
}

#endif