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
unsigned char set_bit(unsigned char *x, int bitNum) {
    return *x |= (1 << bitNum);
}

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
void itr_arr(string stringArr[]) {
    for(int i = 0; i < 8; i++) {
       cout << stringArr[i] << "\n";
    }
}

void decode(string stringArr[], int M) {
    for(int col = 1; col < M-1; col++) {
        unsigned char ourByte = 0;
        for(int i = 0; i < 8; i++) {
            if(stringArr[i][col] == '\\') {
                set_bit(&ourByte, i);
            }
        }
        cout << ourByte;
    }
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________
string START_END = "___________";

#if !defined(IS_TEST)

int main() {
    initialize();

    string line;
    int N;

    cin >> N; 
    cin.ignore(); // eat new line
    for(int n = 0; n < N; n++) {
        getline(cin, line);  /// START ROW
        int M = line.length();
        string stringArr[8];
        for(int i = 0; i < 8; i++) {
            getline(cin, line);
            stringArr[i] = line;
        }
        getline(cin, line); // END ROW
        getline(cin, line); // NEWLINE
        decode(stringArr, M);
        cout << "\n";
    }




    return 0;
}

#endif