/*

https://www.udebug.com/UVa/494

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
vector<string> split(string str, char delimiter = ' ') {
    string token;
    istringstream ss(str); // insert the string into tokenizer
    vector<string> tokens; // vector tokens holds the tokens
    while(getline(ss, token, delimiter)) tokens.push_back(token) ;
    return tokens;
}

int countMatchInRegex(std::string s, std::string re)
{
    regex words_regex(re);
    auto words_begin = sregex_iterator(s.begin(), s.end(), words_regex);
    auto words_end = sregex_iterator();

//   while (words_begin!=words_end) {
    // std::cout << words_begin->str() << std::endl;
    // ++words_begin;
//   }

    return std::distance(words_begin, words_end);
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;

    string wordRegex = "([a-zA-Z])+";


    while(getline(cin, line)) {
        cout << (countMatchInRegex (line, wordRegex) ) << "\n";
    }


    return 0;
}

#endif