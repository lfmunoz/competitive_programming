/*

  https://www.udebug.com/UVa/11878

    Straight forward problem

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
class HwProblem {

    public:
        int a;
        int b;
        int c;
        bool isAddition;

        HwProblem() {
            a = 0, b = 0, c = 0, isAddition = true;
        }

        bool isCorrect() {
            if(c == -1) return false;
            if(isAddition && a + b == c) return true;
            if(!isAddition && a - b == c) return true;
            return false;
        }

};

HwProblem parse_line(string problem) {
    string tmp = "";
    HwProblem hw;
    string::iterator itr = problem.begin();
    while(itr != problem.end()) {
        if(*itr == '+') {
            hw.isAddition = true;
            hw.a = stoi(tmp);
            tmp = "";
        } else if(*itr == '-') {
            hw.isAddition = false;
            hw.a = stoi(tmp);
            tmp = "";
        } else if(*itr == '?') {
            hw.c = -1;
            return hw;
        } else if(*itr == '=') {
            hw.b = stoi(tmp);
            tmp = "";
        } else {
            tmp += *itr;
        }
        itr += 1;
    }
    hw.c = stoi(tmp);
    return hw;
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    int correct = 0;
    string problem;

    // return 0;

    while(getline(cin, problem)) {
        // cout << problem << "\n";
        HwProblem hw = parse_line(problem);
        if(hw.isCorrect()) correct += 1;
    }
    cout << correct << "\n";

    return 0;
}

#endif