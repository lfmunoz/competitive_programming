/*

    https://www.udebug.com/UVa/10298

    It was very tempting to be clever with this problem, meaing that
    I wanted to find a way to detect when a pattern repeated, something
    similar to what kmpPreprocess does.  Forget that just
    check each possibility starting from 1.
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
void initialize()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
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
bool isValid(const string &line, int size) {
    string match = line.substr(0, size);
    for (int i = 0; i < line.size(); i += size) {
        string compare = line.substr(i, size);
        if (compare != match) {
            return false;
        }
    }
    return true;
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________
string START_END = ".";

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;
    while (true) {
        getline(cin, line);
        if (line.compare(START_END) == 0) break;
        int size = 1;
        while (true) {
            if (line.size() % size != 0) {
                size += 1;
                continue;
            }
            if(isValid(line, size)) {
                cout << line.size() / size << "\n";
                break;
            } 
            size +=1;
        }
    }
    return 0;
}

#endif