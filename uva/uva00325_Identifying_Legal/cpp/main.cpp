/*

https://www.udebug.com/UVa/325


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

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________
string START_END = "___________";

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;

    string reg_expression = "^\\s*[+-]?[0-9]+(\\.[0-9]+|(\\.[0-9]+)?[eE][+-]?[0-9]+)$";

    while(getline(cin, line)) {
        if(line == "*") break;

        line = regex_replace(line, regex("^[ ]+"), "");
        regex number_regex(reg_expression);
        if(regex_match(line, number_regex)) {
            cout << line << " is legal." << "\n";
        } else {
            cout << line << " is illegal." << "\n";
        }
    }


    return 0;
}

#endif