/*
    https://www.udebug.com/UVa/11278
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
map<char, char> keyboard;
void populateKeyboard() {
    keyboard['4'] = 'q';    keyboard['q'] = '4'; keyboard['a'] = '7';
    keyboard['5'] = 'j';    keyboard['w'] = '5'; keyboard['s'] = '8';
    keyboard['6'] = 'l';    keyboard['e'] = '6'; keyboard['d'] = '9';
    keyboard['7'] = 'm';    keyboard['r'] = '.'; keyboard['f'] = 'a';
    keyboard['8'] = 'f';    keyboard['t'] = 'o'; keyboard['g'] = 'e';
    keyboard['9'] = 'p';    keyboard['y'] = 'r'; keyboard['h'] = 'h';
    keyboard['0'] = '/';    keyboard['u'] = 's'; keyboard['j'] = 't';
    keyboard['-'] = '[';    keyboard['i'] = 'u'; keyboard['k'] = 'd';
    keyboard['='] = ']';    keyboard['o'] = 'y'; keyboard['l'] = 'c';
    keyboard['z'] = '0';    keyboard['p'] = 'b'; keyboard[';'] = 'k';
    keyboard['x'] = 'z';    keyboard['['] = ';'; keyboard['\''] = '-';
    keyboard['c'] = 'x';    keyboard[']'] = '='; keyboard['Q'] = '$';
    keyboard['v'] = ',';    keyboard['$'] = 'Q'; keyboard['W'] = '%';
    keyboard['b'] = 'i';    keyboard['&'] = 'M'; keyboard['E'] = '^';
    keyboard['n'] = 'n';    keyboard['%'] = 'J'; keyboard['R'] = '>';
    keyboard['m'] = 'w';    keyboard['^'] = 'L'; keyboard['T'] = 'O';
    keyboard[','] = 'v';    keyboard['*'] = 'F'; keyboard['Y'] = 'R';
    keyboard['.'] = 'g';    keyboard['('] = 'P'; keyboard['U'] = 'S';
    keyboard['/'] = '\'';   keyboard[')'] = '?'; keyboard['I'] = 'U';
    keyboard['A'] = '&';    keyboard['_'] = '{'; keyboard['O'] = 'Y';
    keyboard['S'] = '*';    keyboard['+'] = '}'; keyboard['P'] = 'B';
    keyboard['D'] = '(';    keyboard['H'] = 'H'; keyboard['{'] = ':';
    keyboard['F'] = 'A';    keyboard['J'] = 'T'; keyboard['}'] = '+';
    keyboard['G'] = 'E';    keyboard['K'] = 'D'; keyboard['L'] = 'C';
    keyboard[':'] = 'K';    keyboard['Z'] = ')'; keyboard['C'] = 'X';
    keyboard['\"']= '_';    keyboard['X'] = 'Z'; keyboard['V'] = '<';
    keyboard['B'] = 'I';    keyboard['N'] = 'N'; keyboard['M'] = 'W';
    keyboard['<'] = 'V';    keyboard['>'] = 'G'; keyboard['?'] = '\"';
}

void convert_and_print(string line) {
    for(unsigned int i = 0; i < line.length(); i++) {
        auto it = keyboard.find(line[i]); 
        if(it != keyboard.end()) {
            cout << it->second;
        } else {
            cout << line[i];
        }
    }
    cout << "\n";
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    populateKeyboard();
    string line;

    while(getline(cin, line)) {
        convert_and_print(line);
    }
    // convert_and_print(line);

    return 0;
}

#endif