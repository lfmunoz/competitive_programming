/*

    https://www.udebug.com/UVa/902

    Note: Don't name variables same as functions i.e, max
    max = (max, number)  will work and return max
    i = 1,2,3,4,5; is equivalent to (i = 1),2,3,4,5; //  i = 1
    i = (1,2,3,4,5); seq is evaluated and gives 5 therefore // i = 5


*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

typedef unsigned int uint32;

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

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    int N;
    string line;
    map<string, int> freqTbl;

    while(!cin.eof()) {
        freqTbl.clear();
        cin >> N >> line >> ws;
        // cout << N << " " << line << endl;
        // cout << "--------------------" << endl;
        int maxFreq = 1;

        // CREATE FREQUENCY TABLE
        for(uint32 t = 0; t <= line.length() - N; t++) {
            string pw = line.substr(t, N);
            // cout << pw << endl;
            auto it = freqTbl.find(pw);
            if(it != freqTbl.end()) {
                it->second += 1;
                maxFreq = max(maxFreq, it->second);
                // cout << it->first << "::" << it->second <<  " max: " << maxFreq << endl;
            } else {
                freqTbl[pw] = 1;
            }
        }

        // FIND LARGEST IN FREQUENCY TABLE
        for(auto it = freqTbl.begin(); it != freqTbl.end(); it++) {
            // cout << it->first << "::" << it->second << endl;
            if(it->second == maxFreq) {
                cout << it->first << "\n";
                // break;
            }
        }
    }

    return 0;
}

#endif