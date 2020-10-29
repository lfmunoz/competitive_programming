/*

https://www.udebug.com/UVa/10058

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

#if !defined(IS_TEST)

int main() {
    initialize();

    string line;

    string VERB = "(hate|love|know|like)s*";
    string NOUN = "(tom|jerry|goofy|mickey|jimmy|dog|cat|mouse)";
    string ARTICLE = "(a|the)";
    string ACTOR = "(" + NOUN + "|" + ARTICLE + " " + NOUN + ")";
    string ACTIVE_LIST = "(" + ACTOR + " and )*" + ACTOR;
    string ACTION = ACTIVE_LIST + " " + VERB + " " + ACTIVE_LIST;
    string STATEMENT = ACTION + "( , " + ACTION + ")*";

    while(getline(cin, line)) {
        line = regex_replace(line, regex(" +"), " ");
        regex color_regex(STATEMENT);
        if(regex_match(line, color_regex)) {
            cout << "YES I WILL" << "\n";
        } else {
            cout << "NO I WON'T" << "\n";
        }
    }

    return 0;
}

#endif