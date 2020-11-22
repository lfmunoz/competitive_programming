/*

    https://www.udebug.com/UVa/11475


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
// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;
    int position, j, i;
    while(cin >> line) {
        position = 0;
        j = 0;
        i = 0;
        // cout << line << endl;

        while(position < line.length()) {
            j = line.length() - 1;
            i = position;
            while(j > i && line[i] == line[j]) {
                j--;
                i++;
            }
            if( i < j) {
                position += 1;
            } else {
                break;
            }
        }

        string result = line;
        while(position--) {
            result += line[position];
        }
        cout << result << "\n";

    }


    return 0;
}

#endif