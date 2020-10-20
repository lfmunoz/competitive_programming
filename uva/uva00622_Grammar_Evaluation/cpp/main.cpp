/*

  https://www.udebug.com/UVa/622
    Let's write a recursive descent parser in C (Part 1)
    https://www.youtube.com/watch?v=N55XNj8KjC4
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
int parse_integer(string::iterator  &itr, string::iterator end) ;
int parse_factor(string::iterator  &itr, string::iterator end);
int parse_expression(string::iterator  &itr, string::iterator end);
int parse_component(string::iterator  &itr, string::iterator end);

int parse_integer(string::iterator  &itr, string::iterator end) {
    string number = "";
    while(isdigit(*itr)) {
        number += *itr;
        itr++;
    }
    return stoi(number);
}

int parse_factor(string::iterator  &itr, string::iterator end) {
    // cout << "factor" << *itr << endl;
    if (isdigit(*itr)) {
        return parse_integer(itr, end);
    } else if ( *itr == '(') {
        itr += 1;
        int result = parse_expression(itr, end);
        if(*itr != ')') throw "Didn't find matching )" ;
        itr += 1;
        return result;
    }
    throw "Failed to parse factor";
}

int parse_expression(string::iterator  &itr, string::iterator end) {
    int component = parse_component(itr, end);
    if(*itr == '+') {
        itr += 1;
        return component + parse_expression(itr, end);
    } else {
        return component;
    }
}

int parse_component(string::iterator  &itr, string::iterator end) {
    int factor = parse_factor(itr, end);
    if(*itr == '*') {
        itr += 1;
        return factor * parse_component(itr, end);
    } else {
        return factor;
    }
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;
    int N;

    cin >> N >> ws;
    for(int n = 0; n < N; n++) {
        getline(cin, line);
        // cout << line << endl;
        string::iterator itr = line.begin();
        try {
            int result = parse_expression(itr, line.end());
            if(itr != line.end()) throw "parsing didn't finish";
            cout << result << "\n";
        } catch (...) {
            cout << "ERROR" << "\n";
        }
    }

    return 0;
}

#endif